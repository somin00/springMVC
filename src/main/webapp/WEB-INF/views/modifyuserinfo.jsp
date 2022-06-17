<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<!DOCTYPE html>
<html>
<head>

<title>ModifyuserInfo</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<c:if test="${! empty authInfo }">
<P><spring:message code="modifyuserinfo" /></P>
<form:form action="submituserinfo" modelAttribute="userInfo">
<p> <label> <spring:message code="email" />:<br>
<form:input path="email" />
<form:errors path="email" /> </label> </p>
<p> <label> <spring:message code="addr" />:<br>
<form:input path="addr" />
<form:errors path="addr" /> </label> </p>
<p> <label> <spring:message code="phone" />:<br>
<form:input path="phone" />
<form:errors path="phone" /> </label> </p>
<button class="btn" type="submit"> <spring:message code="submit" /></button>
</form:form>
</c:if>
</body>
</html>