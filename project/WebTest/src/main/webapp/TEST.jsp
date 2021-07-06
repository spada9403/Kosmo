<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<% Connection conn=null; String driver="oracle.jdbc.driver.OracleDriver"; String url="jdbc:oracle:thin:@localhost:1521:XE"; Boolean connect=false; try{ Class.forName(driver); //드라이버로드
conn=DriverManager.getConnection(url,"king","k123"); connect=true; conn.close(); }catch(Exception e){ connect=false; e.printStackTrace(); } %>
<html>
  <head>
    <meta charset="EUC-KR" />
    <title>Insert title here</title>
  </head>
  <body>
    <h3><%if(connect==true){ %> 연결되었습니다. <%} else if(connect==false){ %> 연결 실패 <%} %></h3>
  </body>
</html>
