package com.suqizhao.questionStore.service.impl;

import com.suqizhao.questionStore.entity.NoticeMsg;
import com.suqizhao.questionStore.mapper.NoticeMsgMapper;
import com.suqizhao.questionStore.service.NoticeMsgService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.NoticeMsgPageParam;
import com.suqizhao.framework.pagination.PageUtil;
import com.suqizhao.questionStore.vo.NoticeMsgQueryVo;
import com.suqizhao.framework.common.service.impl.BaseServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import java.io.Serializable;


/**
 * <pre>
 * 通知公告表 服务实现类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-27
 */
@Slf4j
@Service
public class NoticeMsgServiceImpl extends BaseServiceImpl<NoticeMsgMapper, NoticeMsg> implements NoticeMsgService {

    @Autowired
    private NoticeMsgMapper noticeMsgMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveNoticeMsg(NoticeMsg noticeMsg) throws Exception {
        return super.save(noticeMsg);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateNoticeMsg(NoticeMsg noticeMsg) throws Exception {
        return super.updateById(noticeMsg);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteNoticeMsg(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public NoticeMsgQueryVo getNoticeMsgById(Serializable id) throws Exception {
        return noticeMsgMapper.getNoticeMsgById(id);
    }

    @Override
    public Paging<NoticeMsgQueryVo> getNoticeMsgPageList(NoticeMsgPageParam noticeMsgPageParam) throws Exception {
        Page page = PageUtil.getPage(noticeMsgPageParam, OrderItem.desc(getLambdaColumn(NoticeMsg::getCreateTime)));
        IPage<NoticeMsgQueryVo> iPage = noticeMsgMapper.getNoticeMsgPageList(page, noticeMsgPageParam);
        return new Paging(iPage);
    }

}
