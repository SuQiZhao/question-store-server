package com.suqizhao.questionStore.service;

import com.suqizhao.questionStore.entity.QuestionInfo;
import com.suqizhao.framework.common.service.BaseService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionInfoPageParam;
import com.suqizhao.questionStore.vo.QuestionInfoQueryVo;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 问题信息表 服务类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-09
 */
public interface QuestionInfoService extends BaseService<QuestionInfo> {

    /**
     * 保存
     *
     * @param questionInfo
     * @return
     * @throws Exception
     */
    boolean saveQuestionInfo(QuestionInfo questionInfo) throws Exception;

    /**
     * 修改
     *
     * @param questionInfo
     * @return
     * @throws Exception
     */
    boolean updateQuestionInfo(QuestionInfo questionInfo) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteQuestionInfo(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    QuestionInfoQueryVo getQuestionInfoById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param questionInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<QuestionInfoQueryVo> getQuestionInfoPageList(QuestionInfoPageParam questionInfoPageParam) throws Exception;


    /**
     * 获取热门问题对象结果集
     * @return
     * @throws Exception
     */
    List<QuestionInfoQueryVo> getHotQuestionList() throws Exception;


    /**
     * 获取问题总数
     * @return
     * @throws Exception
     */
    int getAllQuestionCount() throws Exception;

    int getAllResolveQuestion() throws Exception;

    int getAllNotResolveQuestionCount() throws Exception;

    List<QuestionInfo> getAllDeleteQuestions() throws Exception;
}
