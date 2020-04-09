package com.suqizhao.questionStore.param;

import com.suqizhao.framework.pagination.BasePageOrderParam;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 问题信息表 查询参数对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-04-09
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "QuestionInfoPageParam对象", description = "问题信息表查询参数")
public class QuestionInfoPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
