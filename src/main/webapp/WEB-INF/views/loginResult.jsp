<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
	<title>loginResult</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<p>로그인에 성공했습니다.</p>
<a href="./userLogin">마이페이지</a><br>
<a href="./"><spring:message code="back"/></a>
</body>
</html>
