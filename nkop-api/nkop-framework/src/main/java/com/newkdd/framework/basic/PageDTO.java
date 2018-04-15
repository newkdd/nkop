package com.newkdd.framework.basic;

import java.util.List;

/**
 * Created by Mike on 2017/8/28.
 */
public class PageDTO<VO> {
    /**数据集合*/
    private List<VO> data;
    /**当前页*/
    private Integer page;
    /**每页行数*/
    private Integer perPage;
    /**总页数*/
    private Integer pages;
    /**总行数*/
    private Long total;

    public List<VO> getData() {
        return data;
    }

    public void setData(List<VO> data) {
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
