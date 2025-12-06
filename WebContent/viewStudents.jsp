<%@ page import="java.util.*,com.student.dao.StudentDAO,com.student.model.Student" %>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>View Students</title><link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"></head>
<body class="container mt-5">
  <h2>Student List</h2>
  <table class="table table-bordered table-striped">
    <thead><tr><th>ID</th><th>Name</th><th>Age</th><th>Course</th><th>Email</th><th>Actions</th></tr></thead>
    <tbody>
    <%
      List<Student> list = StudentDAO.getAllStudents();
      for(Student s : list) {
    %>
    <tr>
      <td><%= s.getId() %></td>
      <td><%= s.getName() %></td>
      <td><%= s.getAge() %></td>
      <td><%= s.getCourse() %></td>
      <td><%= s.getEmail() %></td>
      <td>
        <a href="editStudent.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-warning">Edit</a>
        <a href="student?action=delete&id=<%=s.getId()%>" class="btn btn-sm btn-danger" onclick="return confirm('Delete?')">Delete</a>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>
</body>
</html>
