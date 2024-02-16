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
    <title>Login/Register</title> 
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
   <div class="loginContainer">
   		<h1>Login</h1>
   		
   		<c:if test="${errorMessage != null }">
   			<p><c:out value="${errorMessage }"></c:out></p>
   		</c:if>
   		
   		<c:if test="${logoutMessage != null }">
   			<p><c:out value="${logoutMessage }"></c:out></p>
   		</c:if>
   		
   		<form action="/login" method="post">
	   		<p>
		   		<label>Email</label>
		   		<input type="email" name="email"/>
	   		</p>
	   		
	   		<p>
		   		<label>Password</label>
		   		<input type="password" name="password"/>
	   		</p>
	   		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	   		<button class="loginBtn">Login</button>
   		</form>
   </div>
   
   <div class="registerContainer">
   		<h1>Register</h1>
   		<form:form action="/register" method="post" modelAttribute="user">
   			
   			<p><form:errors path="email" class="errors"/></p>
   			<p>
   				<form:label path="email">Email </form:label>
   				<form:input type="email" path="email"/> 
   			</p>  
   			
   			<p><form:errors path="firstName" class="errors"/></p>
   			<p>
   				<form:label path="firstName">First Name </form:label>
   				<form:input type="text" path="firstName"/> 
   			</p> 
   			
   			<p><form:errors path="lastName" class="errors"/></p>
   			<p>
   				<form:label path="lastName">Last Name </form:label>
   				<form:input type="text" path="lastName"/> 
   			</p> 
 
  			<p><form:errors path="password" class="errors"/></p>
   			<p>
   				<form:label path="password">Password </form:label>
   				<form:input type="password" path="password" /> 
   			</p>
   			
   			<p><form:errors path="confirm" class="errors"/></p>
   			<p>
   				<form:label path="confirm">Confirm PW</form:label>
   				<form:input type="text" path="confirm"/> 
   			</p> 
   			
   			<button class="registerBtn">Register</button>
   		</form:form>
   </div>
</body>
</html>
