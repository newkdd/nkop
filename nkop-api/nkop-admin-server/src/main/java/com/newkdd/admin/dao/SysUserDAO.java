package com.newkdd.admin.dao;

import com.newkdd.admin.model.po.SysUserPO;
import com.newkdd.framework.basic.BasicDAO;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mike on 2018/4/12.
 */
public interface SysUserDAO extends BasicDAO<SysUserPO>{
    /**
     * 按分页查收数据
     * @param record
     * @return
     */
    List<SysUserPO> selectPage(@Param("record") SysUserPO record);
}
