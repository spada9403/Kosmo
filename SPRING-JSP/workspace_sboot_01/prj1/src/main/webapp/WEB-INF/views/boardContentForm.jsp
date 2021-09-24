<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@page import="com.naver.prj1.BoardDTO"%> 
<%@include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <script>
    function goBoardUpDelForm() {
      document.boardUpDelForm.submit();
    }
    function goBoardRegForm() {
      document.boardRegForm.submit();
    }
    $(document).ready(function () {
        $("th").css({
          "background-color":"${bgColor}"
        })
    })
  </script>
  <body>
    <center>
      <c:if test="${!empty board}">
      <b>글 상세보기</b>
      <table border="1" style="border-collapse: collapse" cellpadding="5">
        <tr align="center">
          <th bgcolor="lightgray">글번호</th>
          <td>${board.b_no}</td>
          <th bgcolor="lightgray">조회수</th>
          <td>${board.readcount}</td>
        </tr>
        <tr align="center">
          <th bgcolor="lightgray">작성자</th>
          <td>${board.writer}</td>
          <th bgcolor="lightgray">작성일</th>
          <td>${board.reg_date}</td>
        </tr>
        <tr align="center">
          <th bgcolor="lightgray">글제목</th>
          <td colspan="3">${board.subject}</td>
        </tr>

        <tr align="center">
          <th bgcolor="lightgray">글내용</th>
          <td colspan="3"><textarea name="content" cols="45" rows="13" style="border: 0" readonly>${board.content}</textarea></td>
        </tr>
        <tr>
        <th>이미지</th>
        <td colspan="3">
        <c:if test = "${board.pic != null && board.pic.length()>0}">
        <img width="40%" src="/resources/img/${board.pic}">
        </c:if>
        </td>
        </tr>
      </table>
      <br>
      <input type="button" value="댓글쓰기" onClick="goBoardRegForm();"/>&nbsp;
      <input type="button" value="수정/삭제" onClick="goBoardUpDelForm();"/>&nbsp;
      <input type="button" value="글 목록 보기" onClick="location.replace('${requestScope.naverPath}/boardList.do')"/>
    <form name="boardUpDelForm" method="post" action="${requestScope.naverPath}/boardUpDelForm.do">
      <input type="hidden" name="b_no" value="${board.b_no}" />
    </form>
    <form name="boardRegForm" method="post" action="${requestScope.naverPath}/boardRegForm.do">
      <input type="hidden" name="b_no" value="${board.b_no}" />
    </form>
      <c:if test="${empty board}">
        <script>
          alert("삭제된 글입니다");
          location.replace("/boardList.do");
        </script>
      </c:if>
      </c:if>
    </center>
  </body>
</html>
