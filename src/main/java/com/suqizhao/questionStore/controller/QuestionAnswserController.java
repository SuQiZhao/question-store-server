package com.suqizhao.questionStore.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suqizhao.questionStore.entity.QuestionAnswser;
import com.suqizhao.questionStore.service.QuestionAnswserService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionAnswserPageParam;
import com.suqizhao.questionStore.vo.QuestionAnswserQueryVo;
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

import java.util.Date;

/**
 * <pre>
 *  前端控制器
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-26
 */
@Slf4j
@RestController
@RequestMapping("/questionAnswser")
@Api(" API")
public class QuestionAnswserController extends BaseController {

    @Autowired
    private QuestionAnswserService questionAnswserService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加QuestionAnswser对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addQuestionAnswser(@Validated @RequestBody QuestionAnswser questionAnswser) throws Exception {
        boolean flag = questionAnswserService.saveQuestionAnswser(questionAnswser);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改QuestionAnswser对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateQuestionAnswser(@Validated @RequestBody QuestionAnswser questionAnswser) throws Exception {
        boolean flag = questionAnswserService.updateQuestionAnswser(questionAnswser);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除QuestionAnswser对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteQuestionAnswser(@PathVariable("id") Long id) throws Exception {
        boolean flag = questionAnswserService.deleteQuestionAnswser(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取QuestionAnswser对象详情", notes = "查看", response = QuestionAnswserQueryVo.class)
    public ApiResult<QuestionAnswserQueryVo> getQuestionAnswser(@PathVariable("id") Long id) throws Exception {
        QuestionAnswserQueryVo questionAnswserQueryVo = questionAnswserService.getQuestionAnswserById(id);
        return ApiResult.ok(questionAnswserQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取QuestionAnswser分页列表", notes = "分页列表", response = QuestionAnswserQueryVo.class)
    public ApiResult<Paging<QuestionAnswserQueryVo>> getQuestionAnswserPageList(@Validated @RequestBody QuestionAnswserPageParam questionAnswserPageParam) throws Exception {
        Paging<QuestionAnswserQueryVo> paging = questionAnswserService.getQuestionAnswserPageList(questionAnswserPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 根据条件获取回答分页接口
     */

    @GetMapping("/findAnswserPage")
    @ApiOperation(value = "根据条件获取回答分页接口", notes = "根据条件获取回答分页接口",response = QuestionAnswserQueryVo.class)
    public ApiResult<Paging<QuestionAnswser>> findAnswserPage(@ApiParam(required = true, name = "current", value = "当前页") @RequestParam(value = "current", required = true, defaultValue = "1") Long current,
                                                            @ApiParam(required = true, name = "size", value = "分页大小") @RequestParam(value = "size", required = true, defaultValue = "10") Long size,
                                                            @ApiParam(required = false, name = "questionId", value = "问题ID") @RequestParam(value = "questionId", required = false,defaultValue = "") String questionId,
                                                            @ApiParam(required = false, name = "userId", value = "用户ID") @RequestParam(value = "userId", required = false,defaultValue = "") String userId,
                                                            @ApiParam(required = false, name = "isBest", value = "题目状态") @RequestParam(value = "isBest", required = false,defaultValue = "") String isBest) throws Exception {
        Page<QuestionAnswserQueryVo> paging = questionAnswserService.findAnswserPage(size,current,questionId,userId,isBest);
        return ApiResult.ok(paging);
    }

}

