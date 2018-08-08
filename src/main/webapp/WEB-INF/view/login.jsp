<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<div id="loginbox" style="margin-top: 50px;" class="well well-lg col-md-6 col-md-offset-3">
			<h2>Login</h2>
			<form:form name="form" action="${pageContext.request.contextPath}/loginurl">
				<div class="form-group">
					<label for="useremail">Email</label> <input type="text"
						class="form-control" name="email" />
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" />
				</div>
				<div class="form-group">
					<a class="btn btn-link">Forgot Password?</a>
				</div>
				<div class="form-group">
					<button class="btn btn-primary">Login</button>
					<a class="btn btn-link"
						href="${pageContext.request.contextPath}/register">Register</a>
				</div>
				<div class="form-group">
					<div class="col-xs-15">
						<div>
							<c:if test="${param.error != null}">
								<div class="alert alert-danger col-xs-offset-1 col-xs-10">
									Invalid username and password.</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success col-xs-offset-1 col-xs-10">
									You have been logged out.</div>
							</c:if>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>