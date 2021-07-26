<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL if</title>
</head>
<body>

<c:import url="./partial/header.jsp"></c:import>

<!-- JSTP if 조건 -->
<c:if test="true">
	true이므로 실행한다.
</c:if>
<hr>

<!-- query string 방식 -->
<c:set var="name" value="${param.nick}"></c:set>
<c:set var="age" value="${param.age}"></c:set>
<a href="index.jsp?age=10&nick=펭수">step1을 다시 호출</a><br><br>
나이: ${age} <br>
닉네임: ${name}
<br><br>

<c:if test="${param.age > 5 && param.nick == '펭수'}">
	나이가 5세를 초과합니다. 닉네임은 펭수입니다.<br>
</c:if>

<c:import url="./partial/footer.jsp"></c:import>
</body>
</html>