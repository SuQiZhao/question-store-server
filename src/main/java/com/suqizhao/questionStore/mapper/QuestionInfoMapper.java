package com.suqizhao.questionStore.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suqizhao.questionStore.entity.QuestionInfo;
import com.suqizhao.questionStore.param.QuestionInfoPageParam;
import com.suqizhao.questionStore.vo.QuestionInfoQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 问题信息表 Mapper 接口
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-09
 */
@Repository
public interface QuestionInfoMapper extends BaseMapper<QuestionInfo> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    QuestionInfoQueryVo getQuestionInfoById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param questionInfoPageParam
     * @return
     */
    IPage<QuestionInfoQueryVo> getQuestionInfoPageList(@Param("page") Page page, @Param("param") QuestionInfoPageParam questionInfoPageParam);


    /**
     * 获取热门问题
     * @return
     */
    List<QuestionInfoQueryVo> getHotQuestionList();

    /**
     *
     * @param page
     * @param createUserIdentity
     * @param questionCategory
     * @param questionTitle
     * @param startDate
     * @param endDate
     * @return
     */
    Page<QuestionInfoQueryVo> findQuestionPage(@Param("page") Page page,
                                                @Param("createUserIdentity") String createUserIdentity,
                                                @Param("questionCategory") String questionCategory,
                                                @Param("questionTitle") String questionTitle,
                                                @Param("startDate") Date startDate,
                                                @Param("endDate") Date endDate);
}
