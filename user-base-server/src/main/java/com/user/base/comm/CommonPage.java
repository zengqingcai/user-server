package com.user.base.comm;

import com.github.pagehelper.PageInfo;
import com.user.base.entity.model.Permission;

public class CommonPage {

    //当前页码
    private Integer currentPage;

    //每一页的数据数量
    private Integer pageSize;

    //总共的数据量
    private Long totals;

    //总页数
    private Integer pages;


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotals() {
        return totals;
    }

    public void setTotals(Long totals) {
        this.totals = totals;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public CommonPage(){}

    public static CommonPage setPageModel(PageInfo<?> pageInfo){
        CommonPage commonPage = new CommonPage();
        commonPage.setCurrentPage(pageInfo.getPageNum());
        commonPage.setPages(pageInfo.getPages());
        commonPage.setTotals(pageInfo.getTotal());
        commonPage.setPageSize(pageInfo.getPageSize());
        return commonPage;
    }
}
