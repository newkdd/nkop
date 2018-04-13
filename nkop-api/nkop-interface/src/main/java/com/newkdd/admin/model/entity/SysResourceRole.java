package com.newkdd.admin.model.entity;

import com.newkdd.admin.model.po.SysResourcePO;
import com.newkdd.admin.model.po.SysRolePO;
import com.newkdd.framework.basic.BasicDO;

import java.util.List;


/**
 * Created by Mike on 2018/4/13.
 */
public class SysResourceRole extends SysResourcePO{
    /** 资源Meta*/
    private ResourceMeta resourceMeta;
    /** 相关联的角色*/
    private List<SysRolePO> sysRoles;

    public ResourceMeta getResourceMeta() {
        return resourceMeta;
    }

    public void setResourceMeta(ResourceMeta resourceMeta) {
        this.resourceMeta = resourceMeta;
    }

    public List<SysRolePO> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRolePO> sysRoles) {
        this.sysRoles = sysRoles;
    }
}
