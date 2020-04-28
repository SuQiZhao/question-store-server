package com.suqizhao.questionStore.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suqizhao.questionStore.entity.NoticeMsg;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.NoticeMsgPageParam;
import com.suqizhao.questionStore.vo.NoticeMsgQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 通知公告表 Mapper 接口
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-27
 */
@Repository
public interface NoticeMsgMapper extends BaseMapper<NoticeMsg> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    NoticeMsgQueryVo getNoticeMsgById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param noticeMsgPageParam
     * @return
     */
    IPage<NoticeMsgQueryVo> getNoticeMsgPageList(@Param("page") Page page, @Param("param") NoticeMsgPageParam noticeMsgPageParam);

    Page<NoticeMsgQueryVo> findNoticePage(@Param("page") Page page,
                                          @Param("username") String username,
                                          @Param("userId") String userId,
                                          @Param("startDate") Date startDate,
                                          @Param("endDate") Date endDate);
}
