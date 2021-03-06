package com.suqizhao.questionStore.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suqizhao.questionStore.entity.CollageList;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.CollageListPageParam;
import com.suqizhao.questionStore.vo.CollageListQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 全国大学信息表 Mapper 接口
 * </pre>
 *
 * @author sqizhao
 * @since 2020-05-11
 */
@Repository
public interface CollageListMapper extends BaseMapper<CollageList> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    CollageListQueryVo getCollageListById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param collageListPageParam
     * @return
     */
    IPage<CollageListQueryVo> getCollageListPageList(@Param("page") Page page, @Param("param") CollageListPageParam collageListPageParam);

}
