package com.suqizhao.questionStore.param;

import com.suqizhao.framework.pagination.BasePageOrderParam;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 全国大学信息表 查询参数对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-05-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CollageListPageParam对象", description = "全国大学信息表查询参数")
public class CollageListPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
