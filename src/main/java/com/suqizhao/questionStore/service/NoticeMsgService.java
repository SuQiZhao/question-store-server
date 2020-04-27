package com.suqizhao.questionStore.service;

import com.suqizhao.questionStore.entity.NoticeMsg;
import com.suqizhao.framework.common.service.BaseService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.NoticeMsgPageParam;
import com.suqizhao.questionStore.vo.NoticeMsgQueryVo;

import java.io.Serializable;

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
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteNoticeMsg(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    NoticeMsgQueryVo getNoticeMsgById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param noticeMsgPageParam
     * @return
     * @throws Exception
     */
    Paging<NoticeMsgQueryVo> getNoticeMsgPageList(NoticeMsgPageParam noticeMsgPageParam) throws Exception;

}
