package com.gaoao.domain;

import java.util.List;
//T为泛型，此类可为用户和图书进行分页
public class PageBean<T> {
    private int totalCount;//记录数
    private int currentPage;
    private int totalPage;
    private int rows;//每页记录数
    private List<T> list;//数据

    public PageBean() {
    }

    public PageBean(int totalCount, int currentPage, int totalPage, int rows, List<T> list) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.rows = rows;
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", rows=" + rows +
                ", list=" + list +
                '}';
    }
}
