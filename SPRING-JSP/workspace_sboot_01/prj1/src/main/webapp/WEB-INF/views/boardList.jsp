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
        var text = $.trim($(".keyword1").val());
        if(text == null || text.split(" ").join("") == ""){
          text = "";
        }
        $(".keyword1").val(text);
        searchExe();
      }
      function searchAll() {
        $(".keyword1").val("");
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
        paintBoard();
      });
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
  <%
    List<Map<String,String>> boardList = (List<Map<String,String>>)request.getAttribute("boardList");
    int searchBoardCnt = (int)request.getAttribute("searchBoardCnt");
    int last_pageNo = (int)request.getAttribute("last_pageNo");
    int min_pageNo = (int)request.getAttribute("min_pageNo");
    int max_pageNo = (int)request.getAttribute("max_pageNo");
    int selectPageNo = (int)request.getAttribute("selectPageNo");
    int rowCntPerPage = (int)request.getAttribute("rowCntPerPage");
  %>
    <center>
      <form name="boardListForm" method="post">
          [키워드] : <input type="text" name="keyword1" class=keyword1 />
          <input type="checkbox" name="day" class="day" value="오늘"/>오늘
          <input type="checkbox" name="day" class="day" value="어제"/>어제
          <input type="checkbox" name="day" class="day" value="그제"/>그제
          <input type="checkbox" name="day" class="day" value="일주일내"/>일주일내
          <input type="hidden" name="selectPageNo" class="selectPageNo" value=1 />
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
      <div class="searchBoardCnt">
      <%
        if(searchBoardCnt > 0){
          out.print("<span>검색결과 : "+searchBoardCnt+"개</span>");
        } else {
          out.print("<span>검색결과 없음</span>");
        }
      %>
      </div>
      
      <table border="1" style="border-collapse: collapse;" cellpadding="5" class="table">
        <tr>
          <th>번호</th>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>조회수</th>
          <th>등록일</th>
        </tr>
      <%
          if(boardList != null && boardList.size()>0){
          //정순번호
          int serialNo_asc = ((selectPageNo * rowCntPerPage) - rowCntPerPage) + 1;
          //역순번호
          //int serialNo_desc = searchBoardCnt-(((selectPageNo * rowCntPerPage) - rowCntPerPage) + 1)+1;
            for(int i = 0; i < boardList.size(); i++){
              Map<String,String> map = boardList.get(i);
              String RNUM = map.get("RNUM");
              String b_no = map.get("B_NO");
              String subject = map.get("SUBJECT");
              String writer = map.get("WRITER");
              String readcount = map.get("READCOUNT");
              String reg_date = map.get("REG_DATE");
              String print_level = map.get("PRINT_LEVEL");
              int print_level_int = Integer.parseInt(print_level,10);
              String blank = "";
              for(int j=0; j<print_level_int; j++){
                blank = blank+"&nbsp;&nbsp;&nbsp;&nbsp;";
              }
              if( print_level_int > 0){
                blank = blank + "ㄴ";
              }
              subject = blank + subject;
              out.print("<tr onClick='goBoardContentForm("+b_no+")'><td>"
                        +(RNUM)
                        +"</td> <td>"
                        +(serialNo_asc++)
                        //+(serialNo_desc--)
                        +"</td> <td>"
                        +(subject)
                        +"</td><td>"
                        +writer
                        +"</td><td>"
                        +readcount
                        +"</td><td>"
                        +reg_date
                        +"</td></tr>");
            }
          }
      %>
    </table>
      </div>
    <div class="pageNo">
    <%
      if(searchBoardCnt>0){
        if(selectPageNo > 1){
            out.print("<span style='cursor:pointer' onClick='search_with_changePageNo("+1+")' >처음</span> ");
            out.print("<span style='cursor:pointer' onClick='search_with_changePageNo("+(selectPageNo-1)+")' >이전</span>");
        } else {
            out.print("<span>처음</span> ");
            out.print("<span>이전</span>");
        }
        for(int i = min_pageNo; i <= max_pageNo; i++){
          if(selectPageNo == i){
          out.print( "<span>" + i + "</span> " );
          } else {
          out.print( "<span style='cursor:pointer' onClick='search_with_changePageNo("+i+")' >[" + i + "]</span> " );  
          }
        }
          if(last_pageNo > selectPageNo){
            out.print("<span style='cursor:pointer' onClick='search_with_changePageNo("+(selectPageNo+1)+")' >다음</span> ");
            out.print("<span style='cursor:pointer' onClick='search_with_changePageNo("+(last_pageNo)+")' >마지막</span>");
          } else {
            out.print("<span>다음</span> ");
            out.print("<span>마지막</span>");
        }
      }
    %>
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