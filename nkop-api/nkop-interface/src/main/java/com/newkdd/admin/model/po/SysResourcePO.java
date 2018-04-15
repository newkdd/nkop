package com.newkdd.admin.model.po;

import com.newkdd.framework.basic.BasicPO;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by Mike on 2018/4/13.
 */
@Table(name = "TB_SYS_RESOURCE")
public class SysResourcePO extends BasicPO{
    @Column(name = "TYPE")
    private Integer type;
    @Column(name = "URL")
    private String url;
    @Column(name = "PATH")
    private String path;
    @Column(name = "COMPONENT")
    private String component;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ICON_CLASS")
    private String iconClass;
    @Column(name = "KEEP_ALIVE")
    private Integer keepAlive;
    @Column(name = "REQUIRE_AUTH")
    private String requireAuth;
    @Column(name = "PARENT_ID")
    private String parentId;
    @Column(name = "REMARK")
    private String remark;
    @Column(name = "DISPLAY_ORDER")
    private String displayOrder;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public Integer getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Integer keepAlive) {
        this.keepAlive = keepAlive;
    }

    public String getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(String requireAuth) {
        this.requireAuth = requireAuth;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }
}
