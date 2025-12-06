package com.student.controller;
import java.io.IOException; import javax.servlet.*; import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if (s!=null) s.invalidate();
        res.sendRedirect("login.jsp");
    }
}
