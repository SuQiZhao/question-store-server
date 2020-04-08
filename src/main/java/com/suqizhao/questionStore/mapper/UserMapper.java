package com.suqizhao.questionStore.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suqizhao.questionStore.entity.User;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.UserPageParam;
import com.suqizhao.questionStore.vo.UserQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 用户信息管理表 Mapper 接口
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-08
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    UserQueryVo getUserById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param userPageParam
     * @return
     */
    IPage<UserQueryVo> getUserPageList(@Param("page") Page page, @Param("param") UserPageParam userPageParam);

}
