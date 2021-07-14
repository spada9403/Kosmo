<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script>
      function check() {
        if (document.loginForm.userName.value.split(" ").join("") == "") {
          alert("이름확인");
        } else if (document.loginForm.pwd.value.split(" ").join("") == "") {
          alert("생년월일 확인");
        } else {
          document.loginForm.submit();
        }
      }
    </script>
  </head>
  <body>
    <center>
      <form name="loginForm" action="TABLE.jsp" method="POST">
        <table border="1" style="border-collapse: collapse">
          <tr>
            <th>아이디</th>
            <td><input name="userName" type="text" placeholder="이름"/></td>
          </tr>
          <tr>
            <th>비밀번호</th>
            <td><input name="pwd" type="password"  placeholder="생년월일" /></td>
          </tr>
        </table>
        <input type="button" value="로그인" onclick="check()" />
      </form>
      <button onClick="location.replace('createUser.jsp')">회원가입</button>
    </center>
  </body>
</html>