<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@page import="java.util.List"%><%@page import="java.util.Map"%>
<%@include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Board List!!</title>
    <script>
      function goBoardRegForm() {
        location.replace("${naverPath}/boardRegForm.do");
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
      function goBoardContentForm( id ){
        $("[name=boardContentForm] [name=b_no]").val(id);
        document.boardContentForm.submit();
      }
      function search(){
        var keyword1 = $.trim($(".keyword1").val());
        var keyword2 = $.trim($(".keyword2").val());
        
        if((keyword1 == null && keyword2 == null) || keyword1.split(" ").join("") == "" && keyword2.split(" ").join("") == "" ){
          keyword1 = "";
          keyword2 = "";
        }
        $(".keyword1").val(keyword1);
        $(".keyword2").val(keyword2);
        searchExe();
      }
      function searchAll() {
        $(".keyword1").val("");
        $(".keyword2").val("");
        $(".day").filter(":checked").prop("checked",false);
        searchExe();
      }
      function searchExe() {
        $.ajax({
          url: "${requestScope.naverPath}/boardList.do",
          type: "post",
          data: $("[name=boardListForm]").serialize(),
          success: function(responseHtml){
            var html = $(responseHtml).find(".searchResult").html();
            $(".searchResult").html(html);
            $(".pageNo").html(
              $(responseHtml).find(".pageNo").html()
            )
            reg_date_sort();
            var sort = $(".sort").val();
            if(sort=="reg_date asc"){
              $(".reg_date").append("???")
            } else if(sort=="reg_date desc"){
              $(".reg_date").append("???")
            }
            paintBoard();
          },
          error: function(){
            alert("??????????????????!!!");
          }
        })
      }
      function search_with_changePageNo(pageNo){
        $(".selectPageNo").val(pageNo);
        search();
      }
      $(document).ready(function () {
        $(document).keypress(function(e){
          if(e.keyCode == 13){
           e.preventDefault()
           search();
          }
        })
        reg_date_sort()
        paintBoard();
      });
      function reg_date_sort() {
        $(".selectPageNo").val(1);
        $(".reg_date").css("cursor","pointer");
        $(".reg_date").click( function () {
          var obj = $(this);
          var text = $.trim(obj.text());
          if(text.indexOf("???")>=0){
            $(".sort").val("");
          } else if(text.indexOf("???")>=0){
            $(".sort").val("reg_date asc");
          } else {
            $(".sort").val("reg_date desc");
          }
          search();
        })
      }
      function paintBoard(){
        var trObj = $(".table").find("tr");
        trObj.first().css({
          "background-color":"lightgray"
        })
        trObj.not(":first-child").css({
          "cursor":"pointer"
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
    </script>
  </head>
  <body>
    <center>
      <form name="boardListForm" method="post">
          [?????????] : <input type="text" name="keyword1" class=keyword1 />
          <select name="orAnd">
            <option value="or" >or</option>
            <option value="and" >and</option>
          </select>
          <input type="text" name="keyword2" class=keyword2 />
          <input type="checkbox" name="day" class="day" value="??????"/>??????
          <input type="checkbox" name="day" class="day" value="??????"/>??????
          <input type="checkbox" name="day" class="day" value="??????"/>??????
          <input type="checkbox" name="day" class="day" value="????????????"/>????????????
          <input type="hidden" name="selectPageNo" class="selectPageNo" value=1 />
          <input type="hidden" name="sort" class="sort" value="" />
          <select name="rowCntPerPage" class="rowCntPerPage" onChange="search();" >
            <option value=10>10</option>
            <option value=15>15</option>
            <option value=20>20</option>
            <option value=25>25</option>
            <option value=30>30</option>
          </select> ?????????
          <input type="button" value="??????" onClick="search()" class="contactSearch" onKeydown="enter()">&nbsp;
          <input type="button" value="????????????" onClick="searchAll()" class="contactSearch" >&nbsp;
          <a href="javascript:goBoardRegForm();">[????????????]</a>
      </form>
      <div class="searchResult">
      <div class="totRowCnt">
      <c:if test="${requestScope.pagingNos.totRowCnt>0}">
        ?????? ??? ?????? => ${requestScope.pagingNos.totRowCnt}/${requestScope.totCnt}???
      </c:if>
      <c:if test="${requestScope.pagingNos.totRowCnt<= 0}">
        ??????????????? ????????????.
      </c:if>
      </div>
      <table border="1" class="tbcss0 table" cellpadding="5">
        <tr>
          <th>??????</th>
          <th>??????</th>
          <th>?????????</th>
          <th>?????????</th>
          <th><span class="reg_date">?????????</span></th>
        </tr>
        <c:if test="${requestScope.boardList != null && requestScope.boardList.size()>0}">
          <c:forEach var="list" items="${requestScope.boardList}" varStatus="loopTagStatus">
              <tr onClick='goBoardContentForm(${list.B_NO})' >
                  <td>
                  <%-- ???????????? --%>
                  ${requestScope.pagingNos.totRowCnt-(requestScope.pagingNos.selectPageNo*requestScope.pagingNos.rowCntPerPage-requestScope.pagingNos.rowCntPerPage+1)+1-loopTagStatus.index}
                  <%-- ???????????? --%>
                  <%-- ${(requestScope.selectPageNo*requestScope.rowCntPerPage-requestScope.rowCntPerPage+1)+loopTagStatus.index} --%>
                  </td>
                  <td>
                  <c:if test="${list.PRINT_LEVEL>0}">
                    <c:forEach begin="1" end="${list.PRINT_LEVEL}">
                      &nbsp;&nbsp;&nbsp;
                    </c:forEach>
                    ???
                  </c:if>
                  ${list.SUBJECT}</td>
                  <td>${list.WRITER}</td>
                  <td>${list.READCOUNT}</td>
                  <td>${list.REG_DATE}</td>
              </tr>
          </c:forEach>
        </c:if>
    </table>
      </div>
    <div class="pageNo">
    <c:if test="${requestScope.pagingNos.totRowCnt>0}">
      <c:if test="${requestScope.pagingNos.selectPageNo>1}">
        <span style='cursor:pointer' onClick='search_with_changePageNo(1)' >??????</span>
        <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.pagingNos.selectPageNo}-1)' >??????</span>
        &nbsp;&nbsp;
      </c:if>
      <c:if test="${requestScope.pagingNos.selectPageNo<=1}">
        <span>??????</span>
        <span>??????</span> 
        &nbsp;&nbsp;
      </c:if>
      <c:forEach var="i" begin="${requestScope.pagingNos.min_pageNo}" end="${requestScope.pagingNos.max_pageNo}">
        <c:if test="${requestScope.pagingNos.selectPageNo == i}">
          <span>${i}</span>&nbsp;
        </c:if>
        <c:if test="${requestScope.pagingNos.selectPageNo != i}">
          <span style='cursor:pointer' onClick='search_with_changePageNo(${i})' >[${i}]</span>&nbsp;
        </c:if>
      </c:forEach>
      <c:if test="${requestScope.pagingNos.selectPageNo<requestScope.pagingNos.last_pageNo}">
        &nbsp;&nbsp;
        <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.pagingNos.selectPageNo}+1)' >??????</span>
        <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.pagingNos.last_pageNo})' >?????????</span>
      </c:if>
      <c:if test="${requestScope.pagingNos.selectPageNo>=requestScope.pagingNos.last_pageNo}">
        &nbsp;&nbsp;
        <span>??????</span>
        <span>?????????</span>
      </c:if>
    </c:if>
    </div>
    <form action="${requestScope.naverPath}/boardContentForm.do" name="boardContentForm" maethod="post">
      <input type="hidden" name="b_no">
    </form>
    </center>
  </body>
