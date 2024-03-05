<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login !</title>
</head>
<body>
	<c:if test="${logoutMsg != null }">
		<p><c:out value="${logoutMsg }"/></p>
	</c:if>
		
	<h1>Login</h1>
	
	<c:if test="${errorMsg != null }">
		<p><c:out value="${errorMsg }"/></p>
	</c:if>

	
		
	<form action="/login" method="post">

		

		<p>
			<label for="username">Username</label> <input type="text"
				name="username" />
		</p>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<p>
			<label for="password">Password</label> <input type="password"
				name="password" />
		</p>
		<button>Login !</button>
	</form>
</body>
</html>