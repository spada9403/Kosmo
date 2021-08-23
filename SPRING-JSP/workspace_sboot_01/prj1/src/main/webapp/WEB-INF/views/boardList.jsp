<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Board List!!</title>
    <script src="/resources/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script>
      function goBoardRegForm() {
        location.replace("/boardRegForm.do");
      }
    </script>
  </head>
  <body>
    <center>
      <a href="javascript:goBoardRegForm();">[새글쓰기]</a>
    </center>
  </body>
</html>
