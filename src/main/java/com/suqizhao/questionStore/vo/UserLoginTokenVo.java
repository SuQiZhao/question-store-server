package com.suqizhao.questionStore.vo;

import com.suqizhao.questionStore.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@ApiModel("登陆User信息TokenVO")
public class UserLoginTokenVo implements Serializable {

    private static final long serialVersionUID = 2648146787200109380L;

    @ApiModelProperty("token")
    private String token;

    /**
     * 登陆用户对象
     */
    private User user;
}
