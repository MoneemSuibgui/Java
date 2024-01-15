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

	<div class="container mt-5">
		<h1 class="mb-4">
			<c:out value="${product.productName}"></c:out>
		</h1>
		<a href="/">Home</a>
		<hr class="mb-3">
		<h2>Categories:</h2>
		<ul>

			<c:forEach var="category" items="${categories}">

				<c:if test="${product.categories.contains(category)}">
					<li><c:out value="${category.categoryName }" /></li>
				</c:if>
			</c:forEach>

		</ul>
		<hr class="mt-2 mb-4">
		<h3>Add Category :</h3>
		<form action="/add/category/${product.id}" method="post">


			<select name="categoryId" class="form-control mb-3">
				<c:forEach var="category" items="${categories }">
					<c:if test="${!product.getCategories().contains(category)}">
						<option id="categoryId" value="${category.id}"><c:out
								value="${category.categoryName}"></c:out>
						</option>
					</c:if>

				</c:forEach>

			</select>

			<div class="row">
				<button class="btn btn-primary btn-md">Add</button>
			</div>
		</form>
	</div>
</body>
</html>