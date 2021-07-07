<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ page import="java.sql.*" %> <% request.setCharacterEncoding("utf-8"); String id =
request.getParameter("uid");%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <% Connection conn=null; String driver="oracle.jdbc.driver.OracleDriver"; String url="jdbc:oracle:thin:@localhost:1521:XE"; Boolean connect=false; try{ Class.forName(driver); //드라이버로드
    conn=DriverManager.getConnection(url,"king","k123"); connect=true; if(connect){%> 연결성공 <% } else { %> 연결실패 <% } Statement stmt = conn.createStatement(); ResultSet rs =
    stmt.executeQuery("SELECT * FROM employee"); %>
    <center>
      <table border="1" style="border-collapse: collapse">
        <caption align="top">
          <h1>직원명단</h1>
        </caption>
        <tr>
          <th>직원번호</th>
          <th>직원이름</th>
          <th>부서번호</th>
          <th>직급</th>
          <th>연봉</th>
          <th>입사일</th>
          <th>주민번호</th>
          <th>핸드폰번호</th>
          <th>직속상관번호</th>
        </tr>

        <% while(rs.next()){%>
        <tr>
          <th><%=rs.getString("EMP_NO")%></th>
          <th><%=rs.getString("EMP_NAME")%></th>
          <th><%=rs.getString("DEP_NO")%></th>
          <th><%=rs.getString("JIKUP")%></th>
          <th><%=rs.getString("SALARY")%></th>
          <th><%=rs.getString("HIRE_DATE")%></th>
          <th><%=rs.getString("JUMIN_NUM")%></th>
          <th><%=rs.getString("PHONE_NUM")%></th>
          <th><%=rs.getString("MGR_EMP_NO")%></th>
        </tr>
        <%}%>
      </table>
      <h1>고객명단</h1>
      <table border="1" style="border-collapse: collapse">
        <tr>
          <th>고객번호</th>
          <th>고객이름</th>
          <th>고객전화번호</th>
          <th>주민번호</th>
          <th>담당직원번호</th>
        </tr>
        <%rs = stmt.executeQuery("SELECT * FROM CUSTOMER"); while(rs.next()) {%>

        <tr>
          <th><%=rs.getString("CUS_NO")%></th>
          <th><%=rs.getString("CUS_NAME")%></th>
          <th><%=rs.getString("TEL_NUM")%></th>
          <th><%=rs.getString("JUMIN_NUM")%></th>
          <th><%=rs.getString("EMP_NO")%></th>
        </tr>
        <%} %>
      </table>
    </center>
    <% rs.close();stmt.close();conn.close(); }catch(Exception e){ connect=false; e.printStackTrace(); } %>
  </body>
</html>
