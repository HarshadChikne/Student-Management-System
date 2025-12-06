<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>Add Student</title><link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"></head>
<body class="container mt-5">
  <h2>Add Student</h2>
  <form action="student" method="post">
    <input type="hidden" name="action" value="create">
    <div class="mb-3"><label>Name</label><input name="name" class="form-control" required></div>
    <div class="mb-3"><label>Age</label><input type="number" name="age" class="form-control"></div>
    <div class="mb-3"><label>Course</label><input name="course" class="form-control"></div>
    <div class="mb-3"><label>Email</label><input name="email" class="form-control"></div>
    <button class="btn btn-primary">Save</button>
  </form>
</body>
</html>
