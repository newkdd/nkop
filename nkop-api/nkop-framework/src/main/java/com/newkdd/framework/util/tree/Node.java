package com.newkdd.framework.util.tree;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mike on 2018/4/14.
 */
public class Node implements Serializable{
    /**编码*/
    private String id;
    /**父类编码*/
    private String parentId;
    /**子类集合*/
    private List<Node> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
