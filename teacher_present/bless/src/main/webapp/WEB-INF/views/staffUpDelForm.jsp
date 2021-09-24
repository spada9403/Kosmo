<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@include file="./common.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Search Staff Page</title>
    <link href="/resources/staffUpDelForm/staffUpDelForm.css" rel="stylesheet" type="text/css" />
    <script src="/resources/staffUpDelForm/staffUpDelForm.js" type="text/javascript"></script>
  </head>
  <body>
  <%@include file="./partials/header.jsp"%>
  <c:if test="${!empty staffMap}">
    <center>
      <form method="post" name="staffUpDelForm">
        <table class="inputTable">
          <tr>
            <th colspan="6">사원 정보 등록</th>
          </tr>
          <tr>
            <th>이름</th>
            <td><input type="text" name="staffName" value="${staffMap.STAFF_NAME}" /></td>
            <th>주민번호</th>
            <td><input type="text" name="jumin_no" value="${fn:substring(staffMap.JUMIN_NO, 0, 6)}" /> - <input type="password" name="jumin_no" value="${fn:substring(staffMap.JUMIN_NO, 7, 14)}" /></td>
            <th>종교</th>
            <td>
              <select name="religion">
                <option value=""></option>
                <option value="1" ${staffMap.RELIGION_CODE == 1 ? "SELECTED" : ""} >기독교</option>
                <option value="2" ${staffMap.RELIGION_CODE == 2 ? "SELECTED" : ""} >천주교</option>
                <option value="3" ${staffMap.RELIGION_CODE == 3 ? "SELECTED" : ""} >불교</option>
                <option value="4" ${staffMap.RELIGION_CODE == 4 ? "SELECTED" : ""} >이슬람</option>
                <option value="5" ${staffMap.RELIGION_CODE == 5 ? "SELECTED" : ""} >무교</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>학력</th>
            <td>
              <input type="checkbox" name="staffSchool" value="1" ${staffMap.SCHOOL_CODE == 1 ? "checked" : ""} />고졸<input type="checkbox" name="staffSchool" value="2" ${staffMap.SCHOOL_CODE == 2 ? "checked" : ""} />전문대졸<input type="checkbox" name="staffSchool" value="3" ${staffMap.SCHOOL_CODE == 3 ? "checked" : ""} />일반대졸
            </td>
            <th>기술</th>
            <td colspan="3">
              <input type="checkbox" name="staffSkill" value="1" ${fn:indexOf(staffMap.staffSkill,"Java") != -1 ? "checked" : "" } />Java
              <input type="checkbox" name="staffSkill" value="2" ${fn:indexOf(staffMap.staffSkill,"JSP") != -1 ? "checked" : "" } />JSP
              <input type="checkbox" name="staffSkill" value="3" ${fn:indexOf(staffMap.staffSkill,"ASP") != -1 ? "checked" : "" } />ASP
              <input
                type="checkbox"
                name="staffSkill"
                value="4"
                ${fn:indexOf(staffMap.staffSkill,"PHP") != -1 ? "checked" : "" }
              />PHP
              <input type="checkbox" name="staffSkill" value="5" ${fn:indexOf(staffMap.staffSkill,"Delphi") != -1 ? "checked" : "" } />Delphi
            </td>
          </tr>
          <tr>
            <th>졸업일</th>
            <td class="staffGradDay" colspan="5">
              <select name="staffGradDay" >
                <option  value="${fn:substring(staffMap.GRADUATE_DAY, 0, 4)}">${fn:substring(staffMap.GRADUATE_DAY, 0, 4)}</option>
                <c:forEach var="i" begin="2000" end="2030" varStatus="status">
                  <option value="${i}">${i}</option>
                </c:forEach>
              </select>
              년
              <select name="staffGradDay">
                <option value="${fn:substring(staffMap.GRADUATE_DAY, 5, 7)}" >${fn:substring(staffMap.GRADUATE_DAY, 5, 7)}</option>
              </select>
              월
              <select name="staffGradDay" >
                <option  value="${fn:substring(staffMap.GRADUATE_DAY, 8, 10)}">${fn:substring(staffMap.GRADUATE_DAY, 8, 10)}</option>
              </select>
              일
            </td>
          </tr>
        </table>
        <div class="btnBox">
          <input type="button" value="수정" class="update" />
          <input type="reset" value="삭제" class="delete" />
        </div>
        <input type="hidden" name="upDel" class="upDel">
        <input type="hidden" name="staffNo" value=${staffMap.STAFF_NO}>
      </form>
    </center>
    </c:if>
  <c:if test="${empty staffMap}">
    <h1 class="error" >ERROR</h1>
    </c:if>
  </body>
</html>
