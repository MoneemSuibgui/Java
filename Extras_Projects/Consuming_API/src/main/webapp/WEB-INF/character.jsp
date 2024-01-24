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
<title>Star Wars API</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1>
		<c:out value="${character.name }"></c:out>
		Details :
	</h1>
	<div class="container mt-5 card bg-warning">
		<h3>
			Name :
			<c:out value="${character.name }"></c:out>
		</h3>
		<h3>
			Gender :
			<c:out value="${charater.gender}"></c:out>
		</h3>
		<h3>
			Hair Color :
			<c:out value="${charater.hair_color}"></c:out>
		</h3>
		<h3>
			Eye Color :
			<c:out value="${charater.eye_color}"></c:out>
		</h3>
	</div>
</body>
</html>