</html>

<!--
mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
?????? => [?????????], [????????? ??? ????????? ?????? ??????],[????????????????????????]
        [??? ????????? ???????????? ????????? ?????? ??????]???

        [?????? ????????? ???????????? ????????? ????????? ?????? ??????]??? 
        [?????? ????????? ???????????? ????????? ????????? ?????? ??????]??? ????????? ??????
		??? ????????? ????????? ??????.
------------------------------------------------------------------
			totCnt            => ????????? ??? ????????? ??????
			rowCntPerPage => ????????? ??? ????????? ?????? ??????
			selectPageNo      => ????????? ????????? ??????
			pageNoCntPerPage  => ????????? ??? ????????? ????????? ????????? ??????
      last_pageNo =>  ????????? ????????? ??????.
			min_pageNo  => ?????? ????????? ???????????? ????????? ????????? ?????? ????????? ??????
			max_pageNo  => ?????? ????????? ???????????? ????????? ????????? ?????? ????????? ??????
mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

int last_pageNo = totCnt/rowCntPerPage;
  if( totCnt%rowCntPerPage>0 ) {last_pageNo++;}

int min_pageNo = (selectPageNo-1)/pageNoCntPerPage * pageNoCntPerPage +1;
int max_pageNo = min_pageNo+pageNoCntPerPage-1;
  if( max_pageNo>last_pageNo ){max_pageNo = last_pageNo;}
mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
if( totCnt>0){
	int endRowNo = selectPageNo * rowCntPerPage;
	int beginRowNo = endRowNo - rowCntPerPage + 1;
	if( endRowNo>totCnt ){
		endRowNo = totCnt;
	}
}

-->