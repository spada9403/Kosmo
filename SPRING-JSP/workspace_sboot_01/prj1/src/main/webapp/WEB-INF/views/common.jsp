<!--JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기.-->
<!--현재 이 페이지 실행후 생성되는 문서는 html 이고, 이 문서 안의 데이터는 UTF-8 방식으로 인코딩 한다 라고 설정.-->
<!--현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다.-->
<!--UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 무자열을 부호화 할 수 있는 방법이다.-->
<!--모든 JSP 페이지 상단에 무조건 아래 설정이 들어간다.-->
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="/resources/jquery-3.6.0.min.js" type="text/javascript"></script>
<script>
  $(document).ready(function(){
    $("body").prepend('<div><span style="cursor:pointer;" onClick="location.replace('/loginForm.do')" >[로그아웃]</span></div>');
  })
</script>
