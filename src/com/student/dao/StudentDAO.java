package com.student.dao;
import java.sql.*; import java.util.*;
import com.student.model.Student; import com.student.util.DBConnection;
public class StudentDAO {
    public static int addStudent(Student s) {
        int status = 0;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students (name, age, course, email) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getEmail());
            status = ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        return status;
    }
    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students ORDER BY student_id ASC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("course"),
                    rs.getString("email")
                );
                list.add(s);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    public static Student getStudentById(int id) {
        Student s = null;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE student_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new Student(rs.getInt("student_id"), rs.getString("name"), rs.getInt("age"), rs.getString("course"), rs.getString("email"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return s;
    }
    public static int updateStudent(Student s) {
        int status = 0;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE students SET name=?, age=?, course=?, email=? WHERE student_id=?");
            ps.setString(1, s.getName()); ps.setInt(2, s.getAge()); ps.setString(3, s.getCourse()); ps.setString(4, s.getEmail()); ps.setInt(5, s.getId());
            status = ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        return status;
    }
    public static int deleteStudent(int id) {
        int status = 0;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE student_id = ?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        return status;
    }
}
