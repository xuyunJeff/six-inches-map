package com.six.map.inch.dao;

import com.six.map.common.mapper.AutoBaseMapper;
import com.six.map.inch.entity.DtUserFavoriteEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户收藏表
 * @author Ryan<>
 */
@Mapper
public interface DtUserFavoriteMapper extends AutoBaseMapper<DtUserFavoriteEntity> {
  List<Long> selectInIds (List<Long> id);
}
