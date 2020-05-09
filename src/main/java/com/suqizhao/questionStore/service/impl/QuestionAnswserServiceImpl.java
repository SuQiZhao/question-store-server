package com.suqizhao.questionStore.service.impl;

import com.suqizhao.questionStore.entity.QuestionAnswser;
import com.suqizhao.questionStore.mapper.QuestionAnswserMapper;
import com.suqizhao.questionStore.service.QuestionAnswserService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionAnswserPageParam;
import com.suqizhao.framework.pagination.PageUtil;
import com.suqizhao.questionStore.vo.QuestionAnswserQueryVo;
import com.suqizhao.framework.common.service.impl.BaseServiceImpl;

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
 *  服务实现类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-26
 */
@Slf4j
@Service
public class QuestionAnswserServiceImpl extends BaseServiceImpl<QuestionAnswserMapper, QuestionAnswser> implements QuestionAnswserService {

    @Autowired
    private QuestionAnswserMapper questionAnswserMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveQuestionAnswser(QuestionAnswser questionAnswser) throws Exception {
        Date currentTime = new Date();
        questionAnswser.setCreateTime(currentTime);
        questionAnswser.setDeleteFlag(0);
        return super.save(questionAnswser);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateQuestionAnswser(QuestionAnswser questionAnswser) throws Exception {
        Date currentTime = new Date();
        questionAnswser.setUpdateTime(currentTime);
        return super.updateById(questionAnswser);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteQuestionAnswser(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public QuestionAnswserQueryVo getQuestionAnswserById(Serializable id) throws Exception {
        return questionAnswserMapper.getQuestionAnswserById(id);
    }

    @Override
    public Paging<QuestionAnswserQueryVo> getQuestionAnswserPageList(QuestionAnswserPageParam questionAnswserPageParam) throws Exception {
        Page page = PageUtil.getPage(questionAnswserPageParam, OrderItem.desc(getLambdaColumn(QuestionAnswser::getCreateTime)));
        IPage<QuestionAnswserQueryVo> iPage = questionAnswserMapper.getQuestionAnswserPageList(page, questionAnswserPageParam);
        return new Paging(iPage);
    }

    @Override
    public Page<QuestionAnswserQueryVo> findAnswserPage(Long size, Long current, String questionId, String userId, String isBest,String questionTitle,String content,Date startDate, Date endDate) {
        Page page = new Page(current,size);
        Page<QuestionAnswserQueryVo> questionInfoQueryVoPage =questionAnswserMapper.findAnswserPage(page,questionId,userId,isBest,questionTitle,content,startDate,endDate);
        return questionInfoQueryVoPage;
    }

}
