package com.newkdd.framework.security;

/**
 * Created by Mike on 2018/4/12.
 */
public class UserInfo {

    /** 用户编码 */
    private String id;
    /** 用户名 */
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
