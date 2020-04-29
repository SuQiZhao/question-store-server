package com.suqizhao.questionStore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suqizhao.questionStore.entity.QuestionAnswser;
import com.suqizhao.framework.common.service.BaseService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionAnswserPageParam;
import com.suqizhao.questionStore.vo.QuestionAnswserQueryVo;

import java.io.Serializable;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-26
 */
public interface QuestionAnswserService extends BaseService<QuestionAnswser> {

    /**
     * 保存
     *
     * @param questionAnswser
     * @return
     * @throws Exception
     */
    boolean saveQuestionAnswser(QuestionAnswser questionAnswser) throws Exception;

    /**
     * 修改
     *
     * @param questionAnswser
     * @return
     * @throws Exception
     */
    boolean updateQuestionAnswser(QuestionAnswser questionAnswser) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteQuestionAnswser(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    QuestionAnswserQueryVo getQuestionAnswserById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param questionAnswserPageParam
     * @return
     * @throws Exception
     */
    Paging<QuestionAnswserQueryVo> getQuestionAnswserPageList(QuestionAnswserPageParam questionAnswserPageParam) throws Exception;

    Page<QuestionAnswserQueryVo> findAnswserPage(Long size, Long current, String questionId, String userId, String isBest,String questionTitle,String content);
}
