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
<title>Title</title>
</head>
<body>
	<div class="container col-8 mt-4">
		<div class="d-flex justify-content-between">
			<h1 class="text-primary">Edit Burger</h1>
			<a href="/" class="fs-4">Go Back</a>
		</div>
		<form:form action="/edit/burger/${editBurger.id}" method="put" modelAttribute="updatedBurger">
			<p>
				<form:errors path="burgerName" class="text-danger mx-4" />
			</p>
			<p>
				<form:label path="burgerName">Burger Name :</form:label>
				<form:input path="burgerName" class="form-control mt-2" value="${editBurger.burgerName }"></form:input>
			</p>
			<p>
				<form:errors path="restaurantName" class="text-danger mx-4" />
			</p>
			<p>
				<form:label path="restaurantName">Restaurant Name :</form:label>
				<form:input path="restaurantName" class="form-control mt-2" value="${editBurger.restaurantName }"></form:input>
			</p>

			<p>
				<form:errors path="rating" class="text-danger mx-4" />
			</p>
			<p>
				<form:label path="rating">Rating :</form:label>
				<form:input path="rating" class="form-control mt-2" type="number" value="${editBurger.rating}"></form:input>
			</p>
			<p>
				<form:errors path="note" class="text-danger mx-4" />
			</p>
			<p>
				<form:label path="note">Notes :</form:label>
				<textarea name="note" class="form-control mt-2">${editBurger.restaurantName }</textarea>
			</p>
			<input type="submit" value="Submit" class="btn btn-primary btn-lg" />
		</form:form>





	</div>
</body>
</html>