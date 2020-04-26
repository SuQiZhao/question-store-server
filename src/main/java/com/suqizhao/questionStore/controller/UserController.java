package com.suqizhao.questionStore.controller;

import com.suqizhao.questionStore.entity.User;
import com.suqizhao.questionStore.service.UserService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.UserPageParam;
import com.suqizhao.questionStore.vo.UserQueryVo;
import com.suqizhao.framework.common.api.ApiResult;
import com.suqizhao.framework.common.controller.BaseController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import com.suqizhao.framework.common.param.IdParam;

/**
 * <pre>
 * 用户信息管理表 前端控制器
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-08
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api("用户信息管理表 API")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户信息管理表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加User对象", notes = "添加用户信息管理表", response = ApiResult.class)
    public ApiResult<Boolean> addUser(@Validated @RequestBody User user) throws Exception {
        boolean flag = userService.saveUser(user);
        return ApiResult.result(flag);
    }

    /**
     * 修改用户信息管理表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改User对象", notes = "修改用户信息管理表", response = ApiResult.class)
    public ApiResult<Boolean> updateUser(@Validated @RequestBody User user) throws Exception {
        boolean flag = userService.updateUser(user);
        return ApiResult.result(flag);
    }

    /**
     * 删除用户信息管理表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除User对象", notes = "删除用户信息管理表", response = ApiResult.class)
    public ApiResult<Boolean> deleteUser(@PathVariable("id") Long id) throws Exception {
        boolean flag = userService.deleteUser(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取用户信息管理表
     */
    @GetMapping("/info")
    @ApiOperation(value = "获取User对象详情", notes = "查看用户信息管理表", response = UserQueryVo.class)
    public ApiResult<User> getUser(@ApiParam(required = true, name = "id", value = "唯一编码") @RequestParam(value = "id", required = true) String id) throws Exception {
        User user = userService.getUserById(id);
        return ApiResult.ok(user);
    }

    /**
     * 用户信息管理表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取User分页列表", notes = "用户信息管理表分页列表", response = UserQueryVo.class)
    public ApiResult<Paging<UserQueryVo>> getUserPageList(@Validated @RequestBody UserPageParam userPageParam) throws Exception {
        Paging<UserQueryVo> paging = userService.getUserPageList(userPageParam);
        return ApiResult.ok(paging);
    }

}

