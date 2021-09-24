package com.seahwang.bless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDAO staffDAO;

    public int insertStaffInfo(StaffDTO staffDTO) {
        int insertCnt = this.staffDAO.insertStaffInfo(staffDTO);
        if(insertCnt == 0){
            return -1;
        }
        int getStaffNo = this.staffDAO.getStaffNo(staffDTO);
        if(getStaffNo <= 0){
            return -1;
        }
        staffDTO.setStaffNo(getStaffNo);
        int insertStaffSkill = this.staffDAO.setStaffSkill(staffDTO);
        if(insertStaffSkill == 0){
            return -1;
        }
        return 1;
    }
    public int deleteStaffInfo(int id) {
        int deleteStaffSkillCnt = this.staffDAO.deleteStaffSkill(id);
        if(deleteStaffSkillCnt == 0){
            return -1;
        }
        int deleteStaffInfoCnt = this.staffDAO.deleteStaffInfo(id);
        if(deleteStaffInfoCnt == 0){
            return -1;
        }
        return 1;
    }
    public int updateStaffInfo(StaffDTO staffDTO) {
        int updateStaffInfoCnt = this.staffDAO.updateStaffInfo(staffDTO);
        if(updateStaffInfoCnt == 0) {
            return -1;
        }
        int updateStaffSkillCnt = this.staffDAO.updateStaffSkill(staffDTO);
        if(updateStaffSkillCnt == 0) {
            return -1;
        }
        return 1;
    }
}
