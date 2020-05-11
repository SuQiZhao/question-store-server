package com.suqizhao.questionStore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 全国大学信息表
 * </pre>
 *
 * @author sqizhao
 * @since 2020-05-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CollageList对象", description = "全国大学信息表")
public class CollageList extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "id", type = IdType.AUTO)
    private Integer id;

@NotBlank(message = "不能为空")
    private String collageName;

@NotBlank(message = "不能为空")
    private String area;

@NotBlank(message = "不能为空")
    private String type;

@NotBlank(message = "不能为空")
    private String properties;

}
