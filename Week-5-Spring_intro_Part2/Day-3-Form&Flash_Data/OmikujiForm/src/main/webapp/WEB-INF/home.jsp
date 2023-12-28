<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<title>Omikuji</title>
</head>
<body>
<div class="container col-3 mt-4">
<h1 class="fw-bold">Here's Your Omikuji!</h1>
	<div class="border border-secondary border-4 p-4 mb-4 mt-4 bg-info ">
		<span class="fs-2 fw-bolder">
		In <c:out value="${randomNumber}"></c:out> years, you will live in
		<c:out value="${city }"></c:out> with <c:out value="${personName}"></c:out>
		 as your roommate, <c:out value="${hobby}"></c:out> for a living.
		The next time you see <c:out value="${mammal}"></c:out>, you will have good luck.
		Also,You <c:out value="${message}"></c:out> 
		</span>
	</div>
	<div class="d-flex justify-content-center">
		<a href="/omikuji" class="fs-4">Go back</a>
	</div>
</div>

</body>
</html>