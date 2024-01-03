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
		<h1 class="mb-4">All Books : </h1>
		<table class="table table-bordered table-hover">
		    <thead class="table-info">
			    <tr class="text-center fs-5">
			    	<th>ID</th>
			    	<th>Title</th>
			    	<th>Language</th>
			    	<th># Pages</th>
			    </tr>
		    </thead>
		    <tbody>
		    	<c:forEach items="${books}" var="book">
			    	<tr class="text-center fw-semibold">
			    		<td><c:out value="${book.id}"></c:out></td>
			    		<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
			    		<td><c:out value="${book.language}"></c:out></td>
			    		<td><c:out value="${book.numberOfPages}"></c:out></td>
			    	</tr>
		    	</c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>