package com.suqizhao.questionStore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <pre>
 * 问题信息表 服务实现类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-09
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

    @Override
    public List<QuestionInfoQueryVo> getHotQuestionList() throws Exception {
        return questionInfoMapper.getHotQuestionList();
    }

    @Override
    public int getAllQuestionCount() throws Exception {
        QueryWrapper<QuestionInfo> qw = new QueryWrapper<>();
        qw.eq("delete_flag",0);
        return questionInfoMapper.selectCount(qw);
    }

    @Override
    public int getAllResolveQuestion() throws Exception {
        QueryWrapper<QuestionInfo> qw = new QueryWrapper<>();
        qw.eq("delete_flag",0);
        qw.eq("is_resolve",1);
        return questionInfoMapper.selectCount(qw);
    }

    @Override
    public int getAllNotResolveQuestionCount() {
        QueryWrapper<QuestionInfo> qw = new QueryWrapper<>();
        qw.eq("delete_flag",0);
        qw.eq("is_resolve",0).or().isNull("is_resolve");
        return questionInfoMapper.selectCount(qw);
    }

}
