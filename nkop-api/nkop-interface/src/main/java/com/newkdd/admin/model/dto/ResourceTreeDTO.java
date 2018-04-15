package com.newkdd.admin.model.dto;

import com.newkdd.framework.util.tree.Node;

/**
 * Created by Mike on 2018/4/14.
 */
public class ResourceTreeDTO extends Node{
    /** URL */
    private String url;
    /** 访问路径 */
    private String path;
    /** 组件地址 */
    private String component;
    /** 资源名称 */
    private String name;
    /** 资源图标 */
    private String iconClass;
    /** Vue内存中保留组件的状态*/
    private Integer keepAlive;

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
}
