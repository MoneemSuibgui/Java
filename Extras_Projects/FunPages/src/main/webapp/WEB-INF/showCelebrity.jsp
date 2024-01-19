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
</head>
<body>
	<!-- adding some styling using bootstrap library -->
	<div class="container mt-5">
		<div class="mb-4">
			<h1 class="mb-3">
				<c:out value="${celebrity.celebrityName}"></c:out>
			</h1>
			<a href="/home">Home</a>
		</div>
		<p>
			* Page Manger :
			<c:out value="${celebrity.creator.userName }" />
		</p>
		<p>
			* Contact :
			<c:out value="${celebrity.creator.email }" />
		<p>* Details :</p>
		<div class="mx-5 mt-1">
			<c:out value="${celebrity.details }"></c:out>
		</div>
		<h3 class="mt-3">Followers :</h3>
		<div class=" border border-4 bg-warning mb-5 p-3">
			<ul>
				<c:forEach var="follower" items="${celebrity.followers}">
					<li class="mb-2"><span class="text-danger"><c:out
								value="${follower.userName}" /></span> -- <c:out
							value="${follower.email}" /></li>
				</c:forEach>
			</ul>
		</div>

		<div class="row">
		
		<c:if test="${!celebrity.followers.contains(loggedUser)}">
			<a href="/follow/${celebrity.id}" class="btn btn-info">Follow</a>
		</c:if>
		</div>

		<c:if test="${loggedUser.id == celebrity.creator.id}">
			<a href="/celebrities/${celebrity.id}/edit">Edit</a>
		</c:if>

	</div>
</body>
</html>