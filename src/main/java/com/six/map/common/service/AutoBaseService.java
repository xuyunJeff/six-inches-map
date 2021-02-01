package com.six.map.common.service;

import com.six.map.common.utils.CommonUtils;
import com.six.map.common.utils.ShiroUtils;
import com.six.map.inch.entity.DtUserEntity;
import com.six.map.modules.sys.dao.SysOrgMapper;
import com.six.map.modules.sys.dao.SysRoleMapper;
import com.six.map.modules.sys.dao.SysUserMapper;
import com.six.map.modules.sys.dao.SysUserRoleMapper;
import com.six.map.modules.sys.entity.SysUserEntity;
import com.six.map.common.constant.SystemConstant;
import com.six.map.common.entity.AutoBaseEntity;
import com.six.map.common.entity.Page;
import com.six.map.common.entity.Query;
import com.six.map.common.entity.R;
import com.six.map.common.exception.RRException;
import com.six.map.common.mapper.AutoBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by zhy on 2020/8/13.
 */
public abstract class AutoBaseService<M extends AutoBaseMapper, E extends AutoBaseEntity> {

    @Autowired
    protected M mapper;

    /*@Autowired
    protected SysUserMapper sysUserMapper;

    @Autowired
    protected SysRoleMapper sysRoleMapper;

    @Autowired
    protected SysOrgMapper sysOrgMapper;

    @Autowired
    protected SysUserRoleMapper userRoleMapper;*/


    @Autowired
    protected StringRedisTemplate stringRedisTemplate;


    /**
     * 分页查询
     *
     * @param
     * @return
     */
    public R listEntity(Map<String, Object> param) {
        Query query = new Query(param);
        Page<E> page = new Page<>(query);
        mapper.listForPage(page, query);
        return CommonUtils.change(page);
    }

    /**
     * 新增
     *
     * @param
     * @return
     */
    public R saveEntity(E entity) {
        DtUserEntity user = (DtUserEntity) entity;
        String mobile = user.getMobile();
        Object userDto = mapper.getObjectById(mobile);
        int count = 0;
        if (userDto == null) {
            count = mapper.insert(entity);
        }
        return CommonUtils.msg(count);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public R getEntityById(Long id) {
        Object blockBankCard = mapper.selectByPrimaryKey(id);
        return CommonUtils.msg(blockBankCard);
    }

    /**
     * 修改
     *
     * @param
     * @return
     */
    public R updateEntity(E e) {
        int count = mapper.updateByPrimaryKeySelective(e);
        return CommonUtils.msg(count);
    }

    public R remove(Long id) {
        int count = mapper.remove(id);
        return CommonUtils.msg(count);
    }

    public R batchRemove(Long[] ids) {
        int count = mapper.batchRemove(ids);
        return CommonUtils.msg(count);
    }

    public List<E> select(E e) {
        return mapper.select(e);
    }

    public E selectOne(E e) {
        List<E> list = mapper.select(e);
        if (list.isEmpty()) return null;
        return list.get(0);
    }


    /**
     * 获取系统当前登陆用户
     *
     * @return
     */
    protected SysUserEntity getCurrentUser() {
        return ShiroUtils.getUserEntity();
    }

    /**
     * 判断是否是机构管理员
     *
     * @return
     */
    protected boolean isOrgAdmin() {
        SysUserEntity userEntity = getCurrentUser();
        return SystemConstant.RoleEnum.Organization.getCode().equals(userEntity.getRoleId());
    }

    /**
     * 判断是否是出款员
     *
     * @return
     */
    protected boolean isBusiness() {
        SysUserEntity userEntity = getCurrentUser();
        return SystemConstant.RoleEnum.CustomerService.getCode().equals(userEntity.getRoleId());
    }
    /**
     * 判断是否商户
     * @return
     */
    protected boolean isOutMerchant(){
        SysUserEntity userEntity = getCurrentUser();
        return SystemConstant.RoleEnum.BillOutMerchant.getCode().equals(userEntity.getRoleId());
    }

    /**
     * 判断是否是指定机构管理员机构管理员
     *
     * @return
     */
    protected boolean isOrgAdmin(Long orgId) {
        SysUserEntity userEntity = getCurrentUser();
        if (userEntity.getOrgId().equals(orgId)) {
            return SystemConstant.RoleEnum.Organization.getCode().equals(userEntity.getRoleId());
        }
        return false;
    }

    /**
     * 查询指定用户
     *
     * @param userId
     * @return
     */
    /*protected SysUserEntity getUserById(Long userId) {
        if (userId == null || userId == 0L) {
            throw new RRException("查询user时，userId不能为空");
        }
        SysUserEntity userEntity = sysUserMapper.getObjectById(userId);
        userEntity.setRoleIdList(userRoleMapper.listUserRoleId(userEntity.getUserId()));
        userEntity.setRoleNameList(sysRoleMapper.listUserRoleNames(userEntity.getRoleId()));
        Optional.ofNullable(sysOrgMapper.getObjectById(userEntity.getOrgId())).ifPresent(org->userEntity.setOrgName(org.getName()));
        return userEntity;
    }*/

}
