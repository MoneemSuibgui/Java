<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Current visit count</title>
</head>
<body>
<h4>You have visited   
<a href="/your_server"> http://your_server</a>
  <c:out value="${counter}"></c:out> times
</h4>
<a href="/your_server" class="dasboardLink">Test another visit?</a>
</body>
</html>