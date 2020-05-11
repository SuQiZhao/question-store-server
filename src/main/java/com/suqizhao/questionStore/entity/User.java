package com.suqizhao.questionStore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.suqizhao.framework.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <pre>
 * 用户信息管理表
 * </pre>
 *
 * @author sqizhao
 * @since 2020-05-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "User对象", description = "用户信息管理表")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一标识")
    @TableId(value = "cd_id", type = IdType.AUTO)
    private Integer cdId;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty("所属学校")
    @NotBlank(message = "所属学校不能为空")
    private String collageName;

    @ApiModelProperty("所属专业")
    @NotBlank(message = "所属专业不能为空")
    private String majorName;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号码")
    private String telephone;

    @ApiModelProperty("性别：0：女，1：男，默认1")
    private Integer gender;

    @ApiModelProperty("状态：0：启用，1：禁用）")
    @NotNull(message = "状态：0：启用，1：禁用）不能为空")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更改时间")
    private Date updatedTime;

    @ApiModelProperty("登陆时间")
    private Date loginTime;

    @ApiModelProperty("逻辑删除：0：未删除，1：已删除，默认0")
    @NotNull(message = "逻辑删除：0：未删除，1：已删除，默认0不能为空")
    private Integer deleteFlag;

    @ApiModelProperty("用户类型：1：用户、学生，2：教师，3：管理员")
    @NotNull(message = "用户类型：1：用户、学生，2：教师，3：管理员不能为空")
    private Integer userLevel;

    @ApiModelProperty("盐值")
    private String salt;

}
