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
<title>Bright Ideas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<div class="dashboard p-3">
	<div class="container mt-5">
	<div class="d-flex justify-content-between mb-5">
	<h3>Hi <c:out value="${loginUser.name}" ></c:out>!</h3>
		<a href="/logout" class="btn btn-danger">Logout</a>
	</div>
	<div class="col-10 d-flex justify-content-center">
	<form:form action="/bright_ideas" method="post" modelAttribute="idea">
		
		<p><form:errors path="content" class="text-danger"></form:errors></p>
		<div class="d-flex justify-content-evenly">
			<form:input path="content" class="form-control mx-4" placeholder="Post smothing witty here..."/>
			<button class="btn btn-primary  btn-lg">Idea!</button>
		</div>
	</form:form>
	</div>
	<div class="mt-5">
	<c:forEach var="idea" items="${ideas}">
		<div class=" d-flex justify-content-around mb-2">
			<a href="/users/${idea.creator.id}"><c:out value="${idea.creator.name}"/></a><p class="mx-1">says:</p>
			<textarea  class="form-control w-20"><c:out value="${idea.content}"></c:out></textarea>
			<c:if test="${idea.creator == loginUser }">
			<form action="/delete/${idea.id}" method="post">
			<input type="hidden" name="_method" value="delete"/>
				<button class="deleteBtn">X</button>
			</form>
			</c:if>
		</div>
		
		<div class="d-flex justify-content-around mb-2">
			<a href="/likes/${idea.id}" class="mx-4">Likes</a>
			<p><a href="/bright_ideas/${idea.id}"><c:out value="${idea.followers.size()}"/> people</a><span class="mx-1">Like this.</span></p>
		</div>
		
	</c:forEach>
	</div>
	</div>	
</div>
</body>
</html>