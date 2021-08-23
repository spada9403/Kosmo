package com.naver.prj1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


  @RequestMapping(value = "/boardList.do")
  public ModelAndView getBoardList(){
      ModelAndView mav = new ModelAndView();
      mav.setViewName("boardList.jsp");
      return mav;
  }
  @RequestMapping(value = "/boardRegForm.do")
  public ModelAndView goBoardRegForm(){
      ModelAndView mav = new ModelAndView();
      mav.setViewName("boardRegForm.jsp");
      return mav;
  }
  @RequestMapping(value = "/boardRegProc.do", method = RequestMethod.POST)
  public ModelAndView insertBoard(
// 파라미터값을 저장할 [BoardDTO 객체]를 매개변수로 선언
    // [파라미터명]과 [BoardDTO객체]의 [속성변수명]이 같으면
    //  setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다.
    // [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다.
    // [송성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면
    // [속성변수명]의 자료형에 관계없이 무조건 null값이 저장된다.
    // 이때 [속성변수]의 자료형이 기본형일경우 null값이 저장될 수 없어 에러가 발생한다.
    // 이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String으로 해야한다.
    // 이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
    // 매개변수로 들어온 [DTO 객체]는 이 메소드가 끝난 후 호출되는 JSP 페이지로 그대로 이동한다.
    // 즉, HttpServletRequest 객체에 boardDTO 라는 키값명으로 저장된다.
    BoardDTO boardDTO
  ){
      int maxB_no = boardService.getMaxPkNum();
      boardDTO.setB_no(maxB_no + 1);
      int insertBoardCnt = boardService.insertBoard(boardDTO);
      ModelAndView mav = new ModelAndView();
      mav.setViewName("boardRegProc.jsp");
      mav.addObject("insertBoardCnt", insertBoardCnt);
      return mav;
  }
}
