package com.suqizhao.questionStore.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suqizhao.questionStore.entity.QuestionAnswser;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.QuestionAnswserPageParam;
import com.suqizhao.questionStore.vo.QuestionAnswserQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *  Mapper 接口
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-26
 */
@Repository
public interface QuestionAnswserMapper extends BaseMapper<QuestionAnswser> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    QuestionAnswserQueryVo getQuestionAnswserById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param questionAnswserPageParam
     * @return
     */
    IPage<QuestionAnswserQueryVo> getQuestionAnswserPageList(@Param("page") Page page, @Param("param") QuestionAnswserPageParam questionAnswserPageParam);

    /**
     *
     * @param page
     * @param questionId
     * @param userId
     * @param isBest
     * @return
     */
    Page<QuestionAnswserQueryVo> findAnswserPage(@Param("page") Page page,
                                                  @Param("questionId") String questionId,
                                                  @Param("userId") String userId,
                                                  @Param("isBest") String isBest,
                                                 @Param("questionTitle") String questionTitle,
                                                 @Param("content") String content,
                                                 @Param("startDate") Date startDate,
                                                 @Param("endDate") Date endDate);
}
