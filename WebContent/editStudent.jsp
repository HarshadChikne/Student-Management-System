<%@ page import="com.student.dao.StudentDAO,com.student.model.Student"%>
<% 
  String id = request.getParameter("id");
  Student s = null;
  if (id != null) s = StudentDAO.getStudentById(Integer.parseInt(id));
  if (s == null) { response.sendRedirect("viewStudents.jsp"); return; }
%>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>Edit Student</title><link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"></head>
<body class="container mt-5">
  <h2>Edit Student</h2>
  <form action="student" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= s.getId() %>">
    <div class="mb-3"><label>Name</label><input name="name" value="<%= s.getName() %>" class="form-control" required></div>
    <div class="mb-3"><label>Age</label><input type="number" name="age" value="<%= s.getAge() %>" class="form-control"></div>
    <div class="mb-3"><label>Course</label><input name="course" value="<%= s.getCourse() %>" class="form-control"></div>
    <div class="mb-3"><label>Email</label><input name="email" value="<%= s.getEmail() %>" class="form-control"></div>
    <button class="btn btn-primary">Update</button>
  </form>
</body>
</html>
