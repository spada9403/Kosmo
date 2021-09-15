package com.naver.prj1;

import java.util.List;

public class EmployeeDTO {
    private String keyword1;
    private List<String> jikup;
    private String hire_date_year1;
    private String hire_date_month1;
    private String hire_date_year2;
    private String hire_date_month2;
    private int selectPageNo=1;
    private int rowCntPerPage=10;
    public String getKeyword1() {
        return keyword1;
    }
    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }
    public List<String> getJikup() {
        return jikup;
    }
    public void setJikup(List<String> jikup) {
        this.jikup = jikup;
    }
    public String getHire_date_year1() {
        return hire_date_year1;
    }
    public void setHire_date_year1(String hire_date_year1) {
        this.hire_date_year1 = hire_date_year1;
    }
    public String getHire_date_month1() {
        return hire_date_month1;
    }
    public void setHire_date_month1(String hire_date_month1) {
        this.hire_date_month1 = hire_date_month1;
    }
    public String getHire_date_year2() {
        return hire_date_year2;
    }
    public void setHire_date_year2(String hire_date_year2) {
        this.hire_date_year2 = hire_date_year2;
    }
    public String getHire_date_month2() {
        return hire_date_month2;
    }
    public void setHire_date_month2(String hire_date_month2) {
        this.hire_date_month2 = hire_date_month2;
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
}
