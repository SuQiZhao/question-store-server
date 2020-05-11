package com.suqizhao.questionStore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suqizhao.questionStore.entity.CollageList;
import com.suqizhao.questionStore.mapper.CollageListMapper;
import com.suqizhao.questionStore.service.CollageListService;
import com.suqizhao.framework.pagination.Paging;
import com.suqizhao.questionStore.param.CollageListPageParam;
import com.suqizhao.framework.pagination.PageUtil;
import com.suqizhao.questionStore.vo.CollageListQueryVo;
import com.suqizhao.framework.common.service.impl.BaseServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import java.io.Serializable;
import java.util.List;


/**
 * <pre>
 * 全国大学信息表 服务实现类
 * </pre>
 *
 * @author sqizhao
 * @since 2020-05-11
 */
@Slf4j
@Service
public class CollageListServiceImpl extends BaseServiceImpl<CollageListMapper, CollageList> implements CollageListService {

    @Autowired
    private CollageListMapper collageListMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveCollageList(CollageList collageList) throws Exception {
        return super.save(collageList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateCollageList(CollageList collageList) throws Exception {
        return super.updateById(collageList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteCollageList(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public CollageListQueryVo getCollageListById(Serializable id) throws Exception {
        return collageListMapper.getCollageListById(id);
    }

    @Override
    public List<CollageList> getCollageName(String collageName) throws Exception {
        QueryWrapper<CollageList> qw = new QueryWrapper<>();
        qw.like("collage_name",collageName);
        return collageListMapper.selectList(qw);
    }

}
