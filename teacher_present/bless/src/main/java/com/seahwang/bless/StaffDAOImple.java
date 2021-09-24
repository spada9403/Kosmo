package com.seahwang.bless;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StaffDAOImple implements StaffDAO {

    @Autowired
    SqlSessionTemplate sqlSession;

    public List<Map<String,String>> getStaffList(StaffSearchDTO staffSearchDTO){
        List<Map<String,String>> staffList = this.sqlSession.selectList("com.seahwang.bless.getStaffList", staffSearchDTO);
        for (Map<String,String> map : staffList) {
            List<String> skills = this.sqlSession.selectList("com.seahwang.bless.getStaffSkills", map);
            String skill = String.join(", ",skills);
            map.put("staffSkill", skill);
        }
        return staffList;
    }
    public int getTotCnt(){
        int totCnt = this.sqlSession.selectOne("com.seahwang.bless.getStaffListCntTot");
        return totCnt;
    }
    
    public int getStaffListCnt(StaffSearchDTO staffSearchDTO){
        int staffListCnt = this.sqlSession.selectOne("com.seahwang.bless.getSearchStaffListCnt",staffSearchDTO);
        return staffListCnt;
    }

    public int insertStaffInfo(StaffDTO staffDTO) {
        int insertCnt = this.sqlSession.insert("com.seahwang.bless.insertStaffInfo",staffDTO);
        return insertCnt;
    }
    public int getStaffNo(StaffDTO staffDTO) {
        int updateStaffSkill = this.sqlSession.selectOne("com.seahwang.bless.getStaffNo",staffDTO);
        return updateStaffSkill;
    }
    public int setStaffSkill(StaffDTO staffDTO){
        int setStaffSkillCnt = this.sqlSession.insert("com.seahwang.bless.insertStaffSkill",staffDTO);
        return setStaffSkillCnt;
    }
    public Map<String,String> getStaffInfoWIthId(String id){
        Map<String,String> staffInfo = this.sqlSession.selectOne("com.seahwang.bless.getStaffInfoWithId",id);
        List<String> staffSkills = this.sqlSession.selectList("com.seahwang.bless.getStaffSkills",id);
        String staffSkill = String.join(", ", staffSkills);
        staffInfo.put("staffSkill", staffSkill);
        return staffInfo;
    }
    public int deleteStaffInfo(int id) {
        int deleteStaffInfoCnt = this.sqlSession.delete("com.seahwang.bless.deleteStaffInfo",id);
        return deleteStaffInfoCnt;
    }
    public int deleteStaffSkill(int id){
        int delteStaffSkillCnt = this.sqlSession.delete("com.seahwang.bless.deleteStaffSkill",id);
        return delteStaffSkillCnt;
    }
    public int updateStaffInfo(StaffDTO staffDTO) {
        int updateStaffInfoCnt = this.sqlSession.update("com.seahwang.bless.updateStaffInfo",staffDTO);
        return updateStaffInfoCnt;
    }
    public int updateStaffSkill(StaffDTO staffDTO){
        int id = staffDTO.getStaffNo();
        this.sqlSession.delete("com.seahwang.bless.deleteStaffSkill",id);
        this.sqlSession.insert("com.seahwang.bless.insertStaffSkill",staffDTO);
        return 1;
    }
}