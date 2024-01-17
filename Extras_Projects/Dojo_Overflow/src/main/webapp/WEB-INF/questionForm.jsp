<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>New Question</title>
</head>
<body>

	<div class="container mt-5 col-8">
		<div class="d-flex justify-content-between mb-3">
			<h1>What is your question ?</h1>
			<a href="/" class="btn btn-success btn-lg">Dashboard</a>
		</div>
		
		<p class="text-danger  p-2 mt-3 mb-2">${errorMassage}</p>
		
		<form:form action="/create/question" modelAttribute="question"
			class="form" method="post">

			<div>
				<form:errors path="questionContent" class="text-danger" />
				<form:label path="questionContent">Question:</form:label>
				<form:textarea rows="4" path="questionContent"
					class="form-control mt-1 mb-3" />
			</div>

			<div>
				
				<label for="tagsList">Tags:</label> 
				<input name="tagsList" id="tagsList" class="form-control mt-1 mb-4 " />
			</div>

			<input type="submit" value="Submit" class="btn btn-primary btn-lg" />
		</form:form>
	</div>
</body>


</html>