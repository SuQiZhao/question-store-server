package com.suqizhao.questionStore.service;

import com.suqizhao.questionStore.entity.User;
import com.suqizhao.framework.common.service.BaseService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.UserPageParam;
import com.suqizhao.questionStore.vo.UserQueryVo;

import java.io.Serializable;

/**
 * <pre>
 * 用户信息管理表 服务类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-08
 */
public interface UserService extends BaseService<User> {

    /**
     * 保存
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean saveUser(User user) throws Exception;

    /**
     * 修改
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean updateUser(User user) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUser(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserQueryVo getUserById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param userPageParam
     * @return
     * @throws Exception
     */
    Paging<UserQueryVo> getUserPageList(UserPageParam userPageParam) throws Exception;

    User getUserByUsername(String username) throws Exception;
}
