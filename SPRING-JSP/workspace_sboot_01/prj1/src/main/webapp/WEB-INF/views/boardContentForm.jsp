<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@page import="com.naver.prj1.BoardDTO"%> <% BoardDTO board = (BoardDTO)request.getAttribute("board"); %>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <script src="/resources/jquery-3.6.0.min.js"></script>
  <script>
    function goBoardUpDelForm() {
      document.boardUpDelForm.submit();
    }
    function goBoardRegForm() {
      document.boardRegForm.submit();
    }
  </script>
  <body>
    <center>
      <% 
      if( board != null ){
        int b_no = board.getB_no(); 
        String subject = board.getSubject();
        String content = board.getContent();
        String writer = board.getWriter();
        String reg_date = board.getReg_date();
        int readcount = board.getReadcount();
        String email = board.getEmail();
      %>
      <b>글 상세보기</b>
      <table border="1" style="border-collapse: collapse" cellpadding="5">
        <tr align="center">
          <th bgcolor="lightgray">글번호</th>
          <td><%=b_no%></td>
          <th bgcolor="lightgray">조회수</th>
          <td><%=readcount%></td>
        </tr>
        <tr align="center">
          <th bgcolor="lightgray">작성자</th>
          <td><%=writer%></td>
          <th bgcolor="lightgray">작성일</th>
          <td><%=reg_date%></td>
        </tr>
        <tr align="center">
          <th bgcolor="lightgray">글제목</th>
          <td colspan="3"><%=subject%></td>
        </tr>

        <tr align="center">
          <th bgcolor="lightgray">글내용</th>
          <td colspan="3"><textarea name="content" cols="45" rows="13" style="border: 0" readonly><%=content%></textarea></td>
        </tr>
      </table><br>
      <input type="button" value="댓글쓰기" onClick="goBoardRegForm();"/>&nbsp;
      <input type="button" value="수정/삭제" onClick="goBoardUpDelForm();"/>&nbsp;
      <input type="button" value="글 목록 보기" onClick="location.replace('/boardList.do')"/>&nbsp;
    <form name="boardUpDelForm" method="post" action="/boardUpDelForm.do">
      <input type="hidden" name="b_no" value="<%=b_no%>" />
    </form>
    <form name="boardRegForm" method="post" action="/boardRegForm.do">
      <input type="hidden" name="b_no" value="<%=b_no%>" />
    </form>
    </center>
    <%
      } else {
        out.print("<script>alert('삭제된 글입니다'); history.go(-1)</script>");    
      }
    %>
  </body>
</html>
