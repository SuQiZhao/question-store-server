package com.suqizhao.questionStore.param;

import com.suqizhao.framework.pagination.BasePageOrderParam;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 通知公告表 查询参数对象
 * </pre>
 *
 * @author sqizhao
 * @date 2020-04-27
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "NoticeMsgPageParam对象", description = "通知公告表查询参数")
public class NoticeMsgPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
