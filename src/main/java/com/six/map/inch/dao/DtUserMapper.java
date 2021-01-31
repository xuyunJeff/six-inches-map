package com.six.map.inch.dao;

import com.six.map.common.mapper.AutoBaseMapper;
import com.six.map.inch.entity.DtUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表
 *
 * @author Ryan<>
 */
@Mapper
public interface DtUserMapper extends AutoBaseMapper<DtUserEntity> {
    List<Long> selectInIds(List<Long> id);
}
