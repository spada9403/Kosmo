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
      <div class="searchBoardCnt">
      <%
        if(searchBoardCnt > 0){
          %><span>???????????? : ${requestScope.searchBoardCnt}???</span><%
        } else {
          out.print("<span>???????????? ??????</span>");
        }
      %>
      </div>
      
      <table border="1" style="border-collapse: collapse;" cellpadding="5" class="table">
        <tr>
          <th>??????</th>
          <th>??????</th>
          <th>??????</th>
          <th>?????????</th>
          <th>?????????</th>
          <th>?????????</th>
        </tr>
      <%
          if(boardList != null && boardList.size()>0){
          //????????????
          int serialNo_asc = ((selectPageNo * rowCntPerPage) - rowCntPerPage) + 1;
          //????????????
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
                blank = blank + "???";
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
            out.print("<span style='cursor:pointer' onClick='search_with_changePageNo("+1+")' >??????</span> ");
            out.print("<span style='cursor:pointer' onClick='search_with_changePageNo("+(selectPageNo-1)+")' >??????</span>");
        } else {
            out.print("<span>??????</span> ");
            out.print("<span>??????</span>");
        }
        for(int i = min_pageNo; i <= max_pageNo; i++){
          if(selectPageNo == i){
          out.print( "<span>" + i + "</span> " );
          } else {
          out.print( "<span style='cursor:pointer' onClick='search_with_changePageNo("+i+")' >[" + i + "]</span> " );  
          }
        }
          if(last_pageNo > selectPageNo){
            out.print("<span style='cursor:pointer' onClick='search_with_changePageNo("+(selectPageNo+1)+")' >??????</span> ");
            out.print("<span style='cursor:pointer' onClick='search_with_changePageNo("+(last_pageNo)+")' >?????????</span>");
          } else {
            out.print("<span>??????</span> ");
            out.print("<span>?????????</span>");
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