
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
<title>New Dorm</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<body>
	<div class="container mt-5 p-4 col-6 bg-warning">
		<a href="/dorms" class="mb-4">Dashboard</a>

		<form:form action="/create/dorm" method="post" modelAttribute="dorm">
			<table class="table table-border table-active bg-success mt-4">
				<tr>
					<th><form:label path="name">Name :</form:label></th>
					<th><form:errors path="name" /> <form:input path="name"
							class="form-control" /></th>
				</tr>
			</table>
			<div class="d-grid gap-2">
				<button class="btn btn-primary" type="submit">Add</button>
			</div>

		</form:form>

	</div>

</body>
</html>