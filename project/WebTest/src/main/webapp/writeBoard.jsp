<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*"%>
<%
request.setCharacterEncoding("UTF-8");
String userName = request.getParameter("userName");
String pwd = request.getParameter("pwd");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>새글쓰기</title>
    <script>
      function validCheck(){
        var form = document.writeBoardForm;
        var boardTitle = form.boardTitle.value;
        var boardSubject = form.boardSubject.value;
        if(isEmpty(boardTitle)){
          alert("제목을입력해주세요.")
          return;
        }
        if( boardTitle.length > 20 ){
          alert("제목은 20자 이내로 작성해주세요.");
          return;
        }
        if(isEmpty(boardSubject)){
          alert("내용을 입력해주세요");
          return;
        }
        if(boardSubject.length > 3000){
          alert("내용은 3000자 이내로 작성해주세요")
          return;
        }
        form.submit();
      }
      function isEmpty(str){
        if(str.split(" ").join("") == ""){
          return true;
        } else {
          return false;
        }
      }
    </script>
  </head>
  <body>
    <form action="createBoard.jsp" method="post" name="writeBoardForm">
      <table border="1" style="border-collapse:collapse" cellpadding="5">
      <tr>
        <th>제목</th>
        <td>
          <input size="70%" name="boardTitle" type="text"/>
        </td>
        <th>글쓴이</th>
        <td><%=userName%></td>
      <tr>
        <th>내용</th>
        <td colspan="3" >
          <textarea style="resize:none" cols="90" max="10" rows="10" name = "boardSubject"></textarea>
        </td>
      </tr>
    </table>
      <input type="button" value="저장" onclick="validCheck()">
      <input type="button" value="취소" onclick="history.go(-1)">
      <input type="hidden" name="userName" value="<%=userName%>" />
      <input type="hidden" name="pwd" value="<%=pwd%>" />
    </form>
    <style>
      th{
        background-color:lightgray;
      }
    </style>
  </body>
</html>
