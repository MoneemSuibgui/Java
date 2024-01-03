<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Reading Books</title>
</head>
<body>
	<div class="container mt-4">
		<h1 class="mb-4"> <c:out value="${book.title }"></c:out></h1>
		<div class="fw-semibold">
			<p>Description : <c:out value="${book.description }"></c:out></p>
			<p>Language : <c:out value="${book.language }"></c:out></p>
			<p> Number of Pages : <c:out value="${book.numberOfPages }"></c:out></p>
		</div>
	</div>
</body>
</html>