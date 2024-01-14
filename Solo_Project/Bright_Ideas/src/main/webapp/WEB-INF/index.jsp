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
<title>Login_Register</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<%-- adding some styling using bootstrap library --%>
	<div class="main">
	<div class="container mt-5 p-4">
		<div class="row">
			<h1 class="mb-3">Welcome</h1>
			<div class="col-5 bg-warning p-3 border border-4 border-dark">
			<h2 class="mx-5 mb-4">Register</h2>
				<form:form action="/register" method="post" modelAttribute="newUser">

					<p><form:errors path="name" class="text-danger" /></p>
					<div class="d-flex justify-content-between mb-2">
					<form:label path="name" class="mx-1 col-3 fst-italic fw-medium">Name  </form:label>
					<form:input path="name" class="form-control mb-3" />
					</div>
					
					<p><form:errors path="alias" class="text-danger" /></p>
					<div class="d-flex justify-content-between mb-2">
					<form:label path="alias" class="mx-1 col-3 fst-italic fw-medium fs-5">Alias  </form:label>
					<form:input path="alias" class="form-control mb-3" />
					</div>
					
					<p><form:errors path="email" class="text-danger" /></p>
					<div class="d-flex justify-content-between mb-2">
					<form:label path="email" class="mx-1 col-3 fst-italic fw-medium fs-5">Email  </form:label>
					<form:input path="email" class="form-control mb-3" />
					</div>
					
					
					<p><form:errors path="password" class="text-danger" /></p>
					<div class="d-flex justify-content-between mb-2">
					<form:label path="password" class="mx-1 col-3 fst-italic fw-medium fs-5">Password  </form:label>
					<form:input path="password" class="form-control mb-3" />
					</div>
					
					<p><form:errors path="confirmPass" class="text-danger" /></p>
					<div class="d-flex justify-content-between mb-2">
					<form:label path="confirmPass" class="mx-1 col-3 fst-italic fw-medium fs-5">Confirm PW </form:label>
					<form:input path="confirmPass" class="form-control mb-2" />
					</div>
					
					<div class="text-end">
					<button class="btn btn-primary btn-lg mt-3">Submit</button>
					</div>
					
				</form:form>
			</div>
			<div class="col-5 p-3 h-30 mx-5 bg-info border border-5 border-dark">
			<h2 class="mx-5 mb-4">Login</h2>
				<form:form action="/login" method="post" modelAttribute="loggedInUser">

					<p><form:errors path="email" class="text-danger" /></p>
					<div class="d-flex justify-content-between mb-2">
						<form:label path="email" class="mx-1 col-3 fw-medium fs-5">Email </form:label>
						<form:input path="email" class="form-control mb-3" />	
					</div>
					
					<p><form:errors path="password" class="text-danger" /></p>
					<div class="d-flex justify-content-between mb-2">
						<form:label path="password" class="mx-1 col-3 fw-medium fs-5">Password </form:label>
						<form:input path="password" class="form-control mb-3" />
					</div>

					<div class="text-end">
					<button class="btn btn-primary btn-lg mt-3">Submit</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>