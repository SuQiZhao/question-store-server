package com.suqizhao.questionStore.param;


import io.geekidea.springbootplus.framework.pagination.BasePageOrderParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 用户信息管理表 查询参数对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-03-31
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserPageParam对象", description = "用户信息管理表查询参数")
public class UserPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
