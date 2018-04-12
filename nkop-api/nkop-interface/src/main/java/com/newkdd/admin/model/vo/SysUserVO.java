package com.newkdd.admin.model.vo;

import com.newkdd.framework.basic.BasicVO;

/**
 * Created by Mike on 2018/4/12.
 */
public class SysUserVO extends BasicVO{
    /** 用户名*/
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
