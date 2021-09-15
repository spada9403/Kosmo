<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Board List!!</title>
    <script>
      function checkBoardRegForm() {
        if (confirm("정말 등록 하시겠습니까??") == false) {return;}
          $.ajax({
            url: "/boardRegProc.do",
            type: "post",
            //JQUERY의 ajax 메소드 data 얘로는 파일이 업로드 되지 않는다.
            //data: $("[name=boardRegForm]").serialize(),








            // 파일 업로드를 위한 설정
            //----------------------------------------------------
            processData:false,
            //-----------------------------------
            // 서버로 보내는 데이터에 파일이 있으므로
            // 전송하는 파라미터명, 파라미터값을 serialize를 하여 Query String으로 변경하지 않케 설정하기.
            // 서버로 보내는 데이터에 파일이 없으면  processData: false 을 생략한다.
            //-----------------------------------
            contentType:false,
            //-----------------------------------
            // 서버로 보내는 데이터에 파일이 있으므로
            // 현재 form 태그에 설정된 enctype 속성값을 Content-Type 으로 사용하도록 설정하기.
            // 이게 없으면 현재 form 태그에 설정된 enctype 속성값과 관계없이 무조건 enctype 이 application/x-www-form-urlencoded 로 설정된다.
            // 서버로 보내는 데이터에 파일이 없으면  ,contentType: false  을 생략한다.
            //-----------------------------------
            data: new FormData( $("[name=boardRegForm]").get(0) ),
            // 서버로 보내는 데이터 설정하기.
            // 서버로 보내는 데이터에 파일이 있으므로 FormData 객체 설정.
            //----------------------------------------------------











            success: function (map) {
              var msg = map.msg;
              var insertBoardCnt = map.insertBoardCnt;
              if(msg != null && msg.length > 0){
                alert(msg);
                return;
              }
              if (insertBoardCnt == "1") {
                <c:if test="${empty param.b_no}">
                  alert("새글쓰기 성공!");
                </c:if>
                <c:if test="${!empty param.b_no}">
                  alert("댓글쓰기 성공!");
                </c:if>
              } else {
                <c:if test="${empty param.b_no}">
                  alert("새글쓰기 실패!");
                </c:if>
                <c:if test="${!empty param.b_no}">
                  alert("댓글쓰기 실패!");
                </c:if>
              }
            },
            error: function () {
              alert("서버 접속 실패!");
            },
          });
      }
      $(document).ready(function () {
        $("th").css({
          "background-color":"${bgColor}"
        })
      })
    </script>
  </head>
  <body>
    <center>
      <form action="/boardRegProc.do" name="boardRegForm" method="post" enctype="multipart/form-data" >
        <table border="1" style="border-collapse: collapse" cellpadding="5">
          <c:if test="${empty param.b_no}">
            <caption>
              새글쓰기
            </caption>
          </c:if>
          <c:if test="${!empty param.b_no}">
            <caption>
              댓글쓰기
            </caption>
          </c:if>
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
            <td>
              <input type="file" name="img" class="img" />
            </td>
          </tr>
          <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pwd" size="8" class="pwd" maxlength="10" maxlength="4" /></td>
          </tr>
        </table>
        <div style="margin-top: 15px" class="inputBox">
          <input type="button" value="저장" onclick="checkBoardRegForm()" />
          <input type="reset" value="다시작성" />
          <input type="button" value="목록보기" onclick="location.replace('boardList.do');" />
          <c:if test="${empty param.b_no}">
            <input type="hidden" name="b_no" value="0" />
          </c:if>
          <c:if test="${!empty param.b_no}">
            <input type="hidden" name="b_no" value="${param.b_no}" />
          </c:if>
        </div>
      </form>
    </center>
  </body>
</html>
