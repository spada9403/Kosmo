package com.seahwang.bless;

import java.util.List;

public class StaffDTO {
    private int staffNo;
    private String staffName;
    private List<String> jumin_no;
    private String religion;
    private String staffSchool;
    private List<String> staffSkill;
    private List<String> staffGradDay;
    private String jumin_noStr;
    private String staffGradDayStr;
    private String upDel;
    public int getStaffNo() {
        return staffNo;
    }
    public void setStaffNo(int staffNo) {
        this.staffNo = staffNo;
    }
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public List<String> getJumin_no() {
        return jumin_no;
    }
    public void setJumin_no(List<String> jumin_no) {
        this.jumin_no = jumin_no;
    }
    public String getReligion() {
        return religion;
    }
    public void setReligion(String religion) {
        this.religion = religion;
    }
    public String getStaffSchool() {
        return staffSchool;
    }
    public void setStaffSchool(String staffSchool) {
        this.staffSchool = staffSchool;
    }
    public List<String> getStaffSkill() {
        return staffSkill;
    }
    public void setStaffSkill(List<String> staffSkill) {
        this.staffSkill = staffSkill;
    }
    public List<String> getStaffGradDay() {
        return staffGradDay;
    }
    public void setStaffGradDay(List<String> staffGradDay) {
        this.staffGradDay = staffGradDay;
    }
    public String getJumin_noStr() {
        return jumin_noStr;
    }
    public void setJumin_noStr(String jumin_noStr) {
        this.jumin_noStr = jumin_noStr;
    }
    public String getStaffGradDayStr() {
        return staffGradDayStr;
    }
    public void setStaffGradDayStr(String staffGradDayStr) {
        this.staffGradDayStr = staffGradDayStr;
    }
    public String getUpDel() {
        return upDel;
    }
    public void setUpDel(String upDel) {
        this.upDel = upDel;
    }
}