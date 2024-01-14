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
<title>Likes Status</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<div class="idea">
	<div class="container mt-4">
		<div class="text-end mb-3">
			<a href="/bright_ideas" class="btn btn-success mx-3">Bright Ideas</a> 
			<a href="/logout" class="btn btn-danger">Logout</a>
		</div>
		<div class="text-start d-flex justify-content-start mb-5">
			<a href="/users/${idea.creator.id}"><c:out value="${idea.creator.name}"/></a><span class="mx-1">says:</span>
			<textarea class="form-control"><c:out value="${idea.content}"/></textarea>
		</div>
		<h4>People who liked this post:</h4>
		<table class="table table-bordered table-hover table-striped mt-3">
			<thead>
				<tr class="bg-info">
					<th>Alias</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="follower" items="${idea.followers}">
				<tr>
				<td><a href="/users/${idea.creator.id}"></a><c:out value="${follower.alias}"/></td>
				<td><c:out value="${follower.name}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>