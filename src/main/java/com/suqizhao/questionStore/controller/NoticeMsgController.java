package com.suqizhao.questionStore.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suqizhao.questionStore.entity.NoticeMsg;
import com.suqizhao.questionStore.service.NoticeMsgService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.NoticeMsgPageParam;
import com.suqizhao.questionStore.vo.NoticeMsgQueryVo;
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
    @PostMapping("/delete")
    @ApiOperation(value = "删除NoticeMsg对象", notes = "删除通知公告表", response = ApiResult.class)
    public ApiResult<Boolean> deleteNoticeMsg(@ApiParam(required = true, name = "unid", value = "唯一编号") @RequestParam(value = "unid", required = true, defaultValue = "") String unid) throws Exception {
        boolean flag = noticeMsgService.deleteNoticeMsg(unid);
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
    /**
     * 根据条件获取通知公告分页接口
     */

    @GetMapping("/findNoticePage")
    @ApiOperation(value = "根据条件获取通知公告分页接口", notes = "根据条件获取通知公告分页接口",response = NoticeMsgQueryVo.class)
    public ApiResult<Paging<NoticeMsg>> findNoticePage(@ApiParam(required = true, name = "current", value = "当前页") @RequestParam(value = "current", required = true, defaultValue = "1") Long current,
                                                       @ApiParam(required = true, name = "size", value = "分页大小") @RequestParam(value = "size", required = true, defaultValue = "10") Long size,
                                                       @ApiParam(required = false, name = "username", value = "用户名") @RequestParam(value = "username", required = false,defaultValue = "") String username,
                                                       @ApiParam(required = false, name = "userId", value = "用户ID") @RequestParam(value = "userId", required = false,defaultValue = "") String userId,
                                                       @ApiParam(required = false, name = "startDate", value = "开始日期") @RequestParam(value = "startDate", required = false,defaultValue = "") Date startDate,
                                                       @ApiParam(required = false, name = "endDate", value = "结束日期") @RequestParam(value = "endDate", required = false,defaultValue = "") Date endDate) throws Exception {
        Page<NoticeMsgQueryVo> paging = noticeMsgService.findNoticePage(size,current,username,userId,startDate,endDate);
        return ApiResult.ok(paging);
    }
}

