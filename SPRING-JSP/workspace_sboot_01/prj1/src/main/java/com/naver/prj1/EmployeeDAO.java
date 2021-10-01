package com.naver.prj1;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
    List<Map<String,String>> getEmployeeList(EmployeeDTO employeeDTO);
    int getSearchEmployeeCnt(EmployeeDTO employeeDTO);
    List<Map<String,String>> emplList();
    Map<String,String> emplInfo(String id);
}
