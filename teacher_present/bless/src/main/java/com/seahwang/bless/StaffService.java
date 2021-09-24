package com.seahwang.bless;

public interface StaffService {
    int insertStaffInfo(StaffDTO staffDTO);
    int deleteStaffInfo(int id);
    int updateStaffInfo(StaffDTO staffDTO);
}
