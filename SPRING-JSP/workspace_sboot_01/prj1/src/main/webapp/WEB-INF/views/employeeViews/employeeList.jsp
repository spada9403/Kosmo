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
        <caption>[?????? ??????]</caption>
        <form method="post" name="dataForm" >   
            <table border="1" style="border-collapse: collapse;" cellpadding="5" class="table">
                <tr>
                    <th>?????? ?????????</th>
                    <td><input type="text" name="keyword1" class="keyword1"></td>
                </tr>
                <tr>
                    <th>??????</td>
                    <td align="center">
                        <input type="checkbox" name="jikup" value="??????">??????
                        <input type="checkbox" name="jikup" value="??????">??????
                        <input type="checkbox" name="jikup" value="??????">??????
                        <input type="checkbox" name="jikup" value="??????">??????
                        <input type="checkbox" name="jikup" value="??????">??????
                        <input type="checkbox" name="jikup" value="??????">??????
                    </td>
                </tr>
                <tr>
                    <th>?????????</td>
                    <td>
                        <select name="hire_date_year1" >
                        <option value=0></option>
                            <option value=1960>1960</option>
                            <option value=1970>1970</option>
                            <option value=1980>1980</option>
                            <option value=1990>1990</option>
                            <option value=2000>2000</option>
                        </select>???
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
                        </select>???
                        ~
                        <select name="hire_date_year2" >
                        <option value=0></option>
                            <option value=1960>1960</option>
                            <option value=1970>1970</option>
                            <option value=1980>1980</option>
                            <option value=1990>1990</option>
                            <option value=2000>2000</option>
                        </select>???
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
                        </select>???
                    </td>
                </tr>
            </table>
          <select name="rowCntPerPage" class="rowCntPerPage" onChange="search();" >
            <option value=10>10</option>
            <option value=15>15</option>
            <option value=20>20</option>
            <option value=25>25</option>
            <option value=30>30</option>
          </select> ?????????
          <input type="hidden" name="selectPageNo" class="selectPageNo" value=1 />
        </form>
        <div class="searchButton">
            <input type="button" value="??????" class="search">
            <input type="button" value="????????????" class="allSearch">
        </div>
        <div class="employeeList">
            <table border="1" style="border-collapse:collapse" cellpadding="5">
                <tr>
                    <th>??????</th>
                    <th>????????????</th>
                    <th>?????????</th>
                    <th>??????</th>
                    <th>?????????</th>
                    <th>???????????????</th>
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
            <span style='cursor:pointer' onClick='search_with_changePageNo(1)' >??????</span>
            <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.selectPageNo}-1)' >??????</span>
            &nbsp;&nbsp;
          </c:if>
          <c:if test="${requestScope.selectPageNo<=1}">
            <span>??????</span>
            <span>??????</span> 
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
            <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.selectPageNo}+1)' >??????</span>
            <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.last_pageNo})' >?????????</span>
          </c:if>
          <c:if test="${requestScope.selectPageNo>=requestScope.last_pageNo}">
            &nbsp;&nbsp;
            <span>??????</span>
            <span>?????????</span>
          </c:if>
        </c:if>
    </div>
    </center>
  </body>
</html>
