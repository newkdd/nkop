package com.newkdd.admin.service.impl;

import com.newkdd.admin.dao.SysResourceDAO;
import com.newkdd.admin.model.entity.SysResourceRole;
import com.newkdd.admin.model.po.SysResourcePO;
import com.newkdd.admin.service.ISysResourceService;
import com.newkdd.framework.basic.BasicServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
