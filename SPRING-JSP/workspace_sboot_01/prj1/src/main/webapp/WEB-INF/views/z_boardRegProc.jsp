<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
    <span class="insertBoardCnt"><%out.print( request.getAttribute("insertBoardCnt") );%></span>
    <span class="msg"><%out.print( (String)request.getAttribute("msg") );%></span>
  </body>
</html>
