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
 * 全国大学信息表 查询结果对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-05-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CollageListQueryVo对象", description = "全国大学信息表查询参数")
public class CollageListQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private Integer id;

private String collageName;

private String area;

private String type;

private String properties;

}