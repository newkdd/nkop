package com.newkdd.framework.security;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Mike on 2018/4/12.
 */
public class SecurityHelper {

    public static UserInfo getCurrentUser(){
        return (UserInfo)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
