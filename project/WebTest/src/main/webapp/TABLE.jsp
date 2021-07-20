<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
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
        <%request.setCharacterEncoding("utf-8"); 
        String userName = request.getParameter("userName") == null ? (String)request.getSession().getAttribute("userName"): request.getParameter("userName");
        String pwd = request.getParameter("pwd") == null ? (String)request.getSession().getAttribute("pwd"): request.getParameter("pwd");
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
        pstmt = conn.prepareStatement("SELECT * FROM USERLIST where userName = ? and substr(birthDay, 3,6) = ?"); 
        pstmt.setString(1,userName);
        pstmt.setString(2,pwd);
        rs = pstmt.executeQuery();
        if(rs.next()){
          %>
          <div>
          <button onClick="createNewBoard()">새 글쓰기</button>
          <table border="1" style="border-collapse:collapse" cellpadding="5">
            <tr>
                <th>글쓴이</th>
                <th>제목</th>
                <th>조회수</th>
                <th>좋아요</th>
                <th>게시날짜</th>
            </tr>
            <%
            pstmt = conn.prepareStatement("select * from BOARDLIST");
            rs = pstmt.executeQuery();
            try{
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
              while(rs.next()){
              java.util.Date d = rs.getDate("boardCreateDate");
              String date = sdf.format(d);
                %>
                  <tr>
                      <th><%=rs.getString("boardWriter")%></th>
                      <th><%=rs.getString("boardTitle")%></th>
                      <th><%=rs.getInt("boardViewCount")%></th>
                      <th><%=rs.getInt("boardLike")%></th>
                  </tr>
                <%
              }
            } catch(Exception e){
              out.println(e);
            }
            %>
          </table>
          <%
        } else {
          response.sendRedirect("TEST.jsp");
        }
      %>
      <form method="post" action="writeBoard.jsp" name="sendWriteBoardForm">
        <input type="hidden" name="userName" value="<%=userName%>" />
        <input type="hidden" name="pwd" value="<%=pwd%>" />
      </form>
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