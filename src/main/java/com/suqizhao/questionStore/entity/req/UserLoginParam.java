package com.suqizhao.questionStore.entity.req;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录请求参数
 */
@Data
@ApiModel("登录参数")
public class UserLoginParam {
    @NotBlank(message = "请输入账号")
    @ApiModelProperty("账号")
    private String username;

    @NotBlank(message = "请输入密码")
    @ApiModelProperty("密码")
    private String password;

}
