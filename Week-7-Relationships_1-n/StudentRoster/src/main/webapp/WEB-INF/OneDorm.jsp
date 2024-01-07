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
<title><c:out value="${dorm.name }" /></title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<body>
	<div class="container mt-4  p-4 ">



		<div class="d-flex justify-content-center">
			<h1>
				<c:out value="${dorm.name }" />
			</h1>
		</div>
		<a href="/">Dashboard</a><br>
		<form action="/add/student/${dorm.id}" method="post">
			<table class="table table-border table-active bg-success mt-4">
				<tr>
					<th><select name="studentId">
							<c:forEach var="student" items="${allStudents}">

								<c:if
									test="${!(studentDorm).contains(student) && !(allDorms.contains(student))}">

									<option id="studentId" value="${student.id}">
										<c:out value="${student.studentName}" />
									</option>
								</c:if>

							</c:forEach>

						</select>
						</th>
				</tr>
			</table>

			<div class="d-grid gap-2">

				<button class="btn btn-primary mb-2" type="submit">Add</button>
			</div>
		</form>

		<table
			class="table table-bordered table-hover table-striped mt-3 text-center">
			<tr>
				<th>Student</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="student" items="${dorm.students}">
				<tr>
					<td><c:out value="${student.studentName}" /></td>
					<td><a href="/delete/${student.id}/${dorm.id}"
						class="btn btn-danger">Remove</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>