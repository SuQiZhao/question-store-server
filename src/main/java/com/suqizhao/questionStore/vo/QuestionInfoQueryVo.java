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
 * 问题信息表 查询结果对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-04-09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "QuestionInfoQueryVo对象", description = "问题信息表查询参数")
public class QuestionInfoQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一标识")
    private Integer cdId;

    @ApiModelProperty("问题标题")
    private String questionTitle;

    @ApiModelProperty("问题类别")
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
    private Integer deleteFlag;

    @ApiModelProperty("创建者唯一标识")
    private String createUserIdentity;

    @ApiModelProperty("阅读量")
    private String reading;

    @ApiModelProperty("是否解决：0：未解决，1：已解决, 2：已关闭")
    private Integer isResolve;

    @ApiModelProperty("解决用户ID")
    private String resolveUser;

}