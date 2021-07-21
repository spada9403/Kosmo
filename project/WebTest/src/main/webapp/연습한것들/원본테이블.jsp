<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
        <%request.setCharacterEncoding("utf-8"); 
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
          int viewRow=5;
          int viewPage=1;
          int count = 0;
          if(request.getParameter("viewRow") != null){
            viewRow = Integer.parseInt(request.getParameter("viewRow"));
          }
          if(request.getParameter("viewPage") != null){
            viewPage = Integer.parseInt(request.getParameter("viewPage"));
          }
          int startNum = ((viewRow*viewPage)-viewRow);
          int endNum = (viewRow*viewPage);
          %>
          <center>
          <form method="post" action="TABLE.jsp" name="tableForm">
          <div style="">
          <select name="viewRow" onChange="
          document.tableForm.submit();
          ">
          <option value="5" <%if(viewRow == 5){%>selected<%}%>  >5개씩 보기</option>
          <option value="10" <%if(viewRow == 10){%>selected<%}%> >10개씩 보기</option>
          <option value="15" <%if(viewRow == 15){%>selected<%}%> >15개씩 보기</option>
          <option value="20" <%if(viewRow == 20){%>selected<%}%> >20개씩 보기</option>
          </select>
          </div>
          <%
          pstmt = conn.prepareStatement("SELECT e.*, ROWNUM FROM employee e");
          rs = pstmt.executeQuery();
          %>
          <div style = "margin: 20px 0px;">
          <table border="1" style="border-collapse: collapse" cellpadding = "5">
          <tr>
          <th>직원번호</th>
          <th>직원이름</th>
          <th>부서번호</th>
          <th>직원직급</th>
          <th>직원연봉</th>
          <th>직원입사일</th>
          <th>직원주민번호</th>
          <th>직원핸드폰번호</th>
          <th>직속상사직원번호</th>
          </tr>
          <%
          while(rs.next()){
            if( (rs.getInt("rownum")) > startNum && (rs.getInt("rownum")) <= endNum ){
              %>
              <tr>
              <th><%=rs.getInt("EMP_NO")%></th>
              <th><%=rs.getString("EMP_NAME")%></th>
              <th><%=rs.getInt("DEP_NO")%></th>
              <th><%=rs.getString("JIKUP")%></th>
              <th><%=rs.getInt("SALARY")%></th>
              <th><%=rs.getDate("HIRE_DATE")%></th>
              <th><%=rs.getString("JUMIN_NUM")%></th>
              <th><%=rs.getString("PHONE_NUM")%></th>
              <th><%=rs.getInt("MGR_EMP_NO")%></th>
              </tr>
              <%
            }
            count++;
          }
           %>
           </table>
          </div>
           <input type="button" value="<" onClick="
            var sel = parseInt(document.getElementById('pointPage').value);
            for(var i = 0; i< (document.tableForm.viewPage).length; i++){
              if((document.tableForm.viewPage)[i].value == ( sel - 1 ) ){
                (document.tableForm.viewPage)[i].click();
              }
            }
           "/>
           <%
           for(int i = 1; i <= Math.ceil((double)count/viewRow);i++){
             if(viewPage == i){%>
             <input type="submit" disabled name="viewPage" id="pointPage" value="<%=i%>" />
             <%} else {%>
             <input type="submit" name="viewPage" value="<%=i%>" />
             <%}
           }
           %>
           <input type="button" value=">" onClick="
            var sel = parseInt(document.getElementById('pointPage').value);
            for(var i = 0; i< (document.tableForm.viewPage).length; i++){
              if((document.tableForm.viewPage)[i].value == ( sel +1 ) ){
                (document.tableForm.viewPage)[i].click();
              }
            }
           "/>
           <input type="hidden" name="uid" value = "<%=id%>"/>
           <input type="hidden" name="pwd" value = "<%=pwd%>" />
           </form>
          </center>
           <%
        } else {
          %><h1>데이터가 없습니다! 아이디와 암호를 확인해주세요</h1><%
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