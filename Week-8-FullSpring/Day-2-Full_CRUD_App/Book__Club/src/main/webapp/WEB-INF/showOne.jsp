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
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between mb-5">
			<h1>
				<c:out value="${book.title}" />
			</h1>
			<a href="/home">Back to the shelves</a>
		</div>
		<c:if test="${user.equals(book.creator) }">
		<h4 class="mb-2">
			<span class="text-danger"><c:out value="${user.userName}" /></span>
			read <span class="text-info"><c:out value="${book.title}" /></span>
			by
			<c:out value="${book.creator.userName}" />
			.
		</h4>
		<h5>Here are <c:out value="${user.userName}"/>'s thoughts :</h5>
		</c:if>
		<hr>
		<p>
			<c:out value="${book.thoughts}" />
		</p>
		<hr>
		<c:if test="${user.id == book.creator.id }">
			<div class="d-flex justify-content-end">
				<a href="/books/${book.id}/edit" class="btn btn-secondary mx-2">Edit</a>
				<form action="/delete/${book.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<button class="btn btn-danger">delete</button>
				</form>
			</div>
		</c:if>
	</div>

</body>
</html>