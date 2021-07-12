<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
      <%
      request.setCharacterEncoding("utf-8"); 
        String id = request.getParameter("uid");
        String pwd = request.getParameter("pwd");
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
        pstmt = conn.prepareStatement("SELECT * FROM employee where EMP_NAME = ? and substr(JUMIN_NUM, 7,7) = ?"); 
        pstmt.setString(1,id);
        pstmt.setString(2,pwd);
        rs = pstmt.executeQuery();
        if(rs.next()){
          String name = rs.getString("EMP_NAME");
          ResultSet login = rs;
              int startNum;
              int endNum;
              int pageLoc;
              int pageNum;
            if(request.getParameter("pageNum") == null){
              pageNum = 5;
            } else {
                pageNum = Integer.parseInt(request.getParameter("pageNum"));
                pageLoc = 1;
            }
            if(request.getParameter("pageLoc") == null){
                pageLoc = 1;
              } else {
                pageLoc = Integer.parseInt(request.getParameter("pageLoc"));
              }
            startNum = (pageNum * pageLoc)-pageNum;
            endNum = (pageNum * pageLoc);
            if("홍길동".equals(name)){
              pstmt = conn.prepareStatement("select * from employee");
            } else {
            pstmt = conn.prepareStatement("select * from (select e.*, rownum \"RNUM\" from employee e where rownum <= ? and MGR_EMP_NO = ?) where RNUM > ?");
            pstmt.setInt(1,endNum);
            pstmt.setInt(2,(rs.getInt("EMP_NO")));
            pstmt.setInt(3,startNum);
            }
            rs = pstmt.executeQuery();
            %>
          <table border="1" style = "border-collapse: collapse" cellpadding="5">
              <tr bgColor="lightgray">
                <th>직원번호</th>
                <th>직원이름</th>
                <th>부서번호</th>
                <th>직급</th>
                <th>연봉</th>
                <th>입사일</th>
                <th>주민번호</th>
                <th>전화번호</th>
                <th>직속상사번호</th>
              </tr>
          <%
            while(rs.next()){
              %>
              <tr>
                <th><%=rs.getInt("EMP_NO")%></th>
                <th><%=rs.getString("EMP_NAME")%></th>
                <th><%=rs.getInt("DEP_NO")%></th>
                <th><%=rs.getString("JIKUP")%></th>
                <th><%=rs.getInt("SALARY")%></th>
                <th><%=rs.getDate("HIRE_DATE")%></th>
                <th><%=rs.getString("JUMIN_NUM")%></th>
                <th><%=rs.getString("PHONE")%></th>
                <th><%=rs.getInt("MGR_EMP_NO")%></th>
              </tr>
              <%
            }
          %>
          </table>
          <form method="post" action="TABLE.jsp" name="sendForm">
          <br><br><br>
          <%
          rs.last();
          int count = rs.getRow();
          for(int i = 0; i < ((double)count/pageNum < 1 ?  Math.floor((double)count/pageNum): Math.ceil((double)count/pageNum)) ; i++){
            %>
            <input type="submit" <%if(pageLoc == i+1){%>disabled<%}%> value = <%=i+1%> name = "pageLoc" />
            <%
          }
          %>
             <br>
            <br>
            <select name="pageNum" onChange=" 
            <%pageLoc=1;%>
            document.sendForm.submit();">
              <option value="5" <%if(pageNum == 5){%>selected<%}%>>5개씩 보기</option>
              <option value="15" <%if(pageNum == 15){%>selected<%}%> >15개씩 보기</option>
              <option value="20" <%if(pageNum == 20){%>selected<%}%>>20개씩보기</option>
            </select>
            <input type="hidden" name = "uid" value = "<%=id%>"/>
            <input type="hidden" name = "pwd" value = "<%=pwd%>"/>
            <input type="hidden" name = "pageNum" value = "<%=pageNum%>"/>
            <input type="hidden" name = "pageLoc" value = "<%=pageLoc%>"/>
          </form>
          <%
        } else {
          %>데이터가 없습니다! 아이디와 암호를 확인해주세요<%
        }
      %>
  </body>
</html>
<%
    } catch(Exception e){
    } finally {
      if(rs != null)rs.close();
      if(pstmt != null)pstmt.close();
      if(conn != null)conn.close();
    }
%>