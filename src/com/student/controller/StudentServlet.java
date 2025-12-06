package com.student.controller;
import java.io.IOException; import javax.servlet.*; import javax.servlet.http.*;
import com.student.dao.StudentDAO; import com.student.model.Student;
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("create".equals(action)) {
            Student s = new Student();
            s.setName(req.getParameter("name"));
            s.setAge(Integer.parseInt(req.getParameter("age")==null||req.getParameter("age").isEmpty()?"0":req.getParameter("age")));
            s.setCourse(req.getParameter("course")); s.setEmail(req.getParameter("email"));
            StudentDAO.addStudent(s);
            res.sendRedirect("viewStudents.jsp");
        } else if ("update".equals(action)) {
            Student s = new Student();
            s.setId(Integer.parseInt(req.getParameter("id")));
            s.setName(req.getParameter("name"));
            s.setAge(Integer.parseInt(req.getParameter("age")==null||req.getParameter("age").isEmpty()?"0":req.getParameter("age")));
            s.setCourse(req.getParameter("course")); s.setEmail(req.getParameter("email"));
            StudentDAO.updateStudent(s);
            res.sendRedirect("viewStudents.jsp");
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            StudentDAO.deleteStudent(id);
            res.sendRedirect("viewStudents.jsp");
        } else { doPost(req,res); }
    }
}
