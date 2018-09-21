package com.dylan.common.fileupload.util;

import java.io.*;

/**
 * 分页工具类
 * @author ACER
 *
 * @param <T>
 */
public class PageResult<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int page;
    private int total;
    private T rows;
    private int totalPages;
    
    public PageResult() {
    }
    
    public PageResult( int page,  int total,  int totalPages,  T rows) {
        this.page = page;
        this.total = total;
        this.totalPages = totalPages;
        this.rows = rows;
    }
    
    public int getPage() {
        return this.page;
    }
    
    public void setPage( int page) {
        this.page = page;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal( int total) {
        this.total = total;
    }
    
    public int getTotalPages() {
        return this.totalPages;
    }
    
    public void setTotalPages( int totalPages) {
        this.totalPages = totalPages;
    }
    
    public T getRows() {
        return this.rows;
    }
    
    public void setRows( T rows) {
        this.rows = rows;
    }
}
