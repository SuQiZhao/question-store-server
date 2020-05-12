package com.suqizhao.questionStore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suqizhao.questionStore.entity.NoticeMsg;
import com.suqizhao.framework.common.service.BaseService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.NoticeMsgPageParam;
import com.suqizhao.questionStore.vo.NoticeMsgQueryVo;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 通知公告表 服务类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-27
 */
public interface NoticeMsgService extends BaseService<NoticeMsg> {

    /**
     * 保存
     *
     * @param noticeMsg
     * @return
     * @throws Exception
     */
    boolean saveNoticeMsg(NoticeMsg noticeMsg) throws Exception;

    /**
     * 修改
     *
     * @param noticeMsg
     * @return
     * @throws Exception
     */
    boolean updateNoticeMsg(NoticeMsg noticeMsg) throws Exception;

    /**
     * 删除
     *
     * @param unid
     * @return
     * @throws Exception
     */
    boolean deleteNoticeMsg(String unid) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    NoticeMsg getNoticeMsgById(Serializable unid) throws Exception;

    /**
     * 获取分页对象
     *
     * @param noticeMsgPageParam
     * @return
     * @throws Exception
     */
    Paging<NoticeMsgQueryVo> getNoticeMsgPageList(NoticeMsgPageParam noticeMsgPageParam) throws Exception;

    Page<NoticeMsgQueryVo> findNoticePage(Long size, Long current, String username, String userId, Date startDate, Date endDate) throws Exception;
}
