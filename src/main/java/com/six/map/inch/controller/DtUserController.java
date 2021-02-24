package com.six.map.inch.controller;

import com.six.map.common.entity.Page;
import com.six.map.common.entity.R;
import com.six.map.inch.entity.DtUserEntity;
import com.six.map.inch.service.DtUserService;
import com.six.map.modules.sys.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户表
 *
 * @author Ryan<>
 */
@RestController
@RequestMapping("/dituapi/tool/user")
@Slf4j
@Api(value = "", tags = {""})
public class DtUserController extends AbstractController {

    @Autowired
    private DtUserService dtUserService;

    /**
     * 列表
     *
     * @param
     * @return
     */
    @PostMapping("/list")
    //@ApiOperation(value = "列表", notes = "列表")
    public R list(@RequestBody Map<String, Object> param) {
        return dtUserService.listEntity(param);
    }

    /**
     * 新增
     *
     * @param dtUser
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @ApiParam(name = "用户对象", value = "传入json格式", required = true)
    @PostMapping("/register/doRegister")
    public R save(@RequestBody DtUserEntity dtUser) {

        return dtUserService.saveEntity(dtUser.getId(), dtUser);
    }

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    @PostMapping("/info")
    public R getById(@RequestBody Long id) {
        return dtUserService.getEntityById(id);
    }

    /**
     * 修改
     *
     * @param dtUser
     * @return
     */
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ApiParam(name = "用户对象", value = "传入json格式", required = true)
    @PostMapping("/updateuser")
    public R update(@RequestBody DtUserEntity dtUser) {
        return dtUserService.updateEntity(dtUser);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping("/remove")
    public R batchRemove(@RequestBody Long[] id) {
        return dtUserService.batchRemove(id);
    }

}
