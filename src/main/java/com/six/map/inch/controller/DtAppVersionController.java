package com.six.map.inch.controller;

import com.six.map.common.entity.Page;
import com.six.map.common.entity.R;
import com.six.map.inch.entity.DtAppVersionEntity;
import com.six.map.inch.service.DtAppVersionService;
import com.six.map.modules.sys.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/user/profile")
@Slf4j
@Api(value = "", tags = {""})
public class DtAppVersionController extends AbstractController {

    @Autowired
    private DtAppVersionService dtAppVersionService;

    /**
     * 列表
     *
     * @param
     * @return
     */
    @PostMapping("/version")
    @ApiOperation(value = "获取APP版本", notes = "获取APP版本")
    public R list() {
        return dtAppVersionService.getLastestVersion();
    }

    /**
     * 新增
     *
     * @param dtAppVersion
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody DtAppVersionEntity dtAppVersion) {
        return dtAppVersionService.saveEntity(dtAppVersion);
    }

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    @PostMapping("/info")
    public R getById(@RequestBody Long id) {
        return dtAppVersionService.getEntityById(id);
    }

    /**
     * 修改
     *
     * @param dtAppVersion
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody DtAppVersionEntity dtAppVersion) {
        return dtAppVersionService.updateEntity(dtAppVersion);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping("/remove")
    public R batchRemove(@RequestBody Long[] id) {
        return dtAppVersionService.batchRemove(id);
    }

}
