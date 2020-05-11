package com.suqizhao.questionStore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suqizhao.questionStore.entity.User;
import com.suqizhao.questionStore.mapper.UserMapper;
import com.suqizhao.questionStore.service.UserService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.UserPageParam;
import com.suqizhao.framework.pagination.PageUtil;
import com.suqizhao.questionStore.vo.UserQueryVo;
import com.suqizhao.framework.common.service.impl.BaseServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import java.io.Serializable;
import java.util.Date;


/**
 * <pre>
 * 用户信息管理表 服务实现类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-08
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveUser(User user) throws Exception {
        Date currentTime = new Date();
        user.setCreateTime(currentTime);
        return super.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUser(User user) throws Exception {
        Date currentTime = new Date();
        user.setUpdatedTime(currentTime);
        return super.updateById(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteUser(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public User getUserById(Serializable id) throws Exception {
        return userMapper.selectById(id);
    }

    @Override
    public Paging<UserQueryVo> getUserPageList(UserPageParam userPageParam) throws Exception {
        Page page = PageUtil.getPage(userPageParam, OrderItem.desc(getLambdaColumn(User::getCreateTime)));
        IPage<UserQueryVo> iPage = userMapper.getUserPageList(page, userPageParam);
        return new Paging(iPage);
    }

    @Override
    public User getUserByUsername(String username) throws Exception {
        User user = new User().setUsername(username);
        return userMapper.selectOne(new QueryWrapper(user));
    }

    @Override
    public Page<UserQueryVo> findUserPage(Long size, Long current, String username, String nickname, String collageName, Date startDate, Date endDate) {
        Page page = new Page(current,size);
        Page<UserQueryVo> userQueryVoPage =userMapper.findUserPage(page,username,nickname,collageName,startDate,endDate);
        return userQueryVoPage;
    }


}
