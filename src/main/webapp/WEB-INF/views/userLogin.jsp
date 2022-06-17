<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
	<title>Login</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<c:if test="${empty authInfo }">
<P><spring:message code="loginmesg" /></P>
<form:form action="loginResult" modelAttribute="loginInfo">
<p> <label> <spring:message code="id" />:<br>
<form:input path="id" />
<form:errors path="id" /> </label> 
<br> <spring:message code="rememberid" />
<form:checkbox path="rememberid"/></p> 
<p> <label> <spring:message code="pwd" />:<br>
<form:password path="pwd" />
<form:errors path="pwd" /> </label> </p>
<button class="btn" type="submit"> <spring:message code="submit" /></button>
</form:form>
</c:if>
<c:if test="${! empty authInfo}">
<P>${authInfo.id }님 환영합니다.</P>
<a href="./userInfo/${authInfo.id}" >회원 정보 조회</a><br>
<a href="./modifyUserInfo">회원 정보 수정</a><br>
<a href="./lookup">상품 조회</a><br>
<a href="./orderSearch">구매 이력 조회</a><br>
<a href="./logout">로그아웃</a> <br>
<a href="./userDelete/${authInfo.id}">탈퇴</a> 
</c:if>
</body>
</html>
