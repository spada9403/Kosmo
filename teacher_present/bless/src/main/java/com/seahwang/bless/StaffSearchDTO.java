package com.seahwang.bless;

import java.util.List;

public class StaffSearchDTO {
    private String keyword;
    private String staffGender;
    private int religion;
    private List<Integer> staffSchool;
    private List<Integer> staffSkill;
    private List<String> staffGradDay_start;
    private List<String> staffGradDay_end;
    private String startGradDay;
    private String endGradDay;
    private int selectPage = 1;
    private int rowCntPerPage = 5;
    private String sort;
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public String getStaffGender() {
        return staffGender;
    }
    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }
    public int getReligion() {
        return religion;
    }
    public void setReligion(int religion) {
        this.religion = religion;
    }
    public List<Integer> getStaffSchool() {
        return staffSchool;
    }
    public void setStaffSchool(List<Integer> staffSchool) {
        this.staffSchool = staffSchool;
    }
    public List<Integer> getStaffSkill() {
        return staffSkill;
    }
    public void setStaffSkill(List<Integer> staffSkill) {
        this.staffSkill = staffSkill;
    }
    public List<String> getStaffGradDay_start() {
        return staffGradDay_start;
    }
    public void setStaffGradDay_start(List<String> staffGradDay_start) {
        this.staffGradDay_start = staffGradDay_start;
    }
    public List<String> getStaffGradDay_end() {
        return staffGradDay_end;
    }
    public void setStaffGradDay_end(List<String> staffGradDay_end) {
        this.staffGradDay_end = staffGradDay_end;
    }
    public String getStartGradDay() {
        return startGradDay;
    }
    public void setStartGradDay(String startGradDay) {
        this.startGradDay = startGradDay;
    }
    public String getEndGradDay() {
        return endGradDay;
    }
    public void setEndGradDay(String endGradDay) {
        this.endGradDay = endGradDay;
    }
    public int getSelectPage() {
        return selectPage;
    }
    public void setSelectPage(int selectPage) {
        this.selectPage = selectPage;
    }
    public int getRowCntPerPage() {
        return rowCntPerPage;
    }
    public void setRowCntPerPage(int rowCntPerPage) {
        this.rowCntPerPage = rowCntPerPage;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
}