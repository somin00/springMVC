<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
	<title>Home</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<p>고급자바 기말</p>
<a href="./userRegister">회원가입</a><br>
<a href="./userLogin">로그인</a><br>
<a href="./lookup">상품 조회</a><br>
</body>
</html>
