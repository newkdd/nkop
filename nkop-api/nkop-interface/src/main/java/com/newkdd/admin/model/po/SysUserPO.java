package com.newkdd.admin.model.po;

import com.newkdd.framework.basic.BasicPO;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "TB_SYS_USER")
public class SysUserPO extends BasicPO {

	private static final long serialVersionUID = -6695722256864729383L;

    /**
     * 登录账号
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 登录密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 真实姓名
     */
    @Column(name = "REALNAME")
    private String realname;

    /**
     * 微信编码
     */
    @Column(name = "WX_ID")
    private String WXID;

    /**
     * 手机
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 最后登录IP
     */
    @Column(name = "LAST_LOGIN_IP")
    private String lastLoginIP;

    /**
     * 最后登录时间
     */
    @Column(name = "LAST_LOGIN_TIME")
    private Timestamp lastLoginTime;

    /**
     * 登录次数
     */
    @Column(name = "LOGIN_TIMES")
    private Long loginTimes;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWXID() {
        return WXID;
    }

    public void setWXID(String WXID) {
        this.WXID = WXID;
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

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Long loginTimes) {
        this.loginTimes = loginTimes;
    }
}