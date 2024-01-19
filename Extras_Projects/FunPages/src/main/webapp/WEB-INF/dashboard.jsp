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
<title>Fan Pages</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container col-6 mt-5">
		<h1>
			Welcome,
			<c:out value="${loggedUser.userName}" />
		</h1>
		<a href="/logout">Logout</a>
		<div class="mt-4">
			<div class="row mb-3">
				<a href="/celebrities/new" class="btn btn-info">Add Celebrity
					Page</a>
			</div>
			<p class="text-danger">${errorMesssage}</p>
				<form action="/search" method="post">
				<div class="d-flex justify-content-between mt-4 mx-5">
					<input name="name" class="form-control mx-4" />
					<button class="btn btn-primary btn-lg">Search</button>
				</div>
				</form>
			
			
			<c:forEach var="celebrity" items="${celebrities}">
			<div class="mt-5">
			<p class="fs-4 mb-1">
			<a href="/celebrities/${celebrity.id}"><c:out value="${celebrity.celebrityName}"/></a>
			</p>
			<p>Page Manager : <c:out value="${celebrity.creator.userName }"/></p>
			<h4>Followers : <span class="text-danger"><c:out value="${celebrity.getFollowers().size()}"/></span></h4>
			</div>
			</c:forEach>
			
		</div>
	</div>

</body>
</html>