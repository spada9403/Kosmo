<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Home</title>
    <script>
      function createNewBoard() {
        document.sendWriteBoardForm.submit();
      }
    </script>
  </head>
  <body>
        <%
        request.setCharacterEncoding("utf-8"); 
        String userName = request.getParameter("userName") == null ? (String)request.getSession().getAttribute("userName"): request.getParameter("userName");
        String pwd = request.getParameter("pwd") == null ? (String)request.getSession().getAttribute("pwd"): request.getParameter("pwd");
        int pageRow = request.getParameter("pageRow") == null ? 5 : Integer.parseInt(request.getParameter("pageRow"));
        int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
        Connection conn=null; 
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String driver="oracle.jdbc.driver.OracleDriver"; 
        String url="jdbc:oracle:thin:@localhost:1521:XE";
        Boolean connect=false; 
        try{ 
        Class.forName(driver); //드라이버로드
        conn=DriverManager.getConnection(url,"king","k123"); 
        connect=true; 
        pstmt = conn.prepareStatement("SELECT * FROM employee where emp_name = ? and substr(jumin_num, 7,7) = ?"); 
        pstmt.setString(1,userName);
        pstmt.setString(2,pwd);
        rs = pstmt.executeQuery();
        if(rs.next()){
          pstmt = conn.prepareStatement("select count(*) from employee");
          rs = pstmt.executeQuery();
          if(rs.next()){
            int count = rs.getInt("count(*)");
            pstmt = conn.prepareStatement("select * from (select e.*, rownum \"RNUM\" from employee e where rownum < ?) e where e.RNUM >= ?");
            int endNum = (pageRow*pageNum)+1;
            int startNum = ((pageRow*pageNum)+1)-pageRow;
            pstmt.setInt(1,endNum);
            pstmt.setInt(2,startNum);
            rs = pstmt.executeQuery();
            if(rs.next()){
              JSONArray arr = new JSONArray();
              do{
              JSONObject jsonMap = new JSONObject();
              jsonMap.put("emp_no",rs.getInt("emp_no"));
              jsonMap.put("emp_name",rs.getString("emp_name"));
              jsonMap.put("jikup",rs.getString("jikup"));
              jsonMap.put("hire_date",rs.getString("hire_date"));
              jsonMap.put("salary",rs.getInt("salary"));
              jsonMap.put("jumin_num",rs.getString("jumin_num"));
              jsonMap.put("phone",rs.getString("phone"));
              jsonMap.put("mgr_emp_no",rs.getInt("mgr_emp_no"));
              arr.add(jsonMap);
              }while(rs.next());
              pageContext.getSession().setAttribute("table",arr);
              response.sendRedirect("tableJs.jsp");
            }
          }
        }
        %>
  </body>
</html>
<%
    } catch(Exception e){
      out.println(e);
    } finally {
      if(rs != null)rs.close();
      if(pstmt != null)pstmt.close();
      if(conn != null)conn.close();
    }
%>