<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*"%>
<% 
request.setCharacterEncoding("UTF-8"); 
int pk;
String boardTitle = request.getParameter("boardTitle");
String userName = request.getParameter("userName");
String pwd = request.getParameter("pwd");
String boardSubject = request.getParameter("boardSubject");
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:XE";
try{
    Class.forName(driver);
    conn = DriverManager.getConnection(url,"king","k123");
    pstmt = conn.prepareStatement("select count(*) \"RNUM\" from BOARDLIST");
    rs = pstmt.executeQuery();
    if(rs.next()){
        if(rs.getInt("RNUM") == 0) {
            pk = 1;
        } else {
        pk = rs.getInt("RNUM")+1;
        }
        pstmt = conn.prepareStatement("insert into BOARDLIST(boardId,boardTitle,boardWriter,boardSubject) VALUES (?,?,?,?)");
        pstmt.setInt(1, pk);
        pstmt.setString(2,boardTitle);
        pstmt.setString(3,userName);
        pstmt.setString(4,boardSubject);
        pstmt.executeQuery();

        //response.sendRedirect로 파라메터 값 post로 넘기기!!
        pageContext.getSession().setAttribute("userName", userName);
        pageContext.getSession().setAttribute("pwd", pwd);
        response.sendRedirect("TABLE.jsp");
        // sendRedirect로 post 방식 parameter를 보낼때는 getSession()으로 세션을 불러와 세션에 setAttribute() 함수로 속성이름과 속성값을 지정해주고 보낸다.
        // redirect로 파라메터값을 받을떄에는 request.getParameter()가 아닌!! getSession().getAttibute() 으로 세션을 불러와서 세션에 있는 속성이름을 검색해 속성값을 얻는다.
    } else {
        %>BADDD<%
    }
} catch(Exception e){
    out.println(e);
} finally {
    if(rs != null)rs.close();
    if(pstmt != null)pstmt.close();
    if(conn != null)conn.close();
}
%>