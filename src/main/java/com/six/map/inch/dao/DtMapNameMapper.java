package com.six.map.inch.dao;

import com.six.map.common.mapper.AutoBaseMapper;
import com.six.map.inch.entity.DtMapNameEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ryan<>
 */
@Mapper
public interface DtMapNameMapper extends AutoBaseMapper<DtMapNameEntity> {
    List<Long> selectInIds(List<Long> id);
}
