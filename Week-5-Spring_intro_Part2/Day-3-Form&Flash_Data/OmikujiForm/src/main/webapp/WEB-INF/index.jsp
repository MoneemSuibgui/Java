<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
<div class="container p-4">
	<h1 class="mx-4 mt-2 mb-3">Send an Omikuji!</h1>
	<form action="/create/omikuji" method="POST">
		<div class="border border-dark border-5  p-4 bg-warning">
			<div class="mb-2">
				<label class="form-label">pick any number from 5 to 25 :</label>
				<br>
				<input type="number" name="num"/>
			</div>
	
			<div class="mb-2">
				<label class="form-label">Enter the name of any city :</label>
				<input type="text" name="city" class=" form-control"/>
			</div>
			
			<div class="mb-2">
				<label class="form-label">Enter the name of any real person :</label>
				<input type="text" name="personName" class="form-control"/>
			</div>
			
			<div class="mb-2">
				<label class="form-label">Enter professional endeavor or hobby :</label>
				<input type="text" name="hobby" class="form-control"/>
			</div>
			
			<div class="mb-2">
				<label class="form-label">Enter any type of living thing : :</label>
				<input type="text" name="mammal" class="form-control"/>
			</div>
			
			<div class="mb-4">
				<label class="form-label">Say something nice to someone  :</label>
				<textarea rows="4" cols="2" name="message" class="form-control"></textarea>
			</div>
			<p>Send and show a friend</p>
			<div class="d-flex justify-content-end mx-4">
				<input type="submit" value="Send" class="btn btn-primary"/>
			</div>
		</div>
	</form>
</div>

</body>
</html>