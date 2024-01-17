<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Questions Dashboard</title>
</head>
<body>
	<div class="container mt-5 col-8 ">
		<h1>Questions Dashboard :</h1>

		<table
			class="table table-bordered table-stripped table-hover text-center">
			<thead>
				<tr class="bg-warning">
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="question" items="${questions}">
					<tr>
						<td><a href="/question/${question.id}"><c:out
									value="${question.questionContent}"></c:out></a></td>
						<td><c:forEach var="tag" items="${question.tags}">
								<span>${tag.getSubject()}<c:if
										test="${question.tags.indexOf(tag)<question.tags.size()-1}">, </c:if></span>
							</c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<a href="/questions/new">New Question</a>
	</div>


</body>
</html>