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
 * 通知公告表 查询结果对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-04-27
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "NoticeMsgQueryVo对象", description = "通知公告表查询参数")
public class NoticeMsgQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编码")
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