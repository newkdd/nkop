package com.newkdd.admin.dao;

import com.newkdd.admin.model.entity.SysResourceRole;
import com.newkdd.admin.model.po.SysResourcePO;
import com.newkdd.framework.basic.BasicDAO;

import java.util.List;

/**
 * Created by Mike on 2018/4/13.
 */
public interface SysResourceDAO extends BasicDAO<SysResourcePO> {

    /**
     * 根据资源获取所有的角色清单
     * @return
     */
    List<SysResourceRole> getResourceRoles();

}
