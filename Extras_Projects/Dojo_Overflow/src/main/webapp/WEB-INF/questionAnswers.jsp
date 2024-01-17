<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Question_Answers</title>
</head>
<body>
	<div class="container mt-5">
		<h1>${question.questionContent}</h1>
		<p>
			<a href="/">Dashboard</a>
		</p>
		<div class="d-inline p-2 mt-4 ">
			Tags :
			<c:forEach var="tag" items="${question.tags}">
				<button type="button" class="btn btn-info">
					<c:out value="${tag.getSubject()}" />
				</button>
			</c:forEach>
		</div>

		<div class="d-flex justify-content-between mt-4">
			<div>
				<h3>Answers:</h3>
				<c:forEach var="answer" items="${question.answers}">
					<ul>
						<li><c:out value="${answer.content}" /></li>
					</ul>
				</c:forEach>
			</div>

			<div>
				<form:form action="/question/${question.id}/answer/new"
					modelAttribute="answer" class="form" method="post">

					<div>
						<p><form:errors path="content" class="text-danger"/></p>
						<form:label path="content">Answer:</form:label>
						<form:textarea rows="4" path="content" class="form-control" />
					</div>


					<button class="btn btn-primary mt-4">Answer it!</button>


				</form:form>
			</div>
		</div>

	</div>


</body>
</html>