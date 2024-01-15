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
<title>New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5 col-6">
		<h1 class="text-center mb-4">New Product</h1>
		<a href="/">Home</a>
		<hr class="mb-4 border border-4">
		<form:form action="/create/product" method="POST"
			modelAttribute="product" class="border border-5 border-dark p-3 bg-warning">
			<table class="table table-bodered">
				<tr class="border border-3 border-dark">
					<th><form:label path="productName">Name :  
					<p class="text-danger"><form:errors path="productName"></form:errors></p>
					</form:label></th>
					<th><form:input path="productName" class="form-control" /></th>
				</tr>
				<tr class="border border-3 border-dark">
					<th><form:label path="description">Description : 
					<p class="text-danger"><form:errors path="description"></form:errors></p>
					</form:label></th>
					<th><form:input path="description" class="form-control" /></th>
				</tr>
				<tr class="border border-3 border-dark">

					<th><form:label path="price">Price : 
							<p class="text-danger">
								<form:errors path="price"></form:errors>
							</p>
						</form:label></th>
					<th>
						<form:input path="price" class="form-control" placeholder="Enter price between 1,00--2999,9 $"/>
					</th>
				</tr>

			</table>
			<div class="row ">
				<button class="btn btn-primary mt-2">Submit</button>
			</div>

		</form:form>


	</div>
</body>
</html>