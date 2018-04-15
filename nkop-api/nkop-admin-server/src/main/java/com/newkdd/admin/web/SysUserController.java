package com.newkdd.admin.web;

import com.github.pagehelper.PageInfo;
import com.newkdd.admin.model.po.SysUserPO;
import com.newkdd.admin.model.vo.SysUserVO;
import com.newkdd.admin.service.ISysUserService;
import com.newkdd.framework.basic.BasicController;
import com.newkdd.framework.basic.PageDTO;
import com.newkdd.framework.util.BeanUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户控制层
 * @author mike.miao
 *
 */
@RestController
@RequestMapping("/v1/sys_users")
@Api(value = "SysUserController", description="用户管理接口")
public class SysUserController extends BasicController{
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 登录
     * @param userId * 用户编码
     * @param request
     * @return
     */
    @ApiOperation(value = "根据编码获取用户信息", notes = "根据编码获取用户信息")
    @GetMapping(value = "{userId}", produces = {"application/json;charset=UTF-8"})
    public SysUserPO login(@PathVariable String userId, HttpServletRequest request) {
        SysUserPO sysUserPO = sysUserService.selectByPrimaryKey(userId);
        return sysUserPO;
    }

    @ApiOperation(value = "根据查询条件获取用户分页数据", notes = "根据查询条件获取用户分页数据")
    @GetMapping(value = "user_page", produces = {"application/json;charset=UTF-8"})
    public PageDTO getUserPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(name = "per_page",defaultValue = "10") Integer perPage,
                               @RequestParam(defaultValue = "") String keywords,
                               @RequestParam(required = false) String sortby,
                               @RequestParam(required = false,defaultValue = "asc") String order,
                               String username,String realname,String phone,String email
                               ){
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setUsername(username);
        sysUserPO.setRealname(realname);
        sysUserPO.setEmail(email);
        sysUserPO.setPhone(phone);
        sysUserPO.setKeywords(keywords);
        sysUserPO.setSortby(sortby);
        sysUserPO.setOrder(order);
        PageInfo<SysUserPO> pageInfo = sysUserService.selectPage(page,perPage,sysUserPO);
        PageDTO<SysUserVO> pageDTO = getPage(pageInfo,perPage);
        return pageDTO;
    }

    /**
     * 保存系统用户
     * @param request
     * @return
     */
    @ApiOperation(value = "根据编码获取用户信息", notes = "根据编码获取用户信息")
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public SysUserVO save(SysUserVO sysUser, HttpServletRequest request) {
        SysUserPO sysUserPO = BeanUtils.copyObject(sysUser,SysUserPO.class);
        sysUserService.save(sysUserPO);
        return BeanUtils.copyObject(sysUserPO,SysUserVO.class);
    }

    /**
     * 保存系统用户
     * @param request
     * @return
     */
    @ApiOperation(value = "动态更新用户信息", notes = "动态更新用户信息")
    @PutMapping(produces = {"application/json;charset=UTF-8"})
    public SysUserVO update(SysUserVO sysUser, HttpServletRequest request) {
        SysUserPO sysUserPO = BeanUtils.copyObject(sysUser,SysUserPO.class);
        sysUserService.updateByPrimaryKeySelective(sysUserPO);
        return BeanUtils.copyObject(sysUserPO,SysUserVO.class);
    }


    /**
     * 删除系统用户
     * @param request
     * @return
     */
    @ApiOperation(value = "动态更新用户信息", notes = "动态更新用户信息")
    @DeleteMapping(value = "{ids}", produces = {"application/json;charset=UTF-8"})
    public Integer delete(@PathVariable String ids, HttpServletRequest request) {
        return sysUserService.logicDelete(ids);
    }
}
