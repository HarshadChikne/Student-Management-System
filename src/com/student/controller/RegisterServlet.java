package com.student.controller;
import java.io.IOException; import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*; import java.sql.*; import com.student.util.DBConnection;


public class RegisterServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
        String username=req.getParameter("username"), password=req.getParameter("password"), email=req.getParameter("email");
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(username,password,email) VALUES(?,?,?)");
            ps.setString(1, username); ps.setString(2, password); ps.setString(3, email);
            ps.executeUpdate();
            res.sendRedirect("login.jsp");
        } catch (Exception e) 
        { 
        	throw new ServletException(e); 
        }
    }
}
