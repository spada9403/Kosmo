package com.naver.prj1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
    
    @Autowired
    EmployeeDAO employeeDAO;

    public int updateEmplInfo(ArrayList<String> emplInfo){
        int updateEmplInfoCnt = this.employeeDAO.updateEmplInfo(emplInfo);
        return updateEmplInfoCnt;
    }

}