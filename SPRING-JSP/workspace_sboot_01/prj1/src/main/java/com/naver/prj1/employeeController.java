package com.naver.prj1;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class employeeController {

    
    @Autowired
    EmployeeDAO employeeDAO;


    @RequestMapping(value = "/employeeList.do")
    public ModelAndView employee(
        EmployeeDTO employeeDTO
    ){
        ModelAndView mav = new ModelAndView();
        try {
            int searchEmployeeCnt = this.employeeDAO.getSearchEmployeeCnt(employeeDTO);
            int last_pageNo = 0;
            int min_pageNo = 0;
            int max_pageNo = 0;
            int rowCntPerPage = employeeDTO.getRowCntPerPage();
            int selectPageNo = employeeDTO.getSelectPageNo();
            if(searchEmployeeCnt>0){
            last_pageNo = searchEmployeeCnt/rowCntPerPage;
                if( searchEmployeeCnt%rowCntPerPage > 0 ){last_pageNo++;}
            if(selectPageNo > last_pageNo){
                selectPageNo = 1;
                employeeDTO.setSelectPageNo(selectPageNo);
            }
            min_pageNo = (((selectPageNo-1)/10) * 10) + 1;
            max_pageNo = (min_pageNo + 10) - 1;
                if( max_pageNo>last_pageNo){max_pageNo = last_pageNo;}
            }
            List<Map<String,String>> employeeList = this.employeeDAO.getEmployeeList(employeeDTO);
            mav.addObject("employeeList", employeeList);
            mav.addObject("last_pageNo", last_pageNo);
            mav.addObject("min_pageNo", min_pageNo);
            mav.addObject("max_pageNo", max_pageNo);
            mav.addObject("rowCntPerPage", rowCntPerPage);
            mav.addObject("selectPageNo", selectPageNo);
            mav.addObject("searchEmployeeCnt", searchEmployeeCnt);
        } catch (Exception e) {
            System.out.println("DB연동실패");
            System.out.println(e);
        }
        mav.setViewName("/employeeViews/employeeList.jsp");
        return mav;
    }
    
  @RequestMapping(value = "/employeeApi.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  @ResponseBody
  public List<Map<String,String>> emplList(){
    List<Map<String,String>> emplList = this.employeeDAO.emplList();
    return emplList;
  }
  @RequestMapping(value = "/employeeInfoApi.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  @ResponseBody
  public Map<String,String> emplInfo(@RequestParam("id") String id){
    Map<String,String> emplList = this.employeeDAO.emplInfo(id);
    return emplList;
  }
}
