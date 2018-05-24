package com.learn.crm.page;

import java.util.List;

public class PageBean<T> {

    //必选项
    private int pageNum;
    private int pageSize;
    private int totalRecord;

    //计算项
    private int startIndex;
    private int totalPage;

    //数据
    private List<T> data;

    //动态显示条
    private int start;
    private int end;

    public PageBean(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        //计算
        //1.开始索引
        this.startIndex = (this.pageNum - 1) * this.pageSize;

        //2.总分页数
        this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;

        //3.动态显示条
        //3.1 初始化数据----显示10个分页
        this.start = 1;
        this.end = 10;
        //3.2 处理数据   totalPage = 4
        if (this.totalPage <= 10){
            this.end = this.totalPage;
        }else{
            //totalPage = 12
            //3.3 前四后五
            this.start = this.pageNum - 4;
            this.end = this.pageNum + 5;

            //pageNum=1
            if (this.start < 1){
                this.start = 1;
                this.end = 10;
            }
            //pageNum=12
            if (this.end > this.totalPage){
                this.end = this.totalPage;
                this.start = this.totalPage - 9;
            }


        }



    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
