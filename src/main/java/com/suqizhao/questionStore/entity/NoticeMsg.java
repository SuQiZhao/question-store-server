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
 * 通知公告表
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-27
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "NoticeMsg对象", description = "通知公告表")
public class NoticeMsg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编码")
    @TableId(value = "unid", type = IdType.AUTO)
    private Integer unid;

    @ApiModelProperty("创建用户id")
    private Integer createdUserId;

    @ApiModelProperty("创建用户名")
    private String createdUsername;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("更新用户id")
    private Integer updateUserId;

    @ApiModelProperty("更新用户名")
    private String updateUsername;

    @ApiModelProperty("逻辑删除")
    private Integer deleteFlag;

    @ApiModelProperty("通知标题")
    private String title;

    @ApiModelProperty("通知内容")
    private String content;

}
