package com.six.map.modules.sys.dao;

import java.util.List;

import com.six.map.common.entity.Page;
import com.six.map.common.entity.Query;
import com.six.map.modules.sys.entity.ColumnEntity;
import com.six.map.modules.sys.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 代码生成器
 *
 * @author zcl<yczclcn@163.com>
 */
@Mapper
public interface SysGeneratorMapper {

    /**
     * 查询所有表格
     *
     * @param page
     * @param query
     * @return
     */
    List<TableEntity> listTable(Page<TableEntity> page, Query query);

    /**
     * 根据名称查询
     *
     * @param tableName
     * @return
     */
    TableEntity getTableByName(String tableName);

    /**
     * 查询所有列
     *
     * @param tableName
     * @return
     */
    List<ColumnEntity> listColumn(String tableName);

}
