package com.suqizhao.questionStore.service;

import com.suqizhao.questionStore.entity.CollageList;
import com.suqizhao.framework.common.service.BaseService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.CollageListPageParam;
import com.suqizhao.questionStore.vo.CollageListQueryVo;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 全国大学信息表 服务类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-05-11
 */
public interface CollageListService extends BaseService<CollageList> {

    /**
     * 保存
     *
     * @param collageList
     * @return
     * @throws Exception
     */
    boolean saveCollageList(CollageList collageList) throws Exception;

    /**
     * 修改
     *
     * @param collageList
     * @return
     * @throws Exception
     */
    boolean updateCollageList(CollageList collageList) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteCollageList(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    CollageListQueryVo getCollageListById(Serializable id) throws Exception;

    List<CollageList> getCollageName(String collageName) throws Exception;
}
