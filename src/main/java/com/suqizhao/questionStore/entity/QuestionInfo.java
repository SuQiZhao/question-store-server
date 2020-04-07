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
 * 问题信息表
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-07
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "QuestionInfo对象", description = "问题信息表")
public class QuestionInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一标识")
    @TableId(value = "cd_id", type = IdType.AUTO)
private String cdId;

    @ApiModelProperty("问题标题")
    @NotBlank(message = "问题标题不能为空")
    private String questionTitle;

    @ApiModelProperty("问题类别")
    @NotBlank(message = "问题类别不能为空")
    private String questionCategory;

    @ApiModelProperty("问题内容")
    private String questionDetail;

    @ApiModelProperty("问题附件")
    private String questionAttachment;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更改时间")
    private Date updatedTime;

    @ApiModelProperty("删除标识（0未删除，1已删除）")
    @NotNull(message = "删除标识（0未删除，1已删除）不能为空")
    private Integer deleteFlag;

    @ApiModelProperty("创建者唯一标识")
    private String createUserIdentity;

    @ApiModelProperty("阅读量")
    private String reading;

}
