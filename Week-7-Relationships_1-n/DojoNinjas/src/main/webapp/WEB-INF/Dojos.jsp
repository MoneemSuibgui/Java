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
<title>Dojo Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container col-6 mb-4 p-4">

		<div class="d-flex justify-content-between mb-4">
			<h1 class="mb-3">All Dojos :</h1>
			<div>
				<a href="/ninjas/new" class="btn btn-success">Create Ninja</a>
				<a href="/dojos/new" class="btn btn-dark">Create Dojo</a> 
			</div>
			
		</div>
		
		<div class="card bg-info p-4">
			<c:forEach var="dojo" items="${dojos}">
				<a href="/dojo/${dojo.id}"><c:out value="${dojo.name}" /></a>
			</c:forEach>
		</div>
	</div>
</body>
</html>