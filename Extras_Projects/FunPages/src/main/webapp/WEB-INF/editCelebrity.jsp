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
<title>Fun Pages</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
<!-- using bootstrap library for styling-->
	<div class="container mt-5">
		<h1>New Celebrity Page</h1>
		<a href="/home">Home</a>
		<div class="mt-4">
			<form:form action="/update/celebrity/${celebrity.id}" method="put"
				modelAttribute="celebrity">
				<p><form:errors class="text-danger" path="celebrityName"></form:errors></p>
				<form:label for="celebrityName" path="celebrityName">Name :</form:label>
				<form:input path="celebrityName" class="form-control mt-1 mb-4" />

				<p><form:errors class="text-danger" path="details"></form:errors></p>
				<form:label for="details" path="details"></form:label>
				<form:textarea path="details" class="form-control mt-1" />

				<div class="row mt-4">
					<input type="submit" value=Submit class="btn btn-primary btn-lg" />
				</div>

			</form:form>
			<c:if test="${celebrity.creator==user}">
			<a href="/delete/${celebrity.id}" class="btn btn-danger btn-lg mt-4">Delete</a>
			</c:if>
		</div>
	</div>
</body>
</html>