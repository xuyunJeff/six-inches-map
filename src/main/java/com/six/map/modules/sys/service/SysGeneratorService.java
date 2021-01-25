package com.six.map.modules.sys.service;

import com.six.map.modules.sys.entity.GeneratorParamEntity;
import com.six.map.modules.sys.entity.TableEntity;
import com.six.map.common.entity.Page;

import java.util.Map;

/**
 * 代码生成器
 *
 * @author zcl<yczclcn@163.com>
 */
public interface SysGeneratorService {

    /**
     * 分页查询表格
     *
     * @param params
     * @return
     */
    Page<TableEntity> listTable(Map<String, Object> params);

    /**
     * 生成代码
     *
     * @param params
     * @return
     */
    byte[] generator(GeneratorParamEntity params);

}
