package com.newkdd.admin.service.impl;

import com.newkdd.admin.dao.SysRoleDAO;
import com.newkdd.admin.model.po.SysRolePO;
import com.newkdd.admin.service.ISysRoleService;
import com.newkdd.framework.basic.BasicServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.common.Mapper;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class SysRoleServiceImpl extends BasicServiceImpl<SysRolePO> implements ISysRoleService {

    @Autowired
    SysRoleDAO sysRoleDAO;

    @Override
    public Mapper<SysRolePO> getMapper() {
        return sysRoleDAO;
    }
}
