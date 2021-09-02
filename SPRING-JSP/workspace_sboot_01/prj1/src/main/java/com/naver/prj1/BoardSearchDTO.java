package com.naver.prj1;

import java.util.List;

public class BoardSearchDTO {
    private String keyword1;
    private int selectPageNo=1;;
    private int rowCntPerPage=10;
    private List<String> day;

    public String getKeyword1() {
        return keyword1;
    }
    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }
    public int getSelectPageNo() {
        return selectPageNo;
    }
    public void setSelectPageNo(int selectPageNo) {
        this.selectPageNo = selectPageNo;
    }
    public int getRowCntPerPage() {
        return rowCntPerPage;
    }
    public void setRowCntPerPage(int rowCntPerPage) {
        this.rowCntPerPage = rowCntPerPage;
    }
    public List<String> getDay() {
        return day;
    }
    public void setDay(List<String> day) {
        this.day = day;
    }
    }
