package com.newkdd.admin.service;

import com.newkdd.admin.model.dto.ResourceTreeDTO;
import com.newkdd.admin.model.entity.SysResourceRole;
import com.newkdd.admin.model.po.SysResourcePO;
import com.newkdd.framework.basic.BasicService;
import com.newkdd.framework.exception.BizException;

import java.util.List;

/**
 * Created by Mike on 2018/4/12.
 */
public interface ISysResourceService extends BasicService<SysResourcePO> {
    /**
     * 获取所有的资源和角色列表
     * @return
     */
    List<SysResourceRole> getResourceRoles() throws BizException;

    /**
     * 获取当前登录用户对应的资源列表
     * @return 资源树形结构
     */
    List<ResourceTreeDTO> getResourceByUser() throws BizException;
}
