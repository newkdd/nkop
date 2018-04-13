package com.newkdd.admin.dao;

import com.newkdd.admin.model.po.SysRolePO;
import com.newkdd.framework.basic.BasicDAO;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mike on 2018/4/13.
 */
public interface SysRoleDAO extends BasicDAO<SysRolePO> {
    /**
     * 根据用户编码获取角色清单
     * @param userId * 用户编码
     * @return 角色列表
     */
    List<SysRolePO> getRolesByUserId(@Param("userId")String userId);
}
