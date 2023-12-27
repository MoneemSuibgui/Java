<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/main.js"></script>
<meta charset="ISO-8859-1">
<title>Time</title>
</head>
<body>
<h3>
<c:out value="${currentTime}" />
</h3>
</body>
</html>