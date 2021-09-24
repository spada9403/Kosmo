package com.seahwang.bless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class staffContoller {

    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private StaffService staffService;

    @ModelAttribute("totCnt")
    public int getTotCnt(){
        int totCnt = this.staffDAO.getTotCnt();
        return totCnt;
    }

    @RequestMapping(value="staff_search_form.do", method = RequestMethod.GET)
    public ModelAndView searchPage(HttpSession session){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("staffSearchForm.jsp");
        StaffSearchDTO staffSearchDTO = (StaffSearchDTO)session.getAttribute("staffSearchDTO");
        if(staffSearchDTO != null){
            int staffListCnt = (int)session.getAttribute("staffSearchListCnt");
            mav.addObject("staffList", getStaffList(staffSearchDTO));
            mav.addObject("pagingNo", getPagingNos(staffListCnt, staffSearchDTO.getSelectPage(), staffSearchDTO.getRowCntPerPage()));
        }
        return mav;
    }
    @RequestMapping(value="staff_search_form.do", method = RequestMethod.POST)
    public ModelAndView searchStaff(
        StaffSearchDTO staffSearchDTO,
        HttpSession session
    ){
        ModelAndView mav = new ModelAndView();
        String staffGradDay_Start = String.join("", staffSearchDTO.getStaffGradDay_start());
        String staffGradDay_End = String.join("", staffSearchDTO.getStaffGradDay_end());
        String msg = validateStaffGradDay(staffGradDay_Start,staffGradDay_End);
        if(msg != null && msg.length()>0){
            mav.setViewName("error.jsp");
            mav.addObject("msg", msg);
            return mav;
        }
        staffSearchDTO.setStartGradDay(staffGradDay_Start);
        staffSearchDTO.setEndGradDay(staffGradDay_End);
        int staffListCnt = this.staffDAO.getStaffListCnt(staffSearchDTO);
        mav.addObject("pagingNo", getPagingNos(staffListCnt, staffSearchDTO.getSelectPage(), staffSearchDTO.getRowCntPerPage()));
        List<Map<String,String>> staffList = getStaffList(staffSearchDTO);
        if(staffList != null){
            session.setAttribute("staffSearchDTO", staffSearchDTO);
            session.setAttribute("staffSearchListCnt", staffListCnt);
            mav.addObject("staffListCnt",staffListCnt);
            mav.addObject("staffList", staffList);
        } else {
            mav.addObject("staffList", null);
        }
        mav.setViewName("staffSearchForm.jsp");
        return mav;
    }
    @RequestMapping(value = "staff_input_form.do", method = RequestMethod.GET)
    public ModelAndView staffInputForm(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("staffInputForm.jsp");
        return mav;
    }
    @RequestMapping(value = "staff_input_form.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,String> isnertSaffInfo(
        StaffDTO staffDTO
    ){ 
        List<String> juminList = staffDTO.getJumin_no();
        staffDTO.setJumin_noStr(String.join("-", juminList));
        List<String> gradList = staffDTO.getStaffGradDay();
        staffDTO.setStaffGradDayStr(String.join("-", gradList));
        HashMap<String,String> map = new HashMap<String,String>();
        int insertCnt = this.staffService.insertStaffInfo(staffDTO);
        if(insertCnt == -1){
            map.put("msg", "등록 실패!");
        }
        return map;
    }
    @RequestMapping(value = "staff_updel_form.do", method = RequestMethod.POST)
    public ModelAndView staffUpDel(
        @RequestParam(value = "staffNo") String id
    ){
        ModelAndView mav = new ModelAndView();
        if(id != null && id .length()>0){
            Map<String,String> staffMap = this.staffDAO.getStaffInfoWIthId(id);
            mav.addObject("staffMap", staffMap);
        }
        mav.setViewName("staffUpDelForm.jsp");
        return mav;
    }
    @RequestMapping(value = "staff_updel_proc.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,String> staffUpDelProc(
        StaffDTO staffDTO
    ){
        int id = staffDTO.getStaffNo();
        HashMap<String,String> map = new HashMap<String,String>();
        if(id>0){
            List<String> juminList = staffDTO.getJumin_no();
            staffDTO.setJumin_noStr(String.join("-", juminList));
            List<String> gradList = staffDTO.getStaffGradDay();
            staffDTO.setStaffGradDayStr(String.join("-", gradList));
            String upDel = staffDTO.getUpDel();
            if(upDel.equals("up")){
                int updateStaffInfo = this.staffService.updateStaffInfo(staffDTO);
                if(updateStaffInfo == -1){
                    map.put("msg", "업데이트 실패!");
                    return map;
                }
                map.put("success", updateStaffInfo+"");
            }
            if(upDel.equals("del")){
                int deleteStaffInfo = this.staffService.deleteStaffInfo(id);
                if(deleteStaffInfo == -1){
                    map.put("msg", "삭제 실패!");
                    return map;
                }
                map.put("success", deleteStaffInfo+"");
            }
        }
        return map ;
    }

    public List<Map<String,String>> getStaffList(StaffSearchDTO staffSearchDTO) {
       return this.staffDAO.getStaffList(staffSearchDTO);
    }



    public String validateStaffGradDay(String staffGradDay_Start, String staffGradDay_End){
        String msg = null;
        if(staffGradDay_Start.length()>0 && staffGradDay_Start.length() < 8){
            msg = "시작 날짜 년/ 월/ 일 전부 선택해 주세요";
        }
        if(staffGradDay_End.length()>0 && staffGradDay_End.length() < 8){
            msg = "마지막 날짜 년/ 월/ 일 전부 선택해 주세요";
        }
        if(staffGradDay_Start.length()>=8 && staffGradDay_End.length()>=8){
            int intGradDay_start = Integer.parseInt(staffGradDay_Start);
            int intGradDay_end = Integer.parseInt(staffGradDay_End);
            if(intGradDay_start>intGradDay_end){
                msg = "최소 날짜가 최고 날짜보다 큽니다!";
            }
        }
        return msg;
    }
    public HashMap<String,Integer> getPagingNos(
        int totRowCnt,
        int selectPageNo,
        int rowCntPerPage
    ){
        int last_pageNo = 0;
        int min_pageNo = 0;
        int max_pageNo = 0;

        if(totRowCnt>0){
            last_pageNo = totRowCnt/rowCntPerPage;
                if(totRowCnt%rowCntPerPage > 0){last_pageNo++;}
            if(selectPageNo > last_pageNo){
                selectPageNo = 1;
            }
            // 자바에서 정수 / 정수 = 정수만 나온다.
            min_pageNo = (((selectPageNo-1)/10)*10)+1;
            max_pageNo = (min_pageNo + 10) -1;
                if(max_pageNo>last_pageNo){ max_pageNo = last_pageNo ;}
        }

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("totRowCnt", totRowCnt);
        map.put("selectPageNo", selectPageNo);
        map.put("rowCntPerPage", rowCntPerPage);
        map.put("last_pageNo", last_pageNo);
        map.put("min_pageNo", min_pageNo);
        map.put("max_pageNo", max_pageNo);

        return map;
    }
}
