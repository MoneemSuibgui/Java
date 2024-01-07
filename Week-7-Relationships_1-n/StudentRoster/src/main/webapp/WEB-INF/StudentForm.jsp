
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
<title>New Student</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<body>
	<div class="container  mt-5 bg-warning p-3">
		<a href="/dorms">Dashboard</a>
		
			<form:form action="/create/student" method="post"
				modelAttribute="student">
				<table class="table table-border bg-info mt-4 text-center">
				<tr>
					<th><form:label path="studentName">Name :</form:label></th>
					<th>
						
						<form:errors path="studentName" class="text-danger" />
						<form:input path="studentName" class="form-control" />
					</th>
				</tr>
				<tr>
					<th><form:label path="dorm">Select Dorm :</form:label></th>
					<th><form:select path="dorm">
							<c:forEach var="oneDorm" items="${dorms}">
								<form:option value="${oneDorm.id }">
									<c:out value="${oneDorm.name}" />
								</form:option>
							</c:forEach>
						</form:select></th>
				</tr>
				</table>
					<div class="d-grid gap-2 mb-3">
						<button class="btn btn-primary" type="submit">Add</button>
					</div>
			</form:form>
		
	</div>

</body>
</html>