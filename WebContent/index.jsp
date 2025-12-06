<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Student Management System</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">				
  <link  rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5 w-50 div-1">
 	<h1 class="pb-3">Welcome to Student Management System...!</h1>
	<p>
  		<a href="login.jsp" class="btn btn-primary "> Login </a> 
 		<a href="register.jsp" class="btn btn-outline-secondary">Register</a>
  </p>
	</div> 
</body>
</html>
