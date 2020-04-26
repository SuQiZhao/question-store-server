package com.suqizhao.questionStore.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suqizhao.questionStore.entity.QuestionInfo;
import com.suqizhao.questionStore.entity.User;
import com.suqizhao.questionStore.service.QuestionInfoService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionInfoPageParam;
import com.suqizhao.questionStore.service.UserService;
import com.suqizhao.questionStore.vo.QuestionInfoQueryVo;
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

    @Autowired
    private UserService userService;

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
    @GetMapping("/info")
    @ApiOperation(value = "获取QuestionInfo对象详情", notes = "查看问题信息表", response = QuestionInfoQueryVo.class)
    public ApiResult<QuestionInfoQueryVo> getQuestionInfo(@ApiParam(required = true, name = "id", value = "唯一编码") @RequestParam(value = "id", required = true) String id) throws Exception {
        QuestionInfo questionInfo = questionInfoService.getQuestionInfoById(id);
        String userId = questionInfo.getCreateUserIdentity();
        User user = userService.getUserById(userId);
        String nickName = user.getNickname();
        questionInfo.setCreateUserIdentity(nickName);
        return ApiResult.ok(questionInfo);
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
     * 获取热门问题接口
     */

    @GetMapping("/getHotQuestionList")
    @ApiOperation(value = "获取热门问题列表", notes = "热门问题信息表分页列表",response = QuestionInfoQueryVo.class)
    public ApiResult<Paging<QuestionInfoQueryVo>> getHotQuestionList() throws Exception {
        List data = questionInfoService.getHotQuestionList();
        return ApiResult.ok(data);
    }

    /**
     * 获取问题统计接口
     * @return
     * @throws Exception
     */
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


    /**
     * 获取热门问题接口
     */

    @GetMapping("/getAllDeleteQuestions")
    @ApiOperation(value = "获取已删除问题列表", notes = "获取已删除问题列表",response = QuestionInfoQueryVo.class)
    public ApiResult<Paging<QuestionInfo>> getAllDeleteQuestions() throws Exception {
        List data = questionInfoService.getHotQuestionList();
        return ApiResult.ok(data);
    }

    /**
     * 根据分类获取问题分页接口
     */

    @GetMapping("/getQuestionPage")
    @ApiOperation(value = "根据分类获取问题分页接口", notes = "根据分类获取问题分页接口",response = QuestionInfoQueryVo.class)
    public ApiResult<Paging<QuestionInfo>> getQuestionPage(@ApiParam(required = true, name = "size", value = "分页大小") @RequestParam(value = "size", required = true, defaultValue = "10") Long size,
                                                           @ApiParam(required = true, name = "current", value = "当前页") @RequestParam(value = "current", required = true, defaultValue = "1") Long current,
                                                           @ApiParam(required = false, name = "createUserIdentity", value = "创建用户ID") @RequestParam(value = "createUserIdentity", required = false) String createUserIdentity,
                                                           @ApiParam(required = false, name = "questionCategory", value = "课程分类") @RequestParam(value = "questionCategory", required = false) String questionCategory) throws Exception {
        Paging<QuestionInfoQueryVo> paging = questionInfoService.getQuestionPage(size,current,createUserIdentity,questionCategory);
        return ApiResult.ok(paging);
    }


    /**
     * 根据条件获取问题分页接口
     */

    @GetMapping("/findQuestionPage")
    @ApiOperation(value = "根据条件获取问题分页接口", notes = "根据条件获取问题分页接口",response = QuestionInfoQueryVo.class)
    public ApiResult<Paging<QuestionInfo>> findQuestionPage(@ApiParam(required = true, name = "current", value = "当前页") @RequestParam(value = "current", required = true, defaultValue = "1") Long current,
                                                            @ApiParam(required = true, name = "size", value = "分页大小") @RequestParam(value = "size", required = true, defaultValue = "10") Long size,
                                                            @ApiParam(required = false, name = "createUserIdentity", value = "创建用户ID") @RequestParam(value = "createUserIdentity", required = false,defaultValue = "") String createUserIdentity,
                                                            @ApiParam(required = false, name = "questionCategory", value = "课程分类") @RequestParam(value = "questionCategory", required = false,defaultValue = "") String questionCategory,
                                                            @ApiParam(required = false, name = "questionTitle", value = "题目标题") @RequestParam(value = "questionTitle", required = false,defaultValue = "") String questionTitle,
                                                            @ApiParam(required = false, name = "startDate", value = "开始日期") @RequestParam(value = "startDate", required = false,defaultValue = "") Date startDate,
                                                            @ApiParam(required = false, name = "endDate", value = "结束日期") @RequestParam(value = "endDate", required = false,defaultValue = "") Date endDate,
                                                            @ApiParam(required = false, name = "isResolve", value = "题目状态") @RequestParam(value = "isResolve", required = false,defaultValue = "") String isResolve) throws Exception {
        Page<QuestionInfoQueryVo> paging = questionInfoService.findQuestionPage(size,current,createUserIdentity,questionCategory,questionTitle,startDate,endDate,isResolve);
        return ApiResult.ok(paging);
    }
}

