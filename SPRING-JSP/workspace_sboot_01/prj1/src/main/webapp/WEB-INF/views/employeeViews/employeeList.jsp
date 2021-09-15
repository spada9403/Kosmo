<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <script src="/resources/jquery-3.6.0.min.js" type="text/javascript"></script>
  <script>
      function search(){
          var keyword = $.trim($(".keyword1").val());
          if(keyword == null || keyword.split(" ").join("")==""){
            $(".keyword1").val("");
          }
          $.ajax({
              url: "/employeeList.do",
              type: "post",
              data: $("[name=dataForm]").serialize(),
              success: function( responseHtml ) {
                  $(".employeeList").html(
                      $(responseHtml).find(".employeeList").html()
                  )
                  $(".pageNo").html(
                    $(responseHtml).find(".pageNo").html()
                  )
                  paintBoard();
              },
              error: function () {
                  console.log("bad");
              }
          })
      }
      function searchTableCss() {
        var tableObj = $(".table");
          tableObj.css({
            "margin":"20px 0px"
        })
        tableObj.find("th").css({
          "background-color":"lightgray"
      })
      }
      $(document).ready(function () {
        $(document).keypress(function(e){
          if(e.keyCode == 13){
           e.preventDefault()
           search();
          }
        })
        paintBoard();
        searchTableCss();
        $(".searchButton").css({
            "margin_bottom":"20px"
        })
        $(".search").click(function () {
            search();
        })
        $(".allSearch").click(function () {
            $("[name='keyword1']").val("");
            $("[name='jikup']").filter(":checked").prop("checked", false);
            $("[name^='hire_date']").val("");
            search();
        })
        $(".employeeList").css({
            "margin-top":"20px"
        })
      })
      function paintBoard(){
        var trObj = $(".employeeList table").find("tr");
        trObj.first().css({
          "background-color":"lightgray"
        })
        $("[name=boardListForm]").css({
          "margin-bottom":"15px"
        })
        paintList(trObj);
      }
      function enter(e){
        if(e.keyCode == 13){
          search();
        }
      }
      function search_with_changePageNo(pageNo){
        $(".selectPageNo").val(pageNo);
        search();
      }
      function paintList(trObj) {
        var visibleTrObj = trObj.not(":first-child").filter(":visible");
        var oddTr = visibleTrObj.filter(":odd");
        var evenTr = visibleTrObj.filter(":even");
        oddTr.css({
          "background-color": "#FBE7C6",
        });
        evenTr.css({
          "background-color": "#A0E7E5",
        });
      }
  </script>
  <body>
      <center>
        <caption>[직원 검색]</caption>
        <form method="post" name="dataForm" >   
            <table border="1" style="border-collapse: collapse;" cellpadding="5" class="table">
                <tr>
                    <th>검색 키워드</th>
                    <td><input type="text" name="keyword1" class="keyword1"></td>
                </tr>
                <tr>
                    <th>직급</td>
                    <td align="center">
                        <input type="checkbox" name="jikup" value="사장">사장
                        <input type="checkbox" name="jikup" value="부장">부장
                        <input type="checkbox" name="jikup" value="과장">과장
                        <input type="checkbox" name="jikup" value="대리">대리
                        <input type="checkbox" name="jikup" value="주임">주임
                        <input type="checkbox" name="jikup" value="사원">사원
                    </td>
                </tr>
                <tr>
                    <th>입사일</td>
                    <td>
                        <select name="hire_date_year1" >
                        <option value=0></option>
                            <option value=1960>1960</option>
                            <option value=1970>1970</option>
                            <option value=1980>1980</option>
                            <option value=1990>1990</option>
                            <option value=2000>2000</option>
                        </select>년
                        <select name="hire_date_month1" >
                        <option value=0></option>
                            <option value=1>01</option>
                            <option value=2>02</option>
                            <option value=3>03</option>
                            <option value=4>04</option>
                            <option value=5>05</option>
                            <option value=6>06</option>
                            <option value=7>07</option>
                            <option value=8>08</option>
                            <option value=9>09</option>
                            <option value=10>10</option>
                            <option value=11>11</option>
                            <option value=12>12</option>
                        </select>월
                        ~
                        <select name="hire_date_year2" >
                        <option value=0></option>
                            <option value=1960>1960</option>
                            <option value=1970>1970</option>
                            <option value=1980>1980</option>
                            <option value=1990>1990</option>
                            <option value=2000>2000</option>
                        </select>년
                        <select name="hire_date_month2" >
                        <option value=0></option>
                            <option value=1>01</option>
                            <option value=2>02</option>
                            <option value=3>03</option>
                            <option value=4>04</option>
                            <option value=5>05</option>
                            <option value=6>06</option>
                            <option value=7>07</option>
                            <option value=8>08</option>
                            <option value=9>09</option>
                            <option value=10>10</option>
                            <option value=11>11</option>
                            <option value=12>12</option>
                        </select>월
                    </td>
                </tr>
            </table>
          <select name="rowCntPerPage" class="rowCntPerPage" onChange="search();" >
            <option value=10>10</option>
            <option value=15>15</option>
            <option value=20>20</option>
            <option value=25>25</option>
            <option value=30>30</option>
          </select> 행보기
          <input type="hidden" name="selectPageNo" class="selectPageNo" value=1 />
        </form>
        <div class="searchButton">
            <input type="button" value="검색" class="search">
            <input type="button" value="모두검색" class="allSearch">
        </div>
        <div class="employeeList">
            <table border="1" style="border-collapse:collapse" cellpadding="5">
                <tr>
                    <th>번호</th>
                    <th>직원번호</th>
                    <th>직원명</th>
                    <th>직급</th>
                    <th>입사일</th>
                    <th>소속부서명</th>
                </tr>
                <c:forEach items="${employeeList}" var="item" varStatus="loopTagStatus">
                    <tr>
                        <td>${(requestScope.selectPageNo*requestScope.rowCntPerPage-requestScope.rowCntPerPage+1)+loopTagStatus.index}</td>
                        <td>${item.EMP_NO}</td>
                        <td>${item.EMP_NAME}</td>
                        <td>${item.JIKUP}</td>
                        <td>${item.HIRE_DATE}</td>
                        <td>${item.DEP_NAME}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="pageNo">
        <c:if test="${requestScope.searchEmployeeCnt>0}">
          <c:if test="${requestScope.selectPageNo>1}">
            <span style='cursor:pointer' onClick='search_with_changePageNo(1)' >처음</span>
            <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.selectPageNo}-1)' >이전</span>
            &nbsp;&nbsp;
          </c:if>
          <c:if test="${requestScope.selectPageNo<=1}">
            <span>처음</span>
            <span>이전</span> 
            &nbsp;&nbsp;
          </c:if>
          <c:forEach var="i" begin="${requestScope.min_pageNo}" end="${requestScope.max_pageNo}">
            <c:if test="${requestScope.selectPageNo == i}">
              <span>${i}</span>&nbsp;
            </c:if>
            <c:if test="${requestScope.selectPageNo != i}">
              <span style='cursor:pointer' onClick='search_with_changePageNo(${i})' >[${i}]</span>&nbsp;
            </c:if>
          </c:forEach>
          <c:if test="${requestScope.selectPageNo<requestScope.last_pageNo}">
            &nbsp;&nbsp;
            <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.selectPageNo}+1)' >다음</span>
            <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.last_pageNo})' >마지막</span>
          </c:if>
          <c:if test="${requestScope.selectPageNo>=requestScope.last_pageNo}">
            &nbsp;&nbsp;
            <span>다음</span>
            <span>마지막</span>
          </c:if>
        </c:if>
    </div>
    </center>
  </body>
</html>
