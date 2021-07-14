<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script>
        function checkForm(){
            var form = document.createUserForm;
            var userName = form.userName.value;
            var birthDay = form.birthDay.value;
            var userEmail = form.userEmail.value;

            if(userName.split(" ").join("") == ""){
                alert("이름을 입력해주세요");
                return;
            }
            if(birthDay.split(" ").join("") == ""){
                alert("생년월일을 선택해주세요");
                return;
            }
            var regExp = new RegExp(/^[0-9a-zA-Z]*\@[0-9a-zA-Z]*\.[a-z]{2,3}$/);
            if(regExp.test(userEmail)==false){
                alert("이매일 형식에 맞게 입력해주세요");
                return;
            }
            form.submit();
            
        }
    </script>
  </head>
  <body>
  <form name="createUserForm" action="createUserInDB.jsp" method="post">
    <table border="1" style="border-collapse:collapse" cellpadding="5">
        <tr>
            <th>이름</th>
            <th align="left" ><input type="text" name="userName"/></th>
        </tr>
        <tr>
            <th>생년월일</th>
            <th>
            <%
            SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd"); 
            java.util.Date d = new java.util.Date();
            String date = sDate.format(d);
            %>
            <input type="date" name="birthDay" min="1970-01-01" max="<%=date%>"/>
            </th>
        </tr>
        <tr>
            <th>Email</th>
            <th align="left">
                <input type="text" name="userEmail"/>
            </th>
        </tr>
    </table>
    <input type="button" value="회원가입" onClick="checkForm()"/>
  </form>
    <input type="button" value="취소" onClick="location.replace('TEST.jsp')"/>
  </body>
</html>
