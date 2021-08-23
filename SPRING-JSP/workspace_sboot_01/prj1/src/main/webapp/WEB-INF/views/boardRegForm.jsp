<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Board List!!</title>
    <script src="/resources/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script>
      function checkBoardRegForm() {
        if (confirm("정말 등록 하시겠습니까??") == false) {
          return;
        } else {
          $.ajax({
            url: "/boardRegProc.do",
            type: "post",
            data: $("[name=boardRegForm]").serialize(),
            success: function (responseHtml) {
              var insertBoardCnt = $.trim($(responseHtml).filter(".insertBoardCnt").text());
              if (insertBoardCnt == "1") {
                alert("아아.. 성공했어..");
              } else {
                alert(" 실 패 함 ");
              }
            },
            error: function () {
              alert("서버 접속 실패!");
            },
          });
        }
      }
    </script>
  </head>
  <body>
    <center>
      <form action="/boardRegProc.do" name="boardRegForm" method="post">
        <table border="1" style="border-collapse: collapse" cellpadding="5">
          <caption>
            새글쓰기
          </caption>
          <tr>
            <th bgcolor="lightgray">이 름</th>
            <td><input type="text" name="writer" size="10" maxlength="10" /></td>
          </tr>
          <tr>
            <th bgcolor="lightgray">제 목</th>
            <td><input type="text" name="subject" size="40" maxlength="30" /></td>
          </tr>
          <tr>
            <th bgcolor="lightgray">이메일</th>
            <td><input type="text" name="email" size="40" maxlength="30" /></td>
          </tr>
          <tr>
            <th bgcolor="lightgray">내 용</th>
            <td><textarea name="content" cols="40" rows="13" maxlength="300"></textarea></td>
          </tr>
          <tr>
            <th bgcolor="lightgray">비밀번호</th>
            <td><input type="password" name="pwd" size="8" maxlength="10" maxlength="4" /></td>
          </tr>
        </table>
        <div style="margin-top: 15px" class="inputBox">
          <input type="button" value="저장" onclick="checkBoardRegForm()" />
          <input type="reset" value="다시작성" />
          <input type="button" value="목록보기" onclick="document.boardListForm.submit();" />
          <!--<input type="hidden" name="b_no" value="1" />-->
        </div>
      </form>
    </center>
  </body>
</html>
