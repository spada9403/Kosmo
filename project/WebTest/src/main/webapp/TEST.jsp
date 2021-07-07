<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script>
      function check() {
        if (document.loginForm.uid.value.split(" ").join("") == "") {
          alert("아이디확인");
        } else if (document.loginForm.pwd.value.split(" ").join("") == "") {
          alert("비밀번호 확인");
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
            <td><input name="uid" type="text" /></td>
          </tr>
          <tr>
            <th>비밀번호</th>
            <td><input name="pwd" type="password" /></td>
          </tr>
        </table>
        <input type="button" value="로그인" onclick="check()" />
      </form>
    </center>
  </body>
</html>
<!--
        <% Connection conn=null; String driver="oracle.jdbc.driver.OracleDriver"; String url="jdbc:oracle:thin:@localhost:1521:XE"; Boolean connect=false; try{ Class.forName(driver); //드라이버로드
      conn=DriverManager.getConnection(url,"king","k123"); connect=true; if(connect){ %> 연결성공 <% } else { %> 연결실패 <% } Statement stmt = conn.createStatement(); ResultSet rs =
      stmt.executeQuery("SELECT e.EMP_NAME , e.JIKUP, e.HIRE_DATE, e.JUMIN_NUM, d.DEP_NAME FROM EMPLOYEE e inner join dept d on e.dep_no =d.dep_no"); rs.close();stmt.close();conn.close();
      }catch(Exception e){ connect=false; e.printStackTrace(); } %>
-->
