package com.naver.prj1;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImple implements EmployeeDAO{

    @Autowired
    SqlSessionTemplate sqlSession;

    public List<Map<String,String>> getEmployeeList(EmployeeDTO employeeDTO){
        List<Map<String,String>> employeeList = this.sqlSession.selectList("com.naver.prj1.EmployeeDAO.getEmployeeList",employeeDTO);
        return employeeList;
    }
    public int getSearchEmployeeCnt(EmployeeDTO employeeDTO){
        int searchEmployeeCnt = this.sqlSession.selectOne("com.naver.prj1.EmployeeDAO.getEmployeeCnt",employeeDTO);
        return searchEmployeeCnt;
    }
}
