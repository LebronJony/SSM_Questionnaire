package com.gong.utils;

import java.io.Serializable;

/**
 * @author gonghongyu
 * @title: Entity
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/1721:36
 **/
public class Entity implements Serializable {
    private Integer page;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
