package com.newkdd.admin.model.vo;

import com.newkdd.framework.basic.BasicVO;

import java.sql.Timestamp;

/**
 * Created by Mike on 2018/4/12.
 */
public class SysUserVO extends BasicVO{
    /** 登录账号*/
    private String username;
    /** 密码*/
    private String password;
    /** 姓名*/
    private String realname;
    /** 电话*/
    private String phone;
    /** 邮箱*/
    private String email;
    /** 最后登录IP*/
    private String lastLoginIP;
    /** 最后登录时间*/
    private String lastLoginTime;
    /** 登录次数*/
    private Long loginTimes;
    /** 备注*/
    private String remark;
    /** 创建人*/
    private String createdBy;
    /** 创建时间*/
    private Timestamp createdDate;
    /** 修改时间*/
    private String modifiedDate;
    /** 版本*/
    private Long version;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Long loginTimes) {
        this.loginTimes = loginTimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
