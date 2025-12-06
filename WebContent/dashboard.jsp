<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page session="true" %>
<%
  String user = (String) session.getAttribute("username");
  if (user == null) { response.sendRedirect("login.jsp"); return; }
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Dashboard</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
  <h2>Dashboard</h2>
  <p>Welcome, <strong><%= user %></strong>! <a href="logout" class="btn btn-sm btn-outline-danger">Logout</a></p>
  <p><a href="addStudent.jsp" class="btn btn-success">Add Student</a> <a href="viewStudents.jsp" class="btn btn-info">View Students</a></p>
</body>
</html>
