<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@page import="java.util.List"%><%@page import="java.util.Map"%>
<%@include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Board List!!</title>
    <script>
      function goBoardRegForm() {
        location.replace("/boardRegForm.do");
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
          url: "/boardList.do",
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
              $(".reg_date").append("▲")
            } else if(sort=="reg_date desc"){
              $(".reg_date").append("▼")
            }
            paintBoard();
          },
          error: function(){
            alert("서버접속실패!!!");
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
          if(text.indexOf("▲")>=0){
            $(".sort").val("");
          } else if(text.indexOf("▼")>=0){
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
          [키워드] : <input type="text" name="keyword1" class=keyword1 />
          <select name="orAnd">
            <option value="or" >or</option>
            <option value="and" >and</option>
          </select>
          <input type="text" name="keyword2" class=keyword2 />
          <input type="checkbox" name="day" class="day" value="오늘"/>오늘
          <input type="checkbox" name="day" class="day" value="어제"/>어제
          <input type="checkbox" name="day" class="day" value="그제"/>그제
          <input type="checkbox" name="day" class="day" value="일주일내"/>일주일내
          <input type="hidden" name="selectPageNo" class="selectPageNo" value=1 />
          <input type="hidden" name="sort" class="sort" value="" />
          <select name="rowCntPerPage" class="rowCntPerPage" onChange="search();" >
            <option value=10>10</option>
            <option value=15>15</option>
            <option value=20>20</option>
            <option value=25>25</option>
            <option value=30>30</option>
          </select> 행보기
          <input type="button" value="검색" onClick="search()" class="contactSearch" onKeydown="enter()">&nbsp;
          <input type="button" value="모두검색" onClick="searchAll()" class="contactSearch" >&nbsp;
          <a href="javascript:goBoardRegForm();">[새글쓰기]</a>
      </form>
      <div class="searchResult">
      <div class="totRowCnt">
      <c:if test="${requestScope.pagingNos.totRowCnt>0}">
        검색 총 개수 => ${requestScope.pagingNos.totRowCnt}/${requestScope.totCnt}개
      </c:if>
      <c:if test="${requestScope.pagingNos.totRowCnt<= 0}">
        검색결과가 없습니다.
      </c:if>
      </div>
      <table border="1" class="tbcss0 table" cellpadding="5">
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>조회수</th>
          <th><span class="reg_date">등록일</span></th>
        </tr>
        <c:if test="${requestScope.boardList != null && requestScope.boardList.size()>0}">
          <c:forEach var="list" items="${requestScope.boardList}" varStatus="loopTagStatus">
              <tr onClick='goBoardContentForm(${list.B_NO})' >
                  <td>
                  <%-- 역순번호 --%>
                  ${requestScope.pagingNos.totRowCnt-(requestScope.pagingNos.selectPageNo*requestScope.pagingNos.rowCntPerPage-requestScope.pagingNos.rowCntPerPage+1)+1-loopTagStatus.index}
                  <%-- 정순번호 --%>
                  <%-- ${(requestScope.selectPageNo*requestScope.rowCntPerPage-requestScope.rowCntPerPage+1)+loopTagStatus.index} --%>
                  </td>
                  <td>
                  <c:if test="${list.PRINT_LEVEL>0}">
                    <c:forEach begin="1" end="${list.PRINT_LEVEL}">
                      &nbsp;&nbsp;&nbsp;
                    </c:forEach>
                    ㄴ
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
        <span style='cursor:pointer' onClick='search_with_changePageNo(1)' >처음</span>
        <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.pagingNos.selectPageNo}-1)' >이전</span>
        &nbsp;&nbsp;
      </c:if>
      <c:if test="${requestScope.pagingNos.selectPageNo<=1}">
        <span>처음</span>
        <span>이전</span> 
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
        <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.pagingNos.selectPageNo}+1)' >다음</span>
        <span style='cursor:pointer' onClick='search_with_changePageNo(${requestScope.pagingNos.last_pageNo})' >마지막</span>
      </c:if>
      <c:if test="${requestScope.pagingNos.selectPageNo>=requestScope.pagingNos.last_pageNo}">
        &nbsp;&nbsp;
        <span>다음</span>
        <span>마지막</span>
      </c:if>
    </c:if>
    </div>
    <form action="/boardContentForm.do" name="boardContentForm" maethod="post">
      <input type="hidden" name="b_no">
    </form>
    </center>
  </body>
</html>

<!--
mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
공식 => [총개수], [페이지 당 보여줄 행의 개수],[선택된페이지번호]
        [한 화면에 보여지는 페이지 번호 개수]로

        [현재 화면에 보여지는 페이지 번호의 최소 번호]과 
        [현재 화면에 보여지는 페이지 번호의 최대 번호]를 구하는 공식
		단 변수는 아래와 같다.
------------------------------------------------------------------
			totCnt            => 검색된 총 결과물 개수
			rowCntPerPage => 페이지 당 보여줄 행의 개수
			selectPageNo      => 선택한 페이지 번호
			pageNoCntPerPage  => 페이지 당 보여줄 페이지 번호의 개수
      last_pageNo =>  마지막 페이지 번호.
			min_pageNo  => 현재 화면에 보여지는 페이지 번호의 최소 페이지 번호
			max_pageNo  => 현재 화면에 보여지는 페이지 번호의 최대 페이지 번호
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