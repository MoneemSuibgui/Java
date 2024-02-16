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
<meta charset="UTF-8">
<title>Admin dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="userContainer">
	<h1>
		Welcome admin :
		<c:out value="${admin.firstName}"></c:out>
	</h1>

	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> 
			<input type="submit" value="Logout!"  class="logoutBtn"/>
	</form>
	</div>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Actions</th>
		</tr>

		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.firstName }"></c:out> <c:out
						value="${user.firstName }"></c:out></td>
				<td><c:out value="${user.email }"></c:out></td>
				<td><c:if
						test="${user.getRoles().get(0).name.contains('ROLE_USER')}">
						<a href="/delete/${user.id}">delete</a>
						<a href="/makeAdmin/${user.id}">make-admin</a>
					</c:if> <c:if test="${user.getRoles().get(0).name.contains('ROLE_ADMIN')}">
						<span>admin</span>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
