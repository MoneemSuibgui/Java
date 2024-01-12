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
<title><c:out value="${loggedUser}" /></title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between">
			<h1>Add a Book to Your Shelf!</h1>
			<a href="/home">back to the shelves</a>
		</div>
		<form:form action="/books/new" methods="POST" modelAttribute="book">
		
		<p><form:errors path="title" class="text-danger"/></p>
		<form:label path="title">Title</form:label>
		<form:input path="title" class="form-control mb-3"/>
		
		
		<p><form:errors path="author" class="text-danger"/></p>
		<form:label path="author">Author</form:label>
		<form:input path="author" class="form-control mb-3"/>
		
		
		<p><form:errors path="thoughts" class="text-danger"/></p>
		<form:label path="thoughts">My Thoughts</form:label>
		<form:textarea path="thoughts" class="form-control mb-3"/>
		
		<div class="d-flex justify-content-end">
		<button class="btn btn-primary">Submit</button>
		</div>
		</form:form>
	</div>

</body>
</html>