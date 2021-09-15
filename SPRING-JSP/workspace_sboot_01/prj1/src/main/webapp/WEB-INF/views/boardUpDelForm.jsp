<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@page import="com.naver.prj1.BoardDTO"%>
<%@include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Board List!!</title>
    <script>
    function ajaxFunc( data, upDel ){
      if(upDel == "up"){
       if(confirm("정말 수정하시겠습니까?") == false) {reutrn}
      } else {
        if(confirm("정말 삭제하시겠습니까?") == false) {reutrn}
      }
        $.ajax({
          url:"/boardUpDelProc.do",
          type:"post",
          processData:false,
          contentType:false,
          data: new FormData( $("[name=boardUpDelForm]").get(0) ),
          success: function (json) {
            var upBoardCnt = json.upDelBoardCnt;
            var msg = json.msg;
            if(msg != ""){
              alert("에러넘버 : "+upBoardCnt + "    에러메세지 : " + msg);
              if(upBoardCnt == -3) {location.replace("/boardList.do")}
              $("[name=pwd]").val();
            } else {
              if(upDel == "up"){
                alert("수정 성공!")
                if(confirm("목록으로 이동합니까?") == true){
                  location.replace("/boardList.do");
                }
              } else {
                alert("삭제 성공!")
                location.replace("/boardList.do");
              }
            }
          },
          error: function () {
            alert("서버접속실패!!");
          }
        })
    }
      function checkBoardUpDelForm( upDel ) {
         $("[name='upDel']").val(upDel);
          ajaxFunc( $("[name='boardUpDelForm']").serialize(), upDel)

      }
      $(document).ready(function () {
        $(".writer").val("${boardDTO.writer}");
        $(".subject").val("${boardDTO.subject}");
        $(".email").val("${boardDTO.email}");
        $(".content").val("${boardDTO.content}");
        $("th").css({
          "background-color":"${bgColor}"
        })
      })
    </script>
  </head>
  <body>
  <%/*
    BoardDTO board = (BoardDTO)request.getAttribute("boardDTO");
      if( board != null ){
        int b_no = board.getB_no();
        String subject = board.getSubject();
        String content = board.getContent();
        String writer = board.getWriter();
        String reg_date = board.getReg_date();
        int readcount = board.getReadcount();
        String email = board.getEmail();*/
  %>
    <center>
    <c:if test="${!empty boardDTO}">
      <form action="/boardUpDelProc.do" name="boardUpDelForm" method="post" enctype="multipart/form-data" >
        <table border="1" style="border-collapse: collapse" cellpadding="5">
          <caption>
            게시판 수정 / 삭제
          </caption>
          <tr>
            <th>이 름</th>
            <td><input type="text" name="writer" size="10" class="writer" maxlength="10" /></td>
          </tr>
          <tr>
            <th>제 목</th>
            <td><input type="text" name="subject" size="40" class="subject" maxlength="30" /></td>
          </tr>
          <tr>
            <th>이메일</th>
            <td><input type="text" name="email" size="40" class="email" maxlength="30" /></td>
          </tr>
          <tr>
            <th>내 용</th>
            <td><textarea name="content" cols="40" rows="13" class="content" maxlength="300"></textarea></td>
          </tr>
          <tr>
            <th>이미지</th>
            <td colspan="3">
              <input type="file" name="img" class="img" />
              <div style="height:3pt" ></div>
            <c:if test = "${boardDTO.pic != null && boardDTO.pic.length()>0}">
             <img width="30%" src="/resources/img/${boardDTO.pic}">
             <input type="checkbox" name="killImage" value=true /> 삭제
            </c:if>
            </td>
          </tr>
          <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pwd" size="8" class="pwd" maxlength="4" /></td>
          </tr>
        </table>
        <div style="margin-top: 15px" class="inputBox">
          <input type="button" value="수정" onClick="checkBoardUpDelForm('up')" />
          <input type="button" value="삭제" onClick="checkBoardUpDelForm('del')" />
          <input type="button" value="목록보기" onClick="location.replace('/boardList.do');" />
          <input type="hidden" name="b_no" value="${boardDTO.b_no}" />
          <input type="hidden" name="upDel"/>
        </div>
      </form>
    </c:if>
    <c:if test="${empty boardDTO}">
    <script>alert('삭제된 글입니다.'); location.replace('/boardList.do')</script>
    </c:if>
    </center>
  </body>
</html>
