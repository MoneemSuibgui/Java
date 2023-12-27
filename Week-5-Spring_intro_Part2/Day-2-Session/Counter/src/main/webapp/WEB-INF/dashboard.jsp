<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Welcome, again</title>
</head>
<body>
<h1>Welcome User!</h1>

<a href="/your_server/counter" class="counterLink">Go to counter page1</a>
<span class="counter"><c:out value="${counter } "></c:out></span>
</body>
</html>