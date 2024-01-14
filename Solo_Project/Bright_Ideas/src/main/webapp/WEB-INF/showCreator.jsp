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
<title>User Profile</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<div class="creator container mt-5">
<div class="d-flex justify-content-between">
<h3>Name : <c:out value="${creator.name}"></c:out></h3>
<div>
<a href="/bright_ideas" class="btn btn-success mx-3">Bright Ideas</a>
<a href="/logout" class="btn btn-danger">Logout</a>
</div>
</div>
<h3>Alias : <c:out value="${creator.alias}"/></h3>
<h3 class="mb-4">Email : <c:out value="${creator.email }"/></h3>
<hr>
<h4 class="mt-2"> Total Number of Posts : <c:out value="${creator.ideas.size()}"/></h4>
<h4 class="mt-2"> Total Number of likes : <c:out value="${creator.likedIdeas.size()}"/></h4>
</div>
</body>
</html>