package com.naver.prj1;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


//  URL 주소로 접속하면 호출되는 메소드를 소유한 [컨트롤러 클래스]선언
//  @Controller 를 붙임으로써 [컨트롤러 클래스]임을 지정한다.
@Controller
@RequestMapping(value = "/naver")
public class LoginController {
    /*
    // SqlSessionTemplate 객체를 생성해 속변 sqlSession 에 저장
    // @Autowired 어노테이션을 붙이면 자료형에 맞는 SqlSessionTemplate 객체를 생성한다.
    // 결국 속성변수 sqlSession 에는 SqlSessionTemplate 객체의 메위주가 저장되어 있다.
    // SqlSessionTemplate 객체의 메소드를 이용하면  xml에 저장된 sql 구문을 읽어서 DB연동을 할 수 있따.
    @Autowired
    private SqlSessionTemplate sqlSession;
    */
    //속성변수 loginDAO 선언하고 loginDAO 라는 인터페이스를 구현한 클래스를 객체화하여 저장
    // 즉 속성변수 loginDAO에는 LoginDAOImple 객체의 메위주가 저장된다.
    // @Autowired 이 붙은 속성변수에는 인터페이스 자료형을 쓰고 이 인터페이스를 구현한 클래스를 객체화하여 저장한다.
    // LoginDAO 라는 인터페이스를 구현한 클래스의 이름을 몰라도 관계없다. 1개 존재하기만 하면 된다.
    @Autowired
    private LoginDAO loginDAO;

    //가상주소 /loginForm.do 로 접근하면 호출되는 메소드 선언
    @RequestMapping(value = "/loginForm.do")
    public ModelAndView loginForm(){
        //ModelAndView 객체 생성
        //ModelAndView 객체 에 호출 JSP 페이지명 저장.
        //ModelAndView 객체 리턴하기
        ModelAndView mav = new ModelAndView();
        //setViewName => JSP 페이지명을 저장할떄 사용하는 ModelAndView객체의 메소드이다.
        mav.setViewName("loginForm.jsp");
        return mav;
    }
    @RequestMapping(value = "/loginProc3.do")
    public ModelAndView loginProc(
        @RequestParam( value = "login_id") String login_id,
        @RequestParam( value = "pwd") String pwd,
        HttpSession session,
        HttpServletResponse response
    ){
        Map<String, String> map = new HashMap<String,String>();
        map.put("login_id",login_id);
        map.put("pwd",pwd);
        int login_idCnt = loginDAO.getLogin_idCnt(map);
        ModelAndView mav = new ModelAndView();
        if(login_idCnt == 1){
            // httpSession 객체에 로그인 아이디 저장하기.
            // httpSession 객체에 로그인 아이디를 저장하면 재 접속했을때 다시 꺼낼수 있다.
            // <참고> HttpSession 객체는 접속한 이후에도 제거되지 않고 지정된 기간동안 살아있는 객체이다.
            // <참고> HttpsServletRequest,HttpServletResponse 객체는 접속때 생성되고 응답 이후 삭제되는 객체이다.
            session.setAttribute("login_id", login_id);
            session.setAttribute("pwd", pwd);
            if(Util.isNull(login_id) && Util.isNull(pwd)){
                Util.addCookie("login_id", null, 0, response);
                Util.addCookie("pwd", null, 0, response);
            } else {
                Util.addCookie("login_id", login_id, 60*60*24, response);
                Util.addCookie("pwd", pwd, 60*60*24, response);
            }
        }
        mav.setViewName("loginProc.jsp");
        mav.addObject("idcnt" , login_idCnt);
        return mav;
    }
    //  가상주소 /logout.do로 접근하면 호출되는 메소드 선언
    @RequestMapping(value = "/logout.do")
    public ModelAndView logout(
        HttpSession session
    ){
        //  HttpSession 객체에 "login_id"라는 키값으로 저장된 데이터 삭제하기
        //  HttpSession 객체에 로그인 성공 후 저장된 아이디 값을 지우기
        session.removeAttribute("login_id");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("logout.jsp");
        return mav;
    }
    //  가상주소 /login_alert.do로 접근하면 호출되는 메소드 선언
    @RequestMapping(value = "/login_alert.do")
    public ModelAndView login_alert(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login_alert.jsp");
        return mav;
    }
    @RequestMapping(value = "/loginProc2.do" , method= RequestMethod.POST)
    public ModelAndView loginProc2(HttpServletRequest request){
        String login_id = request.getParameter("login_id");
        String pwd = request.getParameter("pwd");
        // HashMap 객체에 로그인 아이디, 암호 저장하기
        Map<String,String> map = new HashMap<String,String>();
        map.put("login_id", login_id);
        map.put("pwd", pwd);
        //DB 연동
        int login_idCnt = loginDAO.getLogin_idCnt(map);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("loginProc.jsp");
        mav.addObject("idcnt" , login_idCnt);
        return mav;
    }
    @RequestMapping(value = "/loginProc.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int loginProc3(
        @RequestParam( value = "login_id" ) String login_id,
        @RequestParam( value = "pwd" ) String pwd,
        @RequestParam( value = "is_login", required = false ) String is_login,
        HttpSession session,
        HttpServletResponse response
    ){
        Map<String,String> map = new HashMap<String,String>();
        map.put("login_id", login_id);
        map.put("pwd",pwd);
        int login_idCnt = loginDAO.getLogin_idCnt(map);
        if(login_idCnt==1){
         session.setAttribute("login_id", login_id);
         session.setAttribute("pwd", pwd);
        }
        return login_idCnt;
    }
}
