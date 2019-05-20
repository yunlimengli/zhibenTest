package com.usa.zhiben.util.vo.base;

import java.util.List;

/**
 * 返回结果 带分页的
 */
public class PageResultVo {

    private List rows;
    private Long total;

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public PageResultVo(List rows, Long total) {
        this.total = total;
        this.rows = rows;
    }

}
