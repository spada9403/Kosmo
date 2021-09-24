package com.naver.prj1;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/naver")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardDAO boardDAO;
    /*
    // 속성변수 path 선언하고 Info 인터페이스의 속성변수 naverPath 안의 데이터를 저장하기.
    // Info 인터페이스의 속성변수 naverPath 안에는 naver/ 가 저장되어있다.
    private String path = Info.naverPath;
    */
/*
    // 컨트롤러에 들어오는 모든 주소 RequestMapping 메소드실행전에
    // 제일 먼저 실행되는 ModelAttribute 어노테이션이 붙은 메소드
    @ModelAttribute
    public void checkLogin(
      HttpSession session
    ) throws Exception {
      String login_id = (String)session.getAttribute("login_id");
      if(login_id==null){
        // 만약 로그인에 성공한 적이 없으면 login_id 에는 null값이 있다.
        throw new Exception();
      }
    }
    // 현재 이 [컨트롤러 클래스] 내의 메소드에서
    // 예외 발생하면 호출되는 메소드 선언.
    // @ExceptionHandler(Exception.class)를 붙여야 한다.
    // @ExceptionHandler(Exception.class) 어노테이션이 붙은 메소드는
    // 리턴되는 문자열은 호출 JSP 페이지명이다.
    @ExceptionHandler(Exception.class)
    public String handleException(){
      return "logout.jsp";
    }
*/

  //@ReqeustMapping 이 붙은 메소드가 호출되기 전에 호출되는 메소드 선언
  //@ModelAttribute가 붙은 메소드는 @ReqeustMapping 이 붙은 메소드가 호출되기 전에 호출되는 메소드이다.
  //@ModelAttribute("키값명")이 붙은 메소드가 리턴하는 데이터는
  //HttpServletRequest 객체에 setAttribute("키값명",리턴데이터) 메소드 호출이 되는 것과 동일하다.
  //@RequestMapping(~)이 붙은 메소드 호출 후에 이동하는 JSP 페이지에서 ${requestScope.키값명}으로 꺼낼수 있다.
  @ModelAttribute("totCnt")
  public int getTotCnt(){
    int totCnt = this.boardDAO.getBoardListAllCnt();
    return totCnt;
  }

  @RequestMapping(value = "/boardList.do")
  public ModelAndView getBoardList(
    BoardSearchDTO boardSearchDTO,
    HttpSession session
  ){
    int searchBoardCnt = this.boardDAO.searchBoardCnt(boardSearchDTO);
    ModelAndView mav = new ModelAndView();
    mav.setViewName("boardList.jsp");
    mav.addObject("pagingNos", Util.getPagingNos(searchBoardCnt, boardSearchDTO.getSelectPageNo(), boardSearchDTO.getRowCntPerPage()));
    List<Map<String,String>> boardList = this.boardDAO.getBoardList( boardSearchDTO );
    mav.addObject("boardList", boardList);
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
  @RequestMapping(value = "/boardUpDelProc.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  @ResponseBody
  public Map<String,String> boardUpDel (
    @RequestParam(value = "upDel") String upDel,
    @RequestParam(value = "img") MultipartFile multi, 
    BoardDTO boardDTO, BindingResult bindingResult
  ) throws Exception {
      //ModelAndView mav = new ModelAndView();
      String msg = "";
      int upDelBoardCnt = 0;
      msg = check_UpDelBoardDTO(boardDTO, bindingResult);
      if(msg.equals("")){
        Map<String,String> MultiMap = checkMulti(multi);
        if(MultiMap != null){
          return MultiMap;
        }
        upDelBoardCnt = this.boardService.upDelBoard(boardDTO, upDel, multi);
        //mav.addObject("upDelBoardCnt", upDelBoardCnt);
        if(upDelBoardCnt == -1){
         msg = "서버에서 문제발생! 서버 관리자에게 문의 바람";
        } else if(upDelBoardCnt == -2){
          msg = "암호를 확인해주세요!";
        } else if(upDelBoardCnt == -3){
         msg = "이미 삭제된 게시글입니다.";
        } else if(upDelBoardCnt == -4){
          msg = "댓글이 있어 삭제 할 수 없는 게시글입니다.";
        }
      }
      Map<String, String> map = new HashMap<String,String>();
      map.put("msg",msg);
      map.put("upDelBoardCnt",upDelBoardCnt+"");
      return map;
  }
  // 메소드 앞에 
	// @RequestMapping(~,~,produces="application/json;charset=UTF-8") 하고
	// @ResponseBody  가 붙으면 리턴하는 데이터가 클라이언트에게 전송된다.
	// ModelAndView 객체를 리턴하면 JSP 를 호출하고 그 JSP 페이지의 실행결과인 HTML 문서가 응답메시지에 저장되어 전송되지만
	// @RequestMapping(~) 와 @ResponseBody 가 붙으면 리턴하는 데이터가 JSON 형태로  응답메시지에 저장되어 전송된다.
  @RequestMapping(value = "/boardRegProc.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  @ResponseBody
  public Map<String,String> insertBoard(
      BoardDTO boardDTO,
      // input type:file 입력양식의 파일이 저장된 MultipartFile 객체 저장 매개변수 선언.
      // <주의> 업로드된 파일이 없어도 MultipartFile 객체는 생성되어 들어온다.
      @RequestParam(value = "img") MultipartFile multi,
      BindingResult bindingResult
  ){
    int insertBoardCnt = 0;
    String msg = "";
    Map<String,String> MultiMap = checkMulti(multi);
    if(MultiMap != null){
      return MultiMap;
    }
    try {
      msg = check_BoardDTO(boardDTO, bindingResult);
      if(msg.equals("")){
        insertBoardCnt = this.boardService.insertBoard(boardDTO, multi);
      }
    } catch (Exception e) {
      insertBoardCnt = -1;
      msg = "서버에서 문제 발생! 서버 관리자에게 문의 바람!";
    }
    Map<String,String> map = new HashMap<String,String>();
    map.put("msg", msg);
    map.put("insertBoardCnt",insertBoardCnt+"");
    return map;
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
  public Map<String,String> checkMulti(MultipartFile multi){
    if( multi.isEmpty()==false ){
      // 만약에 업로드된 파일의 크기가 1000000 byte(=1000kb) 보다 크면,
      if( multi.getSize()>1000000){
        Map<String,String> map = new HashMap<String,String>();
        map.put("insertBoardCnt", "0");
        map.put("msg", "업로드 파일이 1000kb보다 크면 안됩니다.");
        return map;
      }
      // 만약에 업로드된 파일의 확장자가 이미지 확장자가 아니면
      String fileName = multi.getOriginalFilename();
      if(Pattern.matches("([a-zA-Z0-9_-])*.(jpg|png|gif)$", fileName)==false){
        Map<String,String> map = new HashMap<String,String>();
        map.put("insertBoardCnt", "0");
        map.put("msg", "이미지 파일이 아닙니다.");
        return map;
      }
    }
    return null;
  }
}
// @RequestMapping(value = "/boardRegProc.do", method = RequestMethod.POST)
// public ModelAndView insertBoard(
// // 파라미터값을 저장할 [BoardDTO 객체]를 매개변수로 선언
//   // [파라미터명]과 [BoardDTO객체]의 [속성변수명]이 같으면
//   //  setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다.
//   // [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다.
//   // [송성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면
//   // [속성변수명]의 자료형에 관계없이 무조건 null값이 저장된다.
//   // 이때 [속성변수]의 자료형이 기본형일경우 null값이 저장될 수 없어 에러가 발생한다.
//   // 이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String으로 해야한다.
//   // 이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
//   // 매개변수로 들어온 [DTO 객체]는 이 메소드가 끝난 후 호출되는 JSP 페이지로 그대로 이동한다.
//   // 즉, HttpServletRequest 객체에 boardDTO 라는 키값명으로 저장된다.
//   BoardDTO boardDTO,
//   // Error 객체를 관리하는 BindingResult 객체가 저장'되어서' 들어오는 매개변수 bindingresult 객체 선언
//   BindingResult bindingResult
// ){
//   ModelAndView mav = new ModelAndView();
//   mav.setViewName("boardRegProc2.jsp");
//   try{
//     // 유효성 체크 에러메세지 저장할 변수 msg 선언
//     String msg = "";
//     // check_BoardDTO 메소드 호출하여 유효성 체크하고 경고문자 얻기
//     msg = check_BoardDTO(boardDTO, bindingResult);
//     mav.addObject("msg", msg);
//     // 만약 msg안에 ""가 저장되어 있으면, 즉 유효성 체크를 통과 했으면 DB연동.
//     if(msg.equals("")){
//       int insertBoardCnt = this.boardService.insertBoard(boardDTO);
//       mav.addObject("insertBoardCnt", insertBoardCnt);
//       // 만약 msg 안에 ""가 아니면, 즉 유효성 체크를 통과 못했으면
//     } else {
//       mav.addObject("insertBoardCnt", 0);
//     }

//   }
//   catch(Exception e){
//     mav.addObject("insertBoardCnt", -1);
//     mav.addObject("msg", "서버에서 문제발생! 서버 관리자에게 문의 바람");
//   }
//     return mav;
// }