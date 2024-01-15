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
<title>Category</title>
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
			<c:out value="${category.categoryName}"></c:out>
		</h1>
		<a href="/">Home</a>
		<hr class="mb-3">
		<h2>Products :</h2>
		<ul>

			<c:forEach var="product" items="${products}">
				<c:if test="${category.products.contains(product)}">
					<li><c:out value="${product.productName }" /></li>
				</c:if>
			</c:forEach>

		</ul>
		<hr class="mt-2 mb-4">
		<h3>Add Product :</h3>
		<form action="/add/product/${category.id}" method="post">

			<select name="productId" class="form-control mb-3">
				<c:forEach var="product" items="${products }">
				
					<c:if test="${!category.products.contains(product) }">
						<option id="productId" value="${product.id}"><c:out
								value="${product.productName}" />
						</option>
					</c:if>
				</c:forEach>
			</select>
		
		<div class="row">
			<button class="btn btn-primary">Add</button>
		</div>
		
		</form>
	</div>
</body>
</html>