package com.seahwang.bless;

import java.util.List;
import java.util.Map;

public interface StaffDAO {
    List<Map<String,String>> getStaffList(StaffSearchDTO staffSearchDTO);
    int getTotCnt();
    int getStaffListCnt(StaffSearchDTO staffSearchDTO);
    int insertStaffInfo(StaffDTO staffDTO);
    int getStaffNo(StaffDTO staffDTO);
    int setStaffSkill(StaffDTO staffDTO);
    Map<String,String> getStaffInfoWIthId(String id);
    int deleteStaffInfo(int id);
    int updateStaffInfo(StaffDTO staffDTO);
    int updateStaffSkill(StaffDTO staffDTO);
    int deleteStaffSkill(int id);
}
