package com.suqizhao.questionStore.controller;

import com.suqizhao.questionStore.entity.CollageList;
import com.suqizhao.questionStore.service.CollageListService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.CollageListPageParam;
import com.suqizhao.questionStore.vo.CollageListQueryVo;
import com.suqizhao.framework.common.api.ApiResult;
import com.suqizhao.framework.common.controller.BaseController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import com.suqizhao.framework.common.param.IdParam;

import java.util.List;

/**
 * <pre>
 * 全国大学信息表 前端控制器
 * </pre>
 *
 * @author sqizhao
 * @since 2020-05-11
 */
@Slf4j
@RestController
@RequestMapping("/collageList")
@Api("全国大学信息表 API")
public class CollageListController extends BaseController {

    @Autowired
    private CollageListService collageListService;

    /**
     * 添加全国大学信息表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加CollageList对象", notes = "添加全国大学信息表", response = ApiResult.class)
    public ApiResult<Boolean> addCollageList(@Validated @RequestBody CollageList collageList) throws Exception {
        boolean flag = collageListService.saveCollageList(collageList);
        return ApiResult.result(flag);
    }

    /**
     * 修改全国大学信息表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改CollageList对象", notes = "修改全国大学信息表", response = ApiResult.class)
    public ApiResult<Boolean> updateCollageList(@Validated @RequestBody CollageList collageList) throws Exception {
        boolean flag = collageListService.updateCollageList(collageList);
        return ApiResult.result(flag);
    }

    /**
     * 删除全国大学信息表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除CollageList对象", notes = "删除全国大学信息表", response = ApiResult.class)
    public ApiResult<Boolean> deleteCollageList(@PathVariable("id") Long id) throws Exception {
        boolean flag = collageListService.deleteCollageList(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取全国大学信息表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取CollageList对象详情", notes = "查看全国大学信息表", response = CollageListQueryVo.class)
    public ApiResult<CollageListQueryVo> getCollageList(@PathVariable("id") Long id) throws Exception {
        CollageListQueryVo collageListQueryVo = collageListService.getCollageListById(id);
        return ApiResult.ok(collageListQueryVo);
    }

    /**
     * 获取全国大学信息表
     */
    @GetMapping("/getCollageName")
    @ApiOperation(value = "获取全国大学名称对象详情", notes = "获取全国大学名称对象详情", response = CollageListQueryVo.class)
    public ApiResult<CollageListQueryVo> getCollageName(@ApiParam(required = false, name = "collageName", value = "大学名称") @RequestParam(value = "collageName", required = false,defaultValue = "")String collageName) throws Exception {
        List collageList = collageListService.getCollageName(collageName);
        return ApiResult.ok(collageList);
    }
}

