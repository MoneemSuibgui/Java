<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Fruits Store</title>
</head>
<body>
<h1>Fruit Store</h1>
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="fruit" items="${Fruits}">
		<tr>
			<td><c:out value="${fruit.name }"></c:out></td>
			<td><c:out value="${fruit.price }"></c:out></td>
		</tr>
	</c:forEach>
		
	</tbody>
</table>

</body>
</html>