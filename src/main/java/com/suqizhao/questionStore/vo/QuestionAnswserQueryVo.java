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
 *  查询结果对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-04-26
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "QuestionAnswserQueryVo对象", description = "查询参数")
public class QuestionAnswserQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编码")
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