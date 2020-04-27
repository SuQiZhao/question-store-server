package com.suqizhao.questionStore.controller;

import com.suqizhao.questionStore.entity.NoticeMsg;
import com.suqizhao.questionStore.service.NoticeMsgService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.NoticeMsgPageParam;
import com.suqizhao.questionStore.vo.NoticeMsgQueryVo;
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

/**
 * <pre>
 * 通知公告表 前端控制器
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-27
 */
@Slf4j
@RestController
@RequestMapping("/noticeMsg")
@Api("通知公告表 API")
public class NoticeMsgController extends BaseController {

    @Autowired
    private NoticeMsgService noticeMsgService;

    /**
     * 添加通知公告表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加NoticeMsg对象", notes = "添加通知公告表", response = ApiResult.class)
    public ApiResult<Boolean> addNoticeMsg(@Validated @RequestBody NoticeMsg noticeMsg) throws Exception {
        boolean flag = noticeMsgService.saveNoticeMsg(noticeMsg);
        return ApiResult.result(flag);
    }

    /**
     * 修改通知公告表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改NoticeMsg对象", notes = "修改通知公告表", response = ApiResult.class)
    public ApiResult<Boolean> updateNoticeMsg(@Validated @RequestBody NoticeMsg noticeMsg) throws Exception {
        boolean flag = noticeMsgService.updateNoticeMsg(noticeMsg);
        return ApiResult.result(flag);
    }

    /**
     * 删除通知公告表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除NoticeMsg对象", notes = "删除通知公告表", response = ApiResult.class)
    public ApiResult<Boolean> deleteNoticeMsg(@PathVariable("id") Long id) throws Exception {
        boolean flag = noticeMsgService.deleteNoticeMsg(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取通知公告表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取NoticeMsg对象详情", notes = "查看通知公告表", response = NoticeMsgQueryVo.class)
    public ApiResult<NoticeMsgQueryVo> getNoticeMsg(@PathVariable("id") Long id) throws Exception {
        NoticeMsgQueryVo noticeMsgQueryVo = noticeMsgService.getNoticeMsgById(id);
        return ApiResult.ok(noticeMsgQueryVo);
    }

    /**
     * 通知公告表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取NoticeMsg分页列表", notes = "通知公告表分页列表", response = NoticeMsgQueryVo.class)
    public ApiResult<Paging<NoticeMsgQueryVo>> getNoticeMsgPageList(@Validated @RequestBody NoticeMsgPageParam noticeMsgPageParam) throws Exception {
        Paging<NoticeMsgQueryVo> paging = noticeMsgService.getNoticeMsgPageList(noticeMsgPageParam);
        return ApiResult.ok(paging);
    }

}

