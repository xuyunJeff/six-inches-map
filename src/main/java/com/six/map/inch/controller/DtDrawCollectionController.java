package com.six.map.inch.controller;

import com.six.map.common.entity.Page;
import com.six.map.common.entity.R;
import com.six.map.inch.entity.DtDrawCollectionEntity;
import com.six.map.inch.service.DtDrawCollectionService;
import com.six.map.modules.sys.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Ryan<>
 */
@RestController
@RequestMapping("/user/collection")
@Slf4j
@Api(value = "", tags = {""})
public class DtDrawCollectionController extends AbstractController {

    @Autowired
    private DtDrawCollectionService dtDrawCollectionService;

    /**
     * 列表
     *
     * @param
     * @return
     */
    @PostMapping("/index")
    @ApiOperation(value = "获取我的标注列表", notes = "获取我的标注列表")
    public Page<DtDrawCollectionEntity> list(@RequestBody Map<String, Object> param) {
        return dtDrawCollectionService.listEntity(param);
    }

    /**
     * 新增
     *
     * @param dtDrawCollection
     * @return
     */
    @ApiOperation(value = "添加标注", notes = "添加标注")
    @PostMapping("/save")
    public R save(@RequestBody DtDrawCollectionEntity dtDrawCollection) {
        return dtDrawCollectionService.saveEntity(dtDrawCollection);
    }

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    @PostMapping("/info")
    public R getById(@RequestBody Long id) {
        return dtDrawCollectionService.getEntityById(id);
    }

    /**
     * 修改
     *
     * @param dtDrawCollection
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody DtDrawCollectionEntity dtDrawCollection) {
        return dtDrawCollectionService.updateEntity(dtDrawCollection);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "用户删除标注", notes = "用户删除标注")
    @GetMapping("/remove")
    public R remove(@ApiParam(name = "id", value = "收藏ID") @RequestParam Long id) {
        return dtDrawCollectionService.remove(id);
    }

}
