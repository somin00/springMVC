<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
</head>
<body>
<p>상품 검색 결과</p>
<p>${searchProduct}</p> 
<a href="./productInfo">상품 설명 보기</a><br>
<c:if test="${! empty authInfo}">
<a href="./orderComplete/${authInfo.id}">구매</a><br>
</c:if>
<a href="./">home</a>
</body>
</html>