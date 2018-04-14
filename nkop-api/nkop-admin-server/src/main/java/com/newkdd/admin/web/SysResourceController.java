package com.newkdd.admin.web;

import com.newkdd.admin.model.dto.ResourceTreeDTO;
import com.newkdd.admin.service.ISysResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.ApiOperation;

/**
 * Created by Mike on 2018/4/14.
 */
@RestController
@RequestMapping("/v1/resource/web")
public class SysResourceController {

    @Autowired
    private ISysResourceService sysResourceService;

    @ApiOperation(value = "获取当前登录用户对应的资源", notes = "获取当前登录用户对应的资源")
    @GetMapping(value = "p/resources_tree", produces = {"application/json;charset=UTF-8"})
    public List<ResourceTreeDTO> getResourceTree(){
        return sysResourceService.getResourceByUser();
    }
}
