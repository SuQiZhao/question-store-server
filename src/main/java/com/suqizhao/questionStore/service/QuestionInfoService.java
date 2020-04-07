package com.suqizhao.questionStore.service;

import com.suqizhao.questionStore.entity.QuestionInfo;
import com.suqizhao.framework.common.service.BaseService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionInfoPageParam;
import com.suqizhao.questionStore.vo.QuestionInfoQueryVo;

import java.io.Serializable;

/**
 * <pre>
 * 问题信息表 服务类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-07
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

}
