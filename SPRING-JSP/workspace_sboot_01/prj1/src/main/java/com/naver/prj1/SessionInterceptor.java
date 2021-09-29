package com.naver.prj1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.HandlerInterceptor;

// URL 접속 시 [@Controller 가 붙은 클래스의 @RequestMaping가 붙은 메소드]호출 전 또는 후에
// 실행될 메소드를 소유한 [SessionInterceptor 클래스] 선언.
// HandlerInterceptor 인터페이스를 구현해야 한다.
//---------------------------------------------------------------
// [@Controller 가 붙은 클래스의 @RequestMapping 가 붙은 메소드] 호출 전 또는 후에 
// 실행될 메소드를 소유한 클래스가 될 자격 조건
//---------------------------------------------------------------
//		<1> 스프링이 제공하는 [HandlerInterceptor 인터페이스]를 구현한다.
//		<2> @RequestMapping 가 붙은 메소드 호출 전에 실행할 코딩은 
//				HandlerInterceptor 인터페이스의 preHandle 메소드를 재정의 하면서 삽입한다.
//		<3> @RequestMapping 가 붙은 메소드 호출 후에 실행할 코딩은 
//				HandlerInterceptor 인터페이스의 postHandle 메소드를 재정의 하면서 삽입한다.
//---------------------------------------------------------------
//---------------------------------------------------------------
// [HandlerInterceptor 인터페이스 구현 객체]의 메소드 종류와 호출 시점
//---------------------------------------------------------------
// preHandle()       :  @RequestMapping 가 붙은 메소드 호출 전에 호출되는 메소드. 
//                       true 를 리턴하면  @RequestMapping 가 붙은 메소드를 호출하고
//                       false 를 리턴하면  @RequestMapping 가 붙은 메소드를 호출하지 않는다.
// postHandle()      : @RequestMapping 가 붙은 메소드 호출 후에 호출되는 메소드. 
// afterCompletion() : @RequestMapping 가 붙은 메소드 호출 후 JSP 파일이 호출된 후에 호출되는 메소드


public class SessionInterceptor implements HandlerInterceptor{		

	@Override
	public boolean preHandle(
		HttpServletRequest request 
		, HttpServletResponse response 
		, Object handler
	) throws Exception {
		//---------------------------------------------------------------
		//	HttpSession 객체 얻기
		//	HttpServletRequest 객체의 getSession() 메소드를 호출하면 HttpSession 객체를 얻을 수 있따.
		//---------------------------------------------------------------
		HttpSession session = request.getSession();
		//---------------------------------------------------------------
		//	HttpSession 객체에서 키값이 login_id 로 저장된 데이터 꺼내기. (로그인 정보)
		//---------------------------------------------------------------
		String login_id = (String)session.getAttribute("login_id");	
		// 만약 로그인에 성공한 적이 없으면
		if(login_id==null) {
			// 클라이언트에게 loginForm.do 로 재접속 시키기.
			response.sendRedirect( "/naver/login_alert.do" );
			// false 리턴 하면 @RequestMapping이 붙은 메소드가 실행이 되지 않음.
			return false;
		}
		else { 
			// true 를 리턴하면 @RequestMapping이 붙은 메소드가 실행이 됨.
			return true;
		}
		
	}

}
