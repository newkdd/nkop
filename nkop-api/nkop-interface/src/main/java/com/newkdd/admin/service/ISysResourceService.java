package com.newkdd.admin.service;

import com.newkdd.admin.model.entity.SysResourceRole;
import com.newkdd.admin.model.po.SysResourcePO;
import com.newkdd.framework.basic.BasicService;

import java.util.List;

/**
 * Created by Mike on 2018/4/12.
 */
public interface ISysResourceService extends BasicService<SysResourcePO> {
    /**
     * 获取所有的资源和角色列表
     * @return
     */
    List<SysResourceRole> getResourceRoles();
}
