<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfo</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
	<c:if test="${! empty authInfo }">
	<P> ${authInfo.id } 정보</P>
	<p> <spring:message code="email" />: ${userInfo.email}</p>
	<p> <spring:message code="addr" />: ${userInfo.addr}</p>
	<p> <spring:message code="phone" />: ${userInfo.phone}</p>

	<a href="../"> <spring:message code="back"/></a>
	</c:if>
</body>
</html>