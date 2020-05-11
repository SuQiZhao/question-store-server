package com.suqizhao.questionStore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 用户信息管理表 查询结果对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-05-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserQueryVo对象", description = "用户信息管理表查询参数")
public class UserQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一标识")
    private Integer cdId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("所属学校")
    private String collageName;

    @ApiModelProperty("所属专业")
    private String majorName;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号码")
    private String telephone;

    @ApiModelProperty("性别：0：女，1：男，默认1")
    private Integer gender;

    @ApiModelProperty("状态：0：启用，1：禁用）")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更改时间")
    private Date updatedTime;

    @ApiModelProperty("登陆时间")
    private Date loginTime;

    @ApiModelProperty("逻辑删除：0：未删除，1：已删除，默认0")
    private Integer deleteFlag;

    @ApiModelProperty("用户类型：1：用户、学生，2：教师，3：管理员")
    private Integer userLevel;

    @ApiModelProperty("盐值")
    private String salt;

}