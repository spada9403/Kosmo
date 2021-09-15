<!--JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기.-->
<!--현재 이 페이지 실행후 생성되는 문서는 html 이고, 이 문서 안의 데이터는 UTF-8 방식으로 인코딩 한다 라고 설정.-->
<!--현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다.-->
<!--UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 무자열을 부호화 할 수 있는 방법이다.-->
<!--모든 JSP 페이지 상단에 무조건 아래 설정이 들어간다.-->
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>LoginForm</title>
    <script src="/resources/jquery-3.6.0.min.js"></script>
    <script>
      function checkLoginForm() {
        var uid = $.trim($(".login_id").val());
        var pwd = $.trim($(".pwd").val());
        if (isEmpty(uid)) {
          alert("아이디를 입력해주세요");
          return;
        }
        if (isEmpty(pwd)) {
          alert("암호를 입력해주세요.");
          return;
        }
        $.ajax({
          url: "/loginProc.do",
          type: "post",
          data: $("[name=loginForm]").serialize(),
          success: function (login_idCnt) {
            if (login_idCnt == 1) {
              alert("로그인성공");
              location.replace("/boardList.do");
            } else {
              alert("로그인실패");
            }
          },
          error: function () {
            alert("서버 접속 실패");
          },
        });
      }

      function isEmpty(str) {
        var flag = false;
        if (str.split(" ").join("") == "") {
          flag = true;
        }
        return flag;
      }

      $(document).ready(function () {
        var form = $("[name=loginForm]");
        var loginButton = form.find(".login");
        loginButton.click(function () {
          checkLoginForm();
        });
      });
    </script>
  </head>
  <body>
    <center>
      <form name="loginForm" method="post">
        <table cellpadding="5" border="1" style="border-collapse: collapse">
          <caption>
            <b>[로그인]</b>
          </caption>
          <tr>
            <th bgcolor="lightgray" align="center">아이디</th>
            <td><input type="text" name="login_id" class="login_id" size="20" /></td>
          </tr>
          <tr>
            <th bgcolor="lightgray" align="center">암호</th>
            <td><input type="password" name="pwd" class="pwd" size="20" /></td>
          </tr>
        </table>
        <table>
          <tr align="center">
            <td><input type="button" value="로그인" class="login" /></td>
          </tr>
          <tr>
            <td><span style="cursor: pointer" onClick="location.replace('/memRegForm.do')">[회원가입]</span></td>
          </tr>
        </table>
      </form>
    </center>
  </body>
</html>
