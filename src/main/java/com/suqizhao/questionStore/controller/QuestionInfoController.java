package com.suqizhao.questionStore.controller;

import com.suqizhao.questionStore.entity.QuestionInfo;
import com.suqizhao.questionStore.service.QuestionInfoService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionInfoPageParam;
import com.suqizhao.questionStore.vo.QuestionInfoQueryVo;
import com.suqizhao.framework.common.api.ApiResult;
import com.suqizhao.framework.common.controller.BaseController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import com.suqizhao.framework.common.param.IdParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 问题信息表 前端控制器
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-09
 */
@Slf4j
@RestController
@RequestMapping("/questionInfo")
@Api("问题信息表 API")
public class QuestionInfoController extends BaseController {

    @Autowired
    private QuestionInfoService questionInfoService;

    /**
     * 添加问题信息表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加QuestionInfo对象", notes = "添加问题信息表", response = ApiResult.class)
    public ApiResult<Boolean> addQuestionInfo(@Validated @RequestBody QuestionInfo questionInfo) throws Exception {
        boolean flag = questionInfoService.saveQuestionInfo(questionInfo);
        return ApiResult.result(flag);
    }

    /**
     * 修改问题信息表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改QuestionInfo对象", notes = "修改问题信息表", response = ApiResult.class)
    public ApiResult<Boolean> updateQuestionInfo(@Validated @RequestBody QuestionInfo questionInfo) throws Exception {
        boolean flag = questionInfoService.updateQuestionInfo(questionInfo);
        return ApiResult.result(flag);
    }

    /**
     * 删除问题信息表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除QuestionInfo对象", notes = "删除问题信息表", response = ApiResult.class)
    public ApiResult<Boolean> deleteQuestionInfo(@PathVariable("id") Long id) throws Exception {
        boolean flag = questionInfoService.deleteQuestionInfo(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取问题信息表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取QuestionInfo对象详情", notes = "查看问题信息表", response = QuestionInfoQueryVo.class)
    public ApiResult<QuestionInfoQueryVo> getQuestionInfo(@PathVariable("id") Long id) throws Exception {
        QuestionInfoQueryVo questionInfoQueryVo = questionInfoService.getQuestionInfoById(id);
        return ApiResult.ok(questionInfoQueryVo);
    }

    /**
     * 问题信息表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取QuestionInfo分页列表", notes = "问题信息表分页列表", response = QuestionInfoQueryVo.class)
    public ApiResult<Paging<QuestionInfoQueryVo>> getQuestionInfoPageList(@Validated @RequestBody QuestionInfoPageParam questionInfoPageParam) throws Exception {
        Paging<QuestionInfoQueryVo> paging = questionInfoService.getQuestionInfoPageList(questionInfoPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 获取热门问题
     */

    @GetMapping("/getHotQuestionList")
    @ApiOperation(value = "获取热门问题列表", notes = "热门问题信息表分页列表",response = QuestionInfoQueryVo.class)
    public ApiResult<Paging<QuestionInfoQueryVo>> getHotQuestionList() throws Exception {
        List data = questionInfoService.getHotQuestionList();
        return ApiResult.ok(data);
    }

    @GetMapping("/getQuestionCount")
    @ApiOperation(value = "获取问题统计接口", notes = "获取问题统计接口",response = ApiResult.class)
    public ApiResult getQuestionCount () throws  Exception {
        //全部问题
        int allQuestionCount = questionInfoService.getAllQuestionCount();
        //已解决
        int resolveQuestionCount = questionInfoService.getAllResolveQuestion();
        //未解决
        int notResolveQuestionCount = questionInfoService.getAllNotResolveQuestionCount();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("allQuestionCount",allQuestionCount);
        resultMap.put("resolveQuestionCount",resolveQuestionCount);
        resultMap.put("notResolveQuestionCount",notResolveQuestionCount);
        return ApiResult.ok(resultMap);
    }
}

