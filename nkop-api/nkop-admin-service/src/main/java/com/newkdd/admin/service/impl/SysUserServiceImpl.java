package com.newkdd.admin.service.impl;

import com.newkdd.admin.model.po.SysUserPO;
import com.newkdd.admin.service.ISysUserService;
import com.newkdd.admin.dao.SysUserDAO;
import com.newkdd.framework.basic.BasicServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Mike on 2018/4/12.
 */
@Service
public class SysUserServiceImpl extends BasicServiceImpl<SysUserPO> implements ISysUserService{
    @Autowired
    private SysUserDAO sysUserDAO;
    public Mapper<SysUserPO> getMapper() {
        return sysUserDAO;
    }
}
