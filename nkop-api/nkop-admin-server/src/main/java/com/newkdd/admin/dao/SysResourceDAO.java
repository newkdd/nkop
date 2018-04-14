package com.newkdd.admin.dao;

import com.newkdd.admin.model.entity.SysResourceRole;
import com.newkdd.admin.model.po.SysResourcePO;
import com.newkdd.framework.basic.BasicDAO;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mike on 2018/4/13.
 */
public interface SysResourceDAO extends BasicDAO<SysResourcePO> {

    /**
     * 根据资源获取所有的角色清单
     * @return 资源、角色列表
     */
    List<SysResourceRole> getResourceRoles();

    /**
     * 根据用户编码获取资源列表
     * @param userId * 用户编码
     * @return 资源列表
     */
    List<SysResourcePO> getResourceByUserId(@Param("userId")String userId);

}
