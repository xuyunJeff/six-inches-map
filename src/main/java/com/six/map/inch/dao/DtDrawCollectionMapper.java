package com.six.map.inch.dao;

import com.six.map.common.mapper.AutoBaseMapper;
import com.six.map.inch.entity.DtDrawCollectionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * @author Ryan<>
 */
@Mapper
public interface DtDrawCollectionMapper extends AutoBaseMapper<DtDrawCollectionEntity> {
  List<Long> selectInIds (List<Long> id);
}
