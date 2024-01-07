
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
<title>Dorms</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<body>
	<div class="container mt-4  p-4 ">
		<a href="/dorms/new">Add new dorm</a><br>
		<a href="/students/new">Add new student</a>
		<table class="table table-bordered table-hover table-striped mt-3 text-center">
			<tr>
				<th>Dorm</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="dorm"  items="${dorms}">
				<tr>
					<th><c:out value="${dorm.name}"/></th>
					<th><a href="/dorms/${dorm.id}">See Students</a></th>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>