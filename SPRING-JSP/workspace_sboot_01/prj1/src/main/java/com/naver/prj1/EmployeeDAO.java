package com.naver.prj1;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
    List<Map<String,String>> getEmployeeList(EmployeeDTO employeeDTO);
    int getSearchEmployeeCnt(EmployeeDTO employeeDTO);
}
