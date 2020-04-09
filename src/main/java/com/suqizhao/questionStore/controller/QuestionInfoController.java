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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * <pre>
 * 问题信息表 前端控制器
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-07
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
}

