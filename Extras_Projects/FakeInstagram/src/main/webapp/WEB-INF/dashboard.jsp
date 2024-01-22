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
<title>Fake Instagram</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container m-5">
	
		<div class="d-flex justify-content-between">
		<h2>
			Welcome,
			<c:out value="${loggedUser.userName}" />
		</h2>
		<a href="/logout" class="btn btn-danger">Logout</a>
		</div>
		<form action="/home" method="POST"  enctype="multipart/form-data">
		
		<div class="form-group">
			<p class="text-danger">${errorMessage}</p>
			<label for="picture">Description</label>
			<input type="file" name="picture" class="form-control"/>
		</div>
		
		<div class="form-group mt-3">
			<label for="description">Description</label>
			<input type="text" name="description" class="form-control"/>
		</div>
				
		<button class="btn btn-success mt-4">Create post</button>
		</form>
	<div class="mt-5 p-3">
	<h3 class="mt-2">Picture Uploaded by user</h3>

	<c:forEach var="picture" items="${loggedUser.pictures}" >		
		<img src="${picture.image_path}"  height= "200px"width="200px" border="2px black solid" class="p-2 mt-3"  />
		<h4>Creator : <c:out value="${picture.user.userName}"></c:out></h4>
		<p> Description : <c:out value="${picture.description}" /></p>	
	</c:forEach>

	</div>
</div>
</body>
</html>