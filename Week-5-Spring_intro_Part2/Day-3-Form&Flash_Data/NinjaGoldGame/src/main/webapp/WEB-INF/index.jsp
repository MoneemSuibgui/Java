<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Ninja Gold Game</title>
</head>
<body>
<div class="container col-7 mt-4 border border-4 px-4 py-1">
	<div class="mb-5">
		<h3>Your Gold : </h3>
		<form action="/reset" method="post">
		<input type="number" name="score"  value="<c:out value="${gold}"/>"/>
				<button class="btn btn-danger btn-sm mx-4 mb-2" name="reset">Reset</button>
		</form>
	</div>
	<div class="d-flex inline-block mb-5 mt-3">
	
	<form action="/earn/gold" method="post">
		<input type="hidden" name="farm" />
		<div class="border border-3 border-secondary p-4">
			<h4>Farm</h4>
			<p class="mb-2 mt-2">(earns 10-20 gold)</p>
			<input type="submit" value="Find Gold!" class="btn btn-primary"/>
		</div>
	</form>
	
	
	<form action="/earn/gold" method="post">
		<input type="hidden" name="cave" value="cave"/>
		<div class="border border-3 border-secondary p-4 mx-3">
			<h4>Cave</h4>
			<p class="mb-2 mt-2">(earns 5-10 gold)</p>
			<input type="submit" value="Find Gold!" class="btn btn-primary"/>
		</div>
	</form>
	
	
	<form action="/earn/gold" method="post">
		<input type="hidden" name="house"  />
		<div class="border border-3 border-secondary p-4 mx-3">
			<h4>House</h4>
			<p class="mb-2 mt-2">(earns 2-5 gold)</p>
			<input type="submit" value="Find Gold!" class="btn btn-primary"/>
		</div>
	</form>
	
	
	<form action="/earn/gold" method="post">
		<input type="hidden" name="quest" />
		<div class="border border-3 border-secondary p-4 mx-3">
			<h4>Quest</h4>
			<p class="mb-2 mt-2">(earns/takes 0-5 gold)</p>
			<input type="submit" value="Find Gold!" class="btn btn-primary "/>
		</div>
	</form>
	</div>
	<h4 class="mb-4">Activities : </h4>
	<div class="text-center border border-4">
            <div class="overflow-auto" style="height: 10rem;">
                <c:forEach items="${activities }" var="activity">
					<c:if test="${activity.contains('earned')}">
						<p class="text-success fs-4">* <c:out value="${activity}"/></p>
					</c:if>
					<c:if test="${activity.contains('lost')}">
					   <p class="text-danger fs-4">* <c:out value="${activity}"/></p>
					</c:if>
				</c:forEach>
            </div> 
        </div>
</div>

</body>
</html>