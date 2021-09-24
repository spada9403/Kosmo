<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@include file="./common.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Search Staff Page</title>
    <link href="/resources/staffSearchForm/staffSearchForm.css" rel="stylesheet" type="text/css" />
    <script src="/resources/staffSearchForm/staffSearchForm.js" type="text/javascript"></script>
  </head>
  <body>
    <center>
      <form name="staffSearchForm" method="post">
        <table class="inputTable">
          <tr>
            <th colspan="6">사원 정보 검색</th>
          </tr>
          <tr>
            <th>키워드</th>
            <td><input type="text" name="keyword" /></td>
            <th>성별</th>
            <td><input type="checkbox" name="staffGender" value="남" />남<input type="checkbox" name="staffGender" value="여" />여</td>
            <th>종교</th>
            <td>
              <select name="religion">
                <option value="0"></option>
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
            <td colspan="5">
              <select name="staffGradDay_start">
                <option value=""></option>
                <c:forEach var="i" begin="2000" end="2030" varStatus="status">
                  <option value="${i}">${i}</option>
                </c:forEach>
                </select>년
              <select name="staffGradDay_start" disabled >
                <option value=""></option>
                <option value="">졸업년도를 선택해주세요</option>
              </select>
              월
              <select name="staffGradDay_start" disabled >
                <option value=""></option>
                <option value="">졸업년도를 선택해주세요</option>
              </select>
              일 ~
              <select name="staffGradDay_end">
                <option value=""></option>
                <c:forEach var="i" begin="2000" end="2030" varStatus="status">
                  <option value="${i}">${i}</option>
                </c:forEach>
                </select>년
              <select name="staffGradDay_end" disabled >
                <option value=""></option>
                <option value="">졸업년도를 선택해주세요</option>
              </select>
              월
              <select name="staffGradDay_end" disabled >
                <option value=""></option>
                <option value="">졸업년도를 선택해주세요</option>
              </select>
              일
            </td>
          </tr>
        </table>
        <div class="searchBox">
          <input type="button" value="검색" class="search" />
          <input type="button" value="모두 검색" class="allSearch" />
          <input type="reset" value="초기화" class="reset" />
          <input type="button" value="등록" class="insert" />
        </div>
        <input type="hidden" name="selectPage" value="1" />
      <select name="rowCntPerPage" class="rowCntPerPage">
      <option value=5 >5</option>
      <option value=10 >10</option>
      <option value=15 >15</option>
      <option value=20 >20</option>
      </select> 행 보기
          <input type="hidden" name="sort" class="sort" value="" />
      </form>
      <div class="staffListBox">
        <c:if test="${staffList != null}">
          <c:if test="${staffList.size()==0}">
            <h1>검색결과가 없습니다!</h1>
          </c:if>
          <c:if test="${staffList.size()>0}">
            <span>검색 건수 -> ${staffListCnt}/${totCnt}</span>
            <table class="staffList">
              <tr>
                <th><span class="sortRow" id="staff_no">번호</span></th>
                <th><span class="sortRow" id="staff_name">이름</span></th>
                <th>성별</th>
                <th><span class="sortRow" id="religion_code">종교</span></th>
                <th>기술</th>
                <th><span class="sortRow" id="graduate_day">졸업일</span></th>
                <th>수정/삭제</th>
              </tr>
              <c:forEach var="staff" items="${staffList}" varStatus="status">
                <tr>
                  <td>${(pagingNo.selectPageNo*pagingNo.rowCntPerPage-pagingNo.rowCntPerPage+1)+status.index}</td>
                  <td>${staff.staffName}</td>
                  <td>${staff.staffGender}</td>
                  <td>${staff.religionName}</td>
                  <td>${empty staff.staffSkill ? "없음" : staff.staffSkill}</td>
                  <td>${staff.graduateDay}</td>
                  <td><input class="upDelButton" type="button" value="수정/삭제" id="${staff.staffNo}" /></td>
                </tr>
              </c:forEach>
            </table>
          </c:if>
        </c:if>
        <c:if test="${staffList == null}">
          <h1>Search Staff!</h1>
        </c:if>
        <div class="pageNo">
          <c:if test="${pagingNo.totRowCnt>0}">
            <c:if test="${pagingNo.selectPageNo>1}">
              <span class="pointer" id="1">처음</span>
              <span class="pointer" id="${pagingNo.selectPageNo - 1}">이전</span>
              &nbsp;&nbsp;
            </c:if>
            <c:if test="${pagingNo.selectPageNo<=1}">
              <span>처음</span>
              <span>이전</span>
              &nbsp;&nbsp;
            </c:if>
            <c:forEach var="i" begin="${pagingNo.min_pageNo}" end="${pagingNo.max_pageNo}">
              <c:if test="${pagingNo.selectPageNo == i}"> <span>${i}</span>&nbsp; </c:if>
              <c:if test="${pagingNo.selectPageNo != i}"> <span class="pointer" id="${i}">[${i}]</span>&nbsp; </c:if>
            </c:forEach>
            <c:if test="${pagingNo.selectPageNo<pagingNo.last_pageNo}">
              &nbsp;&nbsp;
              <span class="pointer" id="${pagingNo.selectPageNo + 1}">다음</span>
              <span class="pointer" id="${pagingNo.last_pageNo}">마지막</span>
            </c:if>
            <c:if test="${pagingNo.selectPageNo>=pagingNo.last_pageNo}">
              &nbsp;&nbsp;
              <span>다음</span>
              <span>마지막</span>
            </c:if>
          </c:if>
        </div>
      </div>
      <form action="/staff_updel_form.do" method="post" name="staffUpDelForm">
        <input type="hidden" name="staffNo" />
      </form>
    </center>
  </body>
</html>
