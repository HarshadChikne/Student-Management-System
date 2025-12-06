package com.student.util;
import java.sql.*;
public class DBConnection {
    private static Connection conn = null;
    public static Connection getConnection() 
    {
        try {
            if (conn == null || conn.isClosed()) 
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager
                		.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
            }
        } catch (Exception e) 
        { 
        	e.printStackTrace(); 
        }
        return conn;
    }
}
