<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div>
		<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3">
			<h2>Register</h2>
			<form:form modelAttribute="user" action="${pageContext.request.contextPath}/register">
				<div class="form-group">
					<label>Name</label>
					<form:input path="fullName" class="form-control" />
					<div class="help-block">
						<form:errors path="fullName" />
					</div>
				</div>
				<div class="form-group">
					<label>Email ID</label>
					<form:input path="emailID" class="form-control" />
					<div class="help-block">
						<form:errors path="emailID" />
					</div>
				</div>
				<div class="form-group">
					<label>Password</label>
					<form:password path="password" class="form-control" />
					<div class="help-block">
						<form:errors path="password" />
					</div>
				</div>
				<div class="form-group">
					<button class="btn btn-primary">Register</button>
					<a class="btn btn-link"	href="${pageContext.request.contextPath}/login">Login</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>