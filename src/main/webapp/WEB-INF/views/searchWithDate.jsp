<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<meta charset="UTF-8">
<!DOCTYPE html>
<html>
<head>
<title>Search With Date</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<p>기간별 구매 이력 조회 </p>
<form:form action="dateSearchResult/${authInfo.id}" modelAttribute="orderInfo">
<p><label><spring:message code="date" />:
<form:input path="orderDate"/>
<form:errors path="orderDate" />
 </label></p>
<button class="btn" type="submit"><spring:message code="submit" /></button>
</form:form>
</body>
</html>