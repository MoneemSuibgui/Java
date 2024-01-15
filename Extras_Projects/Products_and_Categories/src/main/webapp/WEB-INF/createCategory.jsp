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
<title>New Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5 col-6">
		<h1 class="text-center mb-4">New Category</h1>
		<a href="/">Home</a>
		<hr class="mb-4 border border-4 border-dark">
		<form:form action="/create/category" method="POST"
			modelAttribute="category" class="border border-5 border-dark bg-secondary">

			<table class="table table-bodered  table-stripped">
				<tr class="border border-2 border-dark">
					<th><form:label path="categoryName">Name :  
					<p class="text-danger">
								<form:errors path="categoryName"></form:errors>
							</p>
						</form:label></th>
					<th><form:input path="categoryName" class="form-control" /></th>
				</tr>
			</table>
			<div class="row pb-2 px-4">
				<button class="btn btn-primary mt-2">Submit</button>
			</div>

		</form:form>


	</div>
</body>
</html>