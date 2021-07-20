<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.util.*" %>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="org.json.simple.parser.*"%>
<%
    request.setCharacterEncoding("UTF-8");
    JSONArray arr = (JSONArray)request.getSession().getAttribute("table");
    ArrayList<JSONObject> list = new ArrayList<JSONObject>(arr);
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script>
        var obj = <%=list%>
        var listTable = [];
        function init(){
        for (const key in obj) {
            listTable.push(obj[key]);
        }
        for(const index in listTable){
            var tr = document.createElement("tr");
            for(const key in listTable[index]){
                var td = document.createElement("td");
                td.innerText = listTable[index].key;
                tr.appendChild(td);
                console.log(key);
                console.log(listTable[index].key)
            }
            document.getElementsByTagName("tbody")[0].appendChild(tr);
        }
        console.log(listTable);
        }
    </script>
  </head>
  <body onLoad="init()">
    <center>
    <table border="1" style="border-collapse:collapse" cellpadding="%">
        <tr>
            <th>직원 번호</th>
            <th>직원 이름</th>
            <th>직원 직급</th>
            <th>직원 입사일</th>
            <th>직원 연봉</th>
            <th>직원 주민번호</th>
            <th>직원 폰번호</th>
            <th>직원 상사번호</th>
        </tr>
    </table>
    </center>
  </body>
</html>