<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<h1 align="center">Todo App</h1>
	<div style="margin-top: 30px;"
		class="well well-lg col-md-8 col-md-offset-2">
		<p>${ useremail }</p>
		<p>You are here</p>
		<a href="${pageContext.request.contextPath}/task">Proceed to tasks</a>
	</div>

</body>
</html>