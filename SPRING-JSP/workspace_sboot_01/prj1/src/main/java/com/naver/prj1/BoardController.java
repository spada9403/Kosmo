package com.naver.prj1;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardDAO boardDAO;


  @RequestMapping(value = "/boardList.do")
  public ModelAndView getBoardList(
    BoardSearchDTO boardSearchDTO
  ){
    int searchBoardCnt = this.boardDAO.searchBoardCnt(boardSearchDTO);
    ModelAndView mav = new ModelAndView();
    mav.setViewName("boardList.jsp");
    int last_pageNo = 0;
    int min_pageNo = 0;
    int max_pageNo = 0;
    int rowCntPerPage = boardSearchDTO.getRowCntPerPage();
    int selectPageNo = boardSearchDTO.getSelectPageNo();
    if(searchBoardCnt>0){
      last_pageNo = searchBoardCnt/rowCntPerPage;
        if( searchBoardCnt%rowCntPerPage > 0 ){last_pageNo++;}
      if(selectPageNo > last_pageNo){
        selectPageNo = 1;
        boardSearchDTO.setSelectPageNo(selectPageNo);
      }
      min_pageNo = (((selectPageNo-1)/10) * 10) + 1;
      max_pageNo = (min_pageNo + 10) - 1;
        if( max_pageNo>last_pageNo){max_pageNo = last_pageNo;}
    }
    List<Map<String,String>> boardList = this.boardDAO.getBoardList( boardSearchDTO );
    mav.addObject("last_pageNo", last_pageNo);
    mav.addObject("min_pageNo", min_pageNo);
    mav.addObject("max_pageNo", max_pageNo);
    mav.addObject("selectPageNo", selectPageNo);
    mav.addObject("boardList", boardList);
    mav.addObject("searchBoardCnt", searchBoardCnt);
    mav.addObject("rowCntPerPage", rowCntPerPage);

    return mav;
  }
  @RequestMapping(value = "/boardContentForm.do")
  public ModelAndView goBoardContentForm( @RequestParam("b_no") int b_no ){
    ModelAndView mav = new ModelAndView();

    BoardDTO board = this.boardService.getBoard(b_no);
    mav.setViewName("boardContentForm.jsp");
    mav.addObject("board", board);
    return mav;
  }
  @RequestMapping(value = "/boardRegForm.do")
  public ModelAndView goBoardRegForm(
    //@RequestParam(value = "b_no", required = false, defaultValue = "0") int b_no
  ){
      ModelAndView mav = new ModelAndView();
      mav.setViewName("boardRegForm.jsp");
      return mav;
  }

  @RequestMapping(value = "/boardUpDelForm.do")
  public ModelAndView goBoardUpDelForm(
    @RequestParam(value = "b_no") int b_no
  ){
    ModelAndView mav = new ModelAndView();
    BoardDTO boardDTO = this.boardDAO.getBoard(b_no);
    mav.setViewName("boardUpDelForm.jsp");
    mav.addObject("boardDTO", boardDTO);
    return mav;
  }
  @RequestMapping(value = "/boardUpDelProc.do")
  public ModelAndView boardUpDel(
    @RequestParam(value = "upDel") String upDel,
    BoardDTO boardDTO, BindingResult bindingResult
  ){
      ModelAndView mav = new ModelAndView();
      String msg = "";
      msg = check_UpDelBoardDTO(boardDTO, bindingResult);
      if(msg.equals("")){
        int upDelBoardCnt = this.boardService.upDelBoard(boardDTO, upDel);
        mav.addObject("upDelBoardCnt", upDelBoardCnt);
        if(upDelBoardCnt == -1){
         msg = "서버에서 문제발생! 서버 관리자에게 문의 바람";
        } else if(upDelBoardCnt == -2){
          msg = "암호를 확인해주세요!";
        } else if(upDelBoardCnt == -3){
         msg = "이미 삭제된 게시글입니다.";
        } else if(upDelBoardCnt == -4){
          msg = "댓글이 있어 삭제 할 수 없는 게시글입니다.";
        }
      } else {
       mav.addObject("upDelBoardCnt", 0);
      }
      mav.addObject("msg", msg);
      mav.setViewName("boardUpDelProc.jsp");
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
    BoardDTO boardDTO,
    // Error 객체를 관리하는 BindingResult 객체가 저장'되어서' 들어오는 매개변수 bindingresult 객체 선언
    BindingResult bindingResult
  ){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("boardRegProc.jsp");
    try{
      // 유효성 체크 에러메세지 저장할 변수 msg 선언
      String msg = "";
      // check_BoardDTO 메소드 호출하여 유효성 체크하고 경고문자 얻기
      msg = check_BoardDTO(boardDTO, bindingResult);
      mav.addObject("msg", msg);
      // 만약 msg안에 ""가 저장되어 있으면, 즉 유효성 체크를 통과 했으면 DB연동.
      if(msg.equals("")){
        int insertBoardCnt = this.boardService.insertBoard(boardDTO);
        mav.addObject("insertBoardCnt", insertBoardCnt);
        // 만약 msg 안에 ""가 아니면, 즉 유효성 체크를 통과 못했으면
      } else {
        mav.addObject("insertBoardCnt", 0);
      }

    }
    catch(Exception e){
      mav.addObject("insertBoardCnt", -1);
      mav.addObject("msg", "서버에서 문제발생! 서버 관리자에게 문의 바람");
    }
      return mav;
  }
  //게시판 입력 또는 수정할때 게시판 입력글의 입력양식의 유효성을 검사하고
  //문제가있으면 경고문자를 리턴하는 메소드 선언.
  public String check_BoardDTO(BoardDTO boardDTO,BindingResult bindingResult){
    String checkMsg = "";
    // BoardDTO 객체에 저장된 데이터의 유효성 체크할 BoardVaildator 객체 생성하기.
    // BoardValidator 객체의 vaildate 메소드 호출하여 유효성 체크 실행하기.
    BoardValidator boardValidator = new BoardValidator();
    boardValidator.validate(
      boardDTO,   // 유효성 체크할 DTO 객체
      bindingResult //  유효성 체크 결과를 관리하는 BindingResult 객체
    );
    //  만약 BindingResult 객체의 hasErrors() 메소드 호출하여 true 값을 얻으면
    if( bindingResult.hasErrors() ){
      //  변수 checkMsg에 BoardVaildator 객체에 저장된 경고문구 얻어 저장하기.
        checkMsg = bindingResult.getFieldError().getCode();
    }
    // checkMsg 안의 에러메세지를 리턴한다.
    return checkMsg;
  }
  public String check_UpDelBoardDTO(BoardDTO boardDTO,BindingResult bindingResult){
    String checkMsg="";
      BoardValidator boardValidator = new BoardValidator();
      boardValidator.validate(
        boardDTO,   
        bindingResult 
      );

    if( bindingResult.hasErrors() ){
      checkMsg = bindingResult.getFieldError().getCode();
    }
    return checkMsg;
  }
}
