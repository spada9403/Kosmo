<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@include file="./common.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>staff_input_form</title>
    <link href="/resources/staffInputForm/staffInputForm.css" rel="stylesheet" type="text/css" />
    <script src="/resources/staffInputForm/staffInputForm.js" type="text/javascript"></script>
  </head>
  <body>
  <%@include file="./partials/header.jsp"%>
    <center>
      <form method="post" name="staffInputForm">
        <table class="inputTable">
          <tr>
            <th colspan="6">사원 정보 등록</th>
          </tr>
          <tr>
            <th>이름</th>
            <td><input type="text" name="staffName" /></td>
            <th>주민번호</th>
            <td><input type="text" name="jumin_no" maxlength=6 /> - <input type="password" name="jumin_no" maxlength=7 /></td>
            <th>종교</th>
            <td>
              <select name="religion">
                <option value=""></option>
                <option value="1">기독교</option>
                <option value="2">천주교</option>
                <option value="3">불교</option>
                <option value="4">이슬람</option>
                <option value="5">무교</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>학력</th>
            <td>
              <input type="checkbox" name="staffSchool" value="1" />고졸<input type="checkbox" name="staffSchool" value="2" />전문대졸<input type="checkbox" name="staffSchool" value="3" />일반대졸
            </td>
            <th>기술</th>
            <td colspan="3">
              <input type="checkbox" name="staffSkill" value="1" />Java<input type="checkbox" name="staffSkill" value="2" />JSP<input type="checkbox" name="staffSkill" value="3" />ASP<input
                type="checkbox"
                name="staffSkill"
                value="4"
              />PHP<input type="checkbox" name="staffSkill" value="5" />Delphi
            </td>
          </tr>
          <tr>
            <th>졸업일</th>
            <td class="staffGradDay" colspan="5">
              <select name="staffGradDay">
                <option value=""></option>
                <c:forEach var="i" begin="2000" end="2030" varStatus="status">
                  <option value="${i}">${i}</option>
                </c:forEach>
              </select>
              년
              <select name="staffGradDay" disabled >
                <option value=""></option>
              </select>
              월
              <select name="staffGradDay" disabled >
                <option value=""></option>
              </select>
              일
            </td>
          </tr>
        </table>
        <div class="btnBox">
          <input type="button" value="등록" class="confirm" />
          <input type="reset" value="초기화" class="reset" />
        </div>
      </form>
    </center>
  </body>
</html>
