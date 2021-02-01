package com.six.map.inch.controller;

import com.six.map.common.entity.Page;
import com.six.map.common.entity.R;
import com.six.map.inch.entity.DtMapNameEntity;
import com.six.map.inch.service.DtMapNameService;
import com.six.map.modules.sys.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Ryan<>
 */
@RestController
@RequestMapping("/dituapi/tool")
@Slf4j
@Api(value = "", tags = {""})
public class DtMapNameController extends AbstractController {

    @Autowired
    private DtMapNameService dtMapNameService;

    /**
     * 列表
     *
     * @param
     * @return
     */
    @PostMapping("/getmaplist")
    @ApiOperation(value = "列表", notes = "列表")
    public R list(@RequestBody Map<String, Object> param) {
        return dtMapNameService.listEntity(param);
    }

    /**
     * 新增
     *
     * @param dtMapName
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody DtMapNameEntity dtMapName) {
        return dtMapNameService.saveEntity(dtMapName);
    }

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    @PostMapping("/info")
    public R getById(@RequestBody Long id) {
        return dtMapNameService.getEntityById(id);
    }

    /**
     * 修改
     *
     * @param dtMapName
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody DtMapNameEntity dtMapName) {
        return dtMapNameService.updateEntity(dtMapName);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping("/remove")
    public R batchRemove(@RequestBody Long[] id) {
        return dtMapNameService.batchRemove(id);
    }

}
