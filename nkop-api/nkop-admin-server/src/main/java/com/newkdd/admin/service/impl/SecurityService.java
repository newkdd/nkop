package com.newkdd.admin.service.impl;

import com.newkdd.admin.dao.SysUserDAO;
import com.newkdd.admin.model.po.SysUserPO;
import com.newkdd.framework.config.Constant;
import com.newkdd.framework.security.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mike on 2018/4/13.
 */
@Service
@Transactional
public class SecurityService implements UserDetailsService {

    @Autowired
    SysUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUserPO searchPO = new SysUserPO();
        searchPO.setUsername(s);
        searchPO.setDeleted(Constant.DB.DELETED.NO);
        SysUserPO sysUserPO = userDAO.selectOne(searchPO);
        if (sysUserPO == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        //TODO
        UserInfo userInfo = new UserInfo();
        userInfo.setId(sysUserPO.getId());
        userInfo.setUsername(sysUserPO.getUsername());
        userInfo.setPassword(sysUserPO.getPassword());
        userInfo.setEnabled(Constant.DB.ENABLED.YES == sysUserPO.getEnabled());
        return userInfo;
    }

}
