<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin dashboard</title>
   	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="userContainer">
		<h1>Welcome <c:out value="${user.firstName}"></c:out></h1>
	
	   <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" class="logoutBtn" />
	    </form>
  </div>  
   <div class="userDetails">
   		<p>First Name : <c:out value="${user.firstName }"/></p>
   		<p>Last Name : <c:out value="${user.lastName }"/></p>
   		<p>Email : <c:out value="${user.email }"/></p>
   		<p>Sign up date : <fmt:formatDate pattern = "MMMM dd, y" value ="${user.createdAt}"/></p>
   		<p>Last Sign in : <fmt:formatDate pattern = "MMMM dd, y" value ="${lastLoginDate}"/></p>
   </div>
</body>
</html>
