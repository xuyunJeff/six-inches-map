package com.six.map.common.mapper;

import com.six.map.modules.sys.dao.BaseMapper;
import com.six.map.common.entity.AutoBaseEntity;
import tk.mybatis.mapper.common.Mapper;

public interface AutoBaseMapper<E extends AutoBaseEntity> extends BaseMapper<E>, Mapper<E> {

}
