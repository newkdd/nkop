package com.newkdd.admin.service.impl;

import com.newkdd.admin.dao.SysResourceDAO;
import com.newkdd.admin.model.dto.ResourceTreeDTO;
import com.newkdd.admin.model.entity.SysResourceRole;
import com.newkdd.admin.model.po.SysResourcePO;
import com.newkdd.admin.service.ISysResourceService;
import com.newkdd.framework.basic.BasicServiceImpl;
import com.newkdd.framework.exception.BizException;
import com.newkdd.framework.security.SecurityHelper;
import com.newkdd.framework.util.BeanUtils;
import com.newkdd.framework.util.tree.Node;
import com.newkdd.framework.util.tree.TreeBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import tk.mybatis.mapper.common.Mapper;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class SysResourceServiceImpl extends BasicServiceImpl<SysResourcePO> implements ISysResourceService {

    @Autowired
    SysResourceDAO sysResourceDAO;

    @Override
    public Mapper<SysResourcePO> getMapper() {
        return sysResourceDAO;
    }

    @Override
    public List<SysResourceRole> getResourceRoles() {
        return sysResourceDAO.getResourceRoles();
    }

    @Override
    public List<ResourceTreeDTO> getResourceByUser() {
//        if(null == SecurityHelper.getCurrentUser()) {
//            throw new BizException("EK.ERR.401002");
//        }
        List<SysResourcePO> resourcePOS = sysResourceDAO.getResourceByUserId("1");
        List<ResourceTreeDTO> resourceTreeDTOS = BeanUtils.copyList(resourcePOS,ResourceTreeDTO.class);
        TreeBuilder<ResourceTreeDTO> treeBuilder = new TreeBuilder<>(resourceTreeDTOS);
        return treeBuilder.buildTree();
    }
}
