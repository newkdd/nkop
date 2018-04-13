package com.newkdd.admin.config;

import com.newkdd.admin.model.entity.SysResourceRole;
import com.newkdd.admin.model.po.SysRolePO;
import com.newkdd.admin.service.ISysResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    ISysResourceService sysResourceService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        if ("/login_p".equals(requestUrl)) {
            return null;
        }
        List<SysResourceRole> resourceRoles = sysResourceService.getResourceRoles();
        for (SysResourceRole resourceRoleDO : resourceRoles) {
            if (antPathMatcher.match(resourceRoleDO.getUrl(), requestUrl)&&resourceRoleDO.getSysRoles().size()>0) {
                List<SysRolePO> sysRoles = resourceRoleDO.getSysRoles();
                int size = sysRoles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = sysRoles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
