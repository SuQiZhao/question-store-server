package com.suqizhao.questionStore.param;

import com.suqizhao.framework.pagination.BasePageOrderParam;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 *  查询参数对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-04-26
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "QuestionAnswserPageParam对象", description = "查询参数")
public class QuestionAnswserPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
