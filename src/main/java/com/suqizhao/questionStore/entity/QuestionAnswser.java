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
 * 
 * </pre>
 *
 * @author sqizhao
 * @since 2020-04-26
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "QuestionAnswser对象", description = "")
public class QuestionAnswser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编码")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("题目id")
    private Integer questionId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("用户级别")
    private Integer userLevel;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("赞")
    private String like;

    @ApiModelProperty("是否最佳答案")
    private String isBest;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("逻辑删除，0：未删除，1：已删除")
    private Integer deleteFlag;

}
