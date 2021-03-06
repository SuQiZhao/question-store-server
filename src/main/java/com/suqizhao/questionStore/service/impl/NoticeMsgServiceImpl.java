package com.suqizhao.questionStore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suqizhao.questionStore.entity.NoticeMsg;
import com.suqizhao.questionStore.mapper.NoticeMsgMapper;
import com.suqizhao.questionStore.service.NoticeMsgService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.NoticeMsgPageParam;
import com.suqizhao.framework.pagination.PageUtil;
import com.suqizhao.questionStore.vo.NoticeMsgQueryVo;
import com.suqizhao.framework.common.service.impl.BaseServiceImpl;

import com.suqizhao.questionStore.vo.QuestionAnswserQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import java.io.Serializable;
import java.util.Date;


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
        Date currentTime = new Date();
        noticeMsg.setCreateTime(currentTime);
        return super.save(noticeMsg);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateNoticeMsg(NoticeMsg noticeMsg) throws Exception {
        Date currentTime = new Date();
        noticeMsg.setUpdateTime(currentTime);
        return super.updateById(noticeMsg);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteNoticeMsg(String unid) throws Exception {
        QueryWrapper<NoticeMsg> qw = new QueryWrapper<>();
        qw.eq("unid",unid);
        return super.remove(qw);
    }

    @Override
    public NoticeMsg getNoticeMsgById(Serializable unid) throws Exception {
        QueryWrapper<NoticeMsg> qw = new QueryWrapper<>();
        return noticeMsgMapper.selectById(unid);
    }

    @Override
    public Paging<NoticeMsgQueryVo> getNoticeMsgPageList(NoticeMsgPageParam noticeMsgPageParam) throws Exception {
        Page page = PageUtil.getPage(noticeMsgPageParam, OrderItem.desc(getLambdaColumn(NoticeMsg::getCreateTime)));
        IPage<NoticeMsgQueryVo> iPage = noticeMsgMapper.getNoticeMsgPageList(page, noticeMsgPageParam);
        return new Paging(iPage);
    }

    @Override
    public Page<NoticeMsgQueryVo> findNoticePage(Long size, Long current, String username, String userId, Date startDate, Date endDate) throws Exception {
        Page page = new Page(current,size);
        Page<NoticeMsgQueryVo> noticeMsgQueryVoPage =noticeMsgMapper.findNoticePage(page,username,userId,startDate,endDate);
        return noticeMsgQueryVoPage;
    }

}
