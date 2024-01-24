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
	<div class="container mt-5 col-10">

		<form action="/star_wars/people" method="GET">
			<div class="d-flex justify-content-around">
				<div>
					<p>
						<label>People : </label> <select class="form-control" name="id">
							<c:forEach var="character" items="${people.results}"
								varStatus="myLoop">
								<option value="${myLoop.index +1}"><c:out
										value="${character.name}" /></option>
							</c:forEach>
						</select>
					</p>
				</div>
				<div class="mt-2"><button class="btn btn-primary btn-lg">Search Character</button></div>
			</div>
		</form>
	</div>
</body>
</html>