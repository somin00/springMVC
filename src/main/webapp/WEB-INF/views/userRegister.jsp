<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
	<title>Register</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>

<P><spring:message code="registermesg" /></P>
<form:form action="registerResult" modelAttribute="registerInfo">
<p> <label> <spring:message code="id" />:<br>
<form:input path="id" />
<form:errors path="id" /> </label> </p>

<p> <label> <spring:message code="name" />:<br>
<form:input path="name" />
<form:errors path="name" /> </label> </p>

<p> <label> <spring:message code="email" />:<br>
<form:input path="email" />
<form:errors path="email" /> </label> </p>

<p> <label> <spring:message code="pwd" />:<br>
<form:password path="pwd" />
<form:errors path="pwd" /> </label> </p>

<p> <label> <spring:message code="addr" />:<br>
<form:input path="addr" />
<form:errors path="addr" /> </label> </p>

<p> <label> <spring:message code="phone" />:<br>
<form:input path="phone" />
<form:errors path="phone" /> </label> </p>
<button class="btn" type="submit"> <spring:message code="submit" /></button>
</form:form>
</body>
</html>
