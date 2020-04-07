package com.suqizhao.questionStore.service.impl;

import com.suqizhao.questionStore.entity.QuestionInfo;
import com.suqizhao.questionStore.mapper.QuestionInfoMapper;
import com.suqizhao.questionStore.service.QuestionInfoService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionInfoPageParam;
import com.suqizhao.framework.pagination.PageUtil;
import com.suqizhao.questionStore.vo.QuestionInfoQueryVo;
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
 * 问题信息表 服务实现类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-07
 */
@Slf4j
@Service
public class QuestionInfoServiceImpl extends BaseServiceImpl<QuestionInfoMapper, QuestionInfo> implements QuestionInfoService {

    @Autowired
    private QuestionInfoMapper questionInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveQuestionInfo(QuestionInfo questionInfo) throws Exception {
        return super.save(questionInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateQuestionInfo(QuestionInfo questionInfo) throws Exception {
        return super.updateById(questionInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteQuestionInfo(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public QuestionInfoQueryVo getQuestionInfoById(Serializable id) throws Exception {
        return questionInfoMapper.getQuestionInfoById(id);
    }

    @Override
    public Paging<QuestionInfoQueryVo> getQuestionInfoPageList(QuestionInfoPageParam questionInfoPageParam) throws Exception {
        Page page = PageUtil.getPage(questionInfoPageParam, OrderItem.desc(getLambdaColumn(QuestionInfo::getCreateTime)));
        IPage<QuestionInfoQueryVo> iPage = questionInfoMapper.getQuestionInfoPageList(page, questionInfoPageParam);
        return new Paging(iPage);
    }

}
