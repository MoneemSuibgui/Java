<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Burger Tracker</title>
</head>
<body>
	<div class="container col-8 mt-4">
		<h1 class="text-primary mb-3">Burger Tracker</h1>
		<table class="table table-bordered table-hover mb-4">
			<tr class="text-center bg-secondary text-light fs-4">
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (out of 5)</th>
			</tr>
			<c:forEach var="burger" items="${burgers}">
				<tr class="text-center bg-warning fs-5">
					<td><c:out value="${burger.burgerName}"></c:out></td>
					<td><c:out value="${burger.restaurantName}"></c:out></td>
					<td><c:out value="${burger.rating}"></c:out></td>
				</tr>
			</c:forEach>

		</table>
		<div class="col-5 mt-3">
			<h2 class="mb-2 text-success">Add a Burger :</h2>
			<form:form action="/" method="post" modelAttribute="burger">
				<p>
					<form:errors path="burgerName" class="text-danger mx-4" />
				</p>
				<p>
					<form:label path="burgerName">Burger Name :</form:label>
					<form:input path="burgerName" class="form-control mt-2"></form:input>
				</p>
				<p>
					<form:errors path="restaurantName" class="text-danger mx-4" />
				</p>
				<p>
					<form:label path="restaurantName">Restaurant Name :</form:label>
					<form:input path="restaurantName" class="form-control mt-2"></form:input>
				</p>

				<p>
					<form:errors path="rating" class="text-danger mx-4" />
				</p>
				<p>
					<form:label path="rating">Rating :</form:label>
					<form:input path="rating" class="form-control mt-2" type="number"></form:input>
				</p>
				<p>
					<form:errors path="note" class="text-danger mx-4" />
				</p>
				<p>
					<form:label path="note">Notes :</form:label>
					<textarea   name="note" class="form-control mt-2"></textarea>
				</p>
				<input type="submit" value="Submit" class="btn btn-primary btn-lg" />
			</form:form>
		</div>

	</div>
</body>
</html>