<!--JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기.-->
<!--현재 이 페이지 실행후 생성되는 문서는 html 이고, 이 문서 안의 데이터는 UTF-8 방식으로 인코딩 한다 라고 설정.-->
<!--현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다.-->
<!--UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 무자열을 부호화 할 수 있는 방법이다.-->
<!--모든 JSP 페이지 상단에 무조건 아래 설정이 들어간다.-->
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>LoginForm</title>
  </head>
  <body>
    <span class="upDelBoardCnt"><%out.print( request.getAttribute("upDelBoardCnt") );%></span>
    <span class="msg"><%out.print( (String)request.getAttribute("msg") );%></span>
  </body>
</html>
