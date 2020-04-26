package com.suqizhao.questionStore.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suqizhao.questionStore.entity.QuestionInfo;
import com.suqizhao.framework.common.service.BaseService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionInfoPageParam;
import com.suqizhao.questionStore.vo.QuestionInfoQueryVo;

import java.io.Serializable;
import java.util.Date;
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
    QuestionInfo getQuestionInfoById(Serializable id) throws Exception;

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

    /**
     *
     * @param size
     * @param current
     * @param createUserIdentity
     * @param questionCategory
     * @return
     * @throws Exception
     */
    Paging<QuestionInfoQueryVo> getQuestionPage(Long size, Long current, String createUserIdentity, String questionCategory) throws Exception;

    /**
     * 根据问题条件查询分页
     * @param current
     * @param size
     * @param questionCategory
     * @param questionTitle
     * @param createUserIdentity
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    Page<QuestionInfoQueryVo> findQuestionPage(Long current, Long size,String createUserIdentity, String questionCategory, String questionTitle, Date startDate, Date endDate,String isResolve) throws Exception;
}
