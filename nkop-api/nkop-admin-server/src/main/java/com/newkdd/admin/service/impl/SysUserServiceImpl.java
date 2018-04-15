package com.newkdd.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newkdd.admin.model.po.SysUserPO;
import com.newkdd.admin.service.ISysUserService;
import com.newkdd.admin.dao.SysUserDAO;
import com.newkdd.framework.basic.BasicServiceImpl;
import com.newkdd.framework.exception.BizException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

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

    @Override
    public int save(SysUserPO record) throws BizException {
        //新增加密密码
        if(null!=record && StringUtils.isBlank(record.getId())){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encode = encoder.encode(record.getPassword());
            record.setPassword(encode);
        }
        return super.save(record);
    }

    /**
     * (单表分页可排序)
     * @param pageNum 当前页
     * @param pageSize 页码
     * @param record 对象
     * @return PageInfo 分页对象
     */
    @Override
    public PageInfo<SysUserPO> selectPage(int pageNum, int pageSize, SysUserPO record)  throws BizException {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUserPO> list = sysUserDAO.selectPage(record);
        return new PageInfo<SysUserPO>(list);
    }

}
