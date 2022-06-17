<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<!DOCTYPE html>
<html>
<head>
<title>Search Product</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<p>상품 검색</p>
<form:form action="searchResult" modelAttribute="productInfo">
<p><label><spring:message code="productName" />:
<form:input path="productname"/>
<form:errors path="productname" />
 </label></p>
<button class="btn" type="submit"><spring:message code="submit" /></button>
</form:form>
</body>
</html>