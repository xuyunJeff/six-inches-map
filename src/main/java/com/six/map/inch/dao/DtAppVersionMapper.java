package com.six.map.inch.dao;

import com.six.map.common.mapper.AutoBaseMapper;
import com.six.map.inch.entity.DtAppVersionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ryan<>
 */
@Mapper
public interface DtAppVersionMapper extends AutoBaseMapper<DtAppVersionEntity> {
    List<Long> selectInIds(List<Long> id);
}
