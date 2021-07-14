<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
request.setCharacterEncoding("UTF-8");

String userName = request.getParameter("userName");
String userEmail = request.getParameter("userEmail");
String[] birthDate = request.getParameter("birthDay").split("-");
String birthDay = "";
for(String a:birthDate){
    birthDay += a;
}
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    String driver="oracle.jdbc.driver.OracleDriver"; 
    String url="jdbc:oracle:thin:@localhost:1521:XE";
    int pk;
try{
     Class.forName(driver);
     conn = DriverManager.getConnection(url,"king","k123");
     pstmt = conn.prepareStatement("select * from USERLIST where userName = ? and birthDay = ?");
     pstmt.setString(1,userName);
     pstmt.setString(2,birthDay);
     rs = pstmt.executeQuery();
     if(rs.next()){
       %>BADDDD<%
     } else {
        pstmt = conn.prepareStatement("select max(rownum) \"ROWNUM\" from USERLIST");
        rs = pstmt.executeQuery();
        if(rs.next()){
            if(rs.getInt("ROWNUM") == 0){
                pk = 1;
            } else {
                pk = rs.getInt("ROWNUM") + 1;
            }
            pstmt = conn.prepareStatement("insert INTO USERLIST(userId,userName,userEmail,birthDay) VALUES (?,?,?,?)");
            pstmt.setInt(1,pk);
            pstmt.setString(2,userName);
            pstmt.setString(3,userEmail);
            pstmt.setString(4,birthDay);
            pstmt.executeQuery();
            response.sendRedirect("TEST.jsp");
        } else {
            %>BAD<%
        }
     }
} catch(Exception e) {
    out.println(e);
} finally {

}
%>