<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@page import="java.util.ArrayList"%><%@page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Board List!!</title>
  </head>
  <body>
    <table class="boardTable" border="1" style="border-collapse: collapse;" cellpadding="5">
      <tr>
        <th>글쓴이</th>
        <th>제목</th>
        <th>조회수</th>
        <th>게시날짜</th>
      </tr>
        <% 
        ArrayList<Map> list = (ArrayList<Map>)request.getAttribute("list");
        for(int i = 0; i < list.size(); i++){
            %>
            <tr>
                <td><%out.print(list.get(i).get("WRITER"));%></td>
                <td><%out.print(list.get(i).get("SUBJECT"));%></td>
                <td><%out.print(list.get(i).get("READCOUNT"));%></td>
                <td><%out.print(list.get(i).get("REG_DATE"));%></td>
            </tr>
            <%
        }
        %>
    </table>
  </body>
</html>
