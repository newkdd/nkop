package com.newkdd.admin.web;

import com.newkdd.admin.model.po.SysUserPO;
import com.newkdd.admin.service.ISysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户控制层
 * @author mike.miao
 *
 */
@RestController
@RequestMapping("/user/web")
@Api(value = "SysUserController", description="用户管理接口")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 登录
     * @param userId * 用户编码
     * @param request
     * @return
     */
    @ApiOperation(value = "根据编码获取用户信息", notes = "根据编码获取用户信息")
    @GetMapping(value = "v1/p/{userId}", produces = {"application/json;charset=UTF-8"})
    public SysUserPO login(@PathVariable String userId, HttpServletRequest request) {
        SysUserPO sysUserPO = sysUserService.selectByPrimaryKey(userId);
        return sysUserPO;
    }
}
