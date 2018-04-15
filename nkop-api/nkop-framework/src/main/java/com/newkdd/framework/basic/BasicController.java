package com.newkdd.framework.basic;

import com.github.pagehelper.PageInfo;

/**
 * Created by Mike on 2018/4/15.
 */
public class BasicController {

    /**
     * Page对象转换
     * @param pageInfo * PageHelper对象
     * @param perPage * 每页行数
     * @return
     */
    public PageDTO getPage(PageInfo pageInfo,Integer perPage){
        PageDTO pageDTO = new PageDTO();
        pageDTO.setData(pageInfo.getList());
        pageDTO.setPage(pageInfo.getPageNum());
        pageDTO.setPerPage(perPage);
        pageDTO.setPages(pageInfo.getPages());
        pageDTO.setTotal(pageInfo.getTotal());
        return pageDTO;
    }
}
