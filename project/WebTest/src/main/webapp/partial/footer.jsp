<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.*"%>
<fmt:formatDate value="<%=new Date()%>" var = "now" pattern="yyyy-MM-dd E"></fmt:formatDate>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
	---------- <br>
	  footer  <br>
	---------- <br>
   <c:out value="${now}" />요일<br><br><br><br><br>
</body>
</html>