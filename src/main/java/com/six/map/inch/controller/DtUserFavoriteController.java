package com.six.map.inch.controller;

import com.six.map.common.entity.Page;
import com.six.map.common.entity.R;
import com.six.map.inch.entity.DtUserFavoriteEntity;
import com.six.map.inch.service.DtUserFavoriteService;
import com.six.map.modules.sys.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户收藏表
 *
 * @author Ryan<>
 */
@RestController
@RequestMapping("/user/favorite")
@Slf4j
@Api(value = "", tags = {""})
public class DtUserFavoriteController extends AbstractController {

    @Autowired
    private DtUserFavoriteService dtUserFavoriteService;

    /**
     * 列表
     *
     * @param
     * @return
     */
    @PostMapping("/index")
    @ApiOperation(value = "列表", notes = "列表")
    public R list(@RequestBody Map<String, Object> param) {
        return dtUserFavoriteService.listEntity(param);
    }

    /**
     * 新增
     *
     * @param dtUserFavorite
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody DtUserFavoriteEntity dtUserFavorite) {
        return dtUserFavoriteService.saveEntity(dtUserFavorite);
    }

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询详情", notes = "根据id查询详情")
    public R getById(@RequestBody Long id) {
        return dtUserFavoriteService.getEntityById(id);
    }

    /**
     * 修改
     *
     * @param dtUserFavorite
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody DtUserFavoriteEntity dtUserFavorite) {
        return dtUserFavoriteService.updateEntity(dtUserFavorite);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "用户删除地图收藏点", notes = "用户删除地图收藏点")
    @GetMapping("/deleteFavorite")
    public R remove(@ApiParam(name = "id", value = "收藏ID") @RequestParam Long id) {
        return dtUserFavoriteService.remove(id);
    }

}
