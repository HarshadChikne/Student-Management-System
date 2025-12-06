package com.student.controller;

import java.io.IOException; import javax.servlet.*; import javax.servlet.http.*; import java.sql.*;
import com.student.util.DBConnection;
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String username=req.getParameter("username"), password=req.getParameter("password");
        try (Connection con = DBConnection.getConnection()) 
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, username); ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
            {
                HttpSession session = req.getSession(); session.setAttribute("username", username);
                res.sendRedirect("dashboard.jsp");
            } 
            else 
            {
                res.sendRedirect("login.jsp");
            }
        } catch (Exception e) 
        	{ 
        		throw new ServletException(e); 
        	}
    }
}
