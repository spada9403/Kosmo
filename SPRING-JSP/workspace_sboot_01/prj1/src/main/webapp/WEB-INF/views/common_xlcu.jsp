<!-- ****************************************************** -->
<!-- JSP 기술의 한 종류인 [Page Directive]를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- ****************************************************** -->
	<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML 이고,이 문서 안의 데이터는 UTF-8 방식으로 인코딩한다 라고 설정함 -->
	<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩 한다 -->
	<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다. -->
	<!-- 모든 JSP 페이지 상단에 무조건 아래 설정이 들어간다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.naver.erp.Info"%>


<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지에서 사용할 [사용자 정의 태그]의 한 종류인 [JSTL의 C 코어 태그]를 사용하겠다고 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!--
		--------------------------------------
		JSTL 이란?
		--------------------------------------
			=>자카르타라는 단체에서 만든 [사용자 정의 태그]를 말한다.
			=>자바 문법을 HTML 과 같은 태그 형태로 표현한다.
			=>HTML 과 같은 태그 형태로 표현하면 뒤에서 자바 문법으로 바뀌어 실행된다.
			=>JSTL 사용 장점
				-태그 형태이므로 디자이너 퍼블리셔, 초급 개발자가 접근이 쉽다.
				-큰 에러가 아닌 이상 화면이 멈추지 않는다.
				-null 처리에 대해 관대하다. null에 대해 민감한 반응을 보이지않는다. 
			=>JSTL 은 EL 과 같이 쓰인다.

	-->

<!------------------------------------------------------------>
<!-- JSTL 이란 커스텀 태그의 C 코어 태그를 사용하여         -->
<!-- HttpServletRequest 객체  키값-데이터  저장하기         -->
<!------------------------------------------------------------>
<c:set var="thBgcolor" value="lightblue" scope="request"/>
	<!--
	위 코드는 아래 자바 코드와 동일한 기능 가진다.
	<%
		//request.setAttribute("thBgcolor","lightyellow"); #f9f9f9
	%>
	-->
<c:set var="bodycolor" value="#f8fcfc" scope="request"/>
<c:set var="naverPath" value="<%=Info.naverPath%>" scope="request"/>



<!------------------------------------------------------------>
<!-- JQuery 라이브러리 수입하기-->
<!-- 공용 함수 수입하기-->
<!-- css 파일 수입하기-->
<!------------------------------------------------------------>
<script src="/resources/jquery-1.11.0.min.js"></script>
<script src="/resources/common.js"></script>
<link href="/resources/common.css" rel="stylesheet" type="text/css">





<script>
	$(document).ready(function(){
		$("body").prepend(
			"<center><div><span style='cursor:pointer' "
						+ "onclick='location.replace(\"/${requestScope.naverPath}logout.do\");'>[로그아웃]</span></div></center>"
		);

		$("body").attr("bgcolor","${bodycolor}")
	});

	//**********************************************
	// table 태그 내부의 배경색 바꾸는 함수 선언
	//**********************************************
	function changeBgColor(  ){
		setTrBgcolor( 
			//----------------------------------------
			"tbcss0"       // 테이블 태그의 클래스값 
			//----------------------------------------
			,"gray"        // 헤드 tr 의 배경색값
			//----------------------------------------
			,"white"      // .  헤드 tr 이후의 홀수 tr 배경색값
			//, "#eef7ff"
			//----------------------------------------
			,"lightblue"   // 헤드 tr 이후의 짝수 tr 배경색값 
			//----------------------------------------
			,"#FFE5CB"     // 마우스 댔을 때 배경색값
		);
	}
</script>


