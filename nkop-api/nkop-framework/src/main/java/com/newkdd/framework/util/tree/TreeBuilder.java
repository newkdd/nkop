package com.newkdd.framework.util.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 2018/4/14.
 */
public class TreeBuilder <T extends  Node>{

    List<T> nodes = new ArrayList<>();

    public TreeBuilder() {
    }

    public TreeBuilder(List<T> nodes) {
        super();
        this.nodes = nodes;
    }

    // 构建树形结构
    public List<T> buildTree() {
        List<T> treeNodes = new ArrayList<>();
        List<T> rootNodes = getRootNodes();
        for (T rootNode : rootNodes) {
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }
        return treeNodes;
    }

    // 递归子节点
    public void buildChildNodes(T T) {
        List<T> children = getChildNodes(T);
        if (!children.isEmpty()) {
            for (T child : children) {
                buildChildNodes(child);
            }
            T.setChildren((List<Node>) children);
        }
    }

    // 获取父节点下所有的子节点
    public List<T> getChildNodes(T pnode) {
        List<T> childNodes = new ArrayList<>();
        for (T n : nodes) {
            if (pnode.getId().equals(n.getParentId())) {
                childNodes.add(n);
            }
        }
        return childNodes;
    }

    // 判断是否为根节点
    public boolean rootNode(T T) {
        boolean isRootNode = true;
        for (T n : nodes) {
            if(T.getParentId()==null){
                System.out.println("test");
            }
            if (T.getParentId().equals(n.getId())) {
                isRootNode = false;
                break;
            }
        }
        return isRootNode;
    }

    // 获取集合中所有的根节点
    public List<T> getRootNodes() {
        List<T> rootNodes = new ArrayList<>();
        for (T n : nodes) {
            if (rootNode(n)) {
                rootNodes.add(n);
            }
        }
        return rootNodes;
    }
}