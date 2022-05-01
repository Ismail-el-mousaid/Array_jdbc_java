package Ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {


	public static void creerEtudiant(String lname, String fname, String phone) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");

            PreparedStatement ps = con.prepareStatement("INSERT INTO Student(LName, FName, Phone) VALUES(?, ?, ?)");

            ps.setString(1, lname);
            ps.setString(2, fname);
            ps.setString(3, phone);

            ps.executeUpdate();

            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void afficherEtudiantParCours(String title) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");

            /*PreparedStatement ps = con.prepareStatement("SELECT * FROM Student WHERE StudentID IN (SELECT StudentID FROM StudentCourse WHERE CourseID = (SELECT CourseID FROM Course WHERE Title = ?))");*/

            PreparedStatement ps = con.prepareStatement("SELECT s.* FROM Student s, StudentCourse sc, Course c WHERE s.StudentID = sc.StudentID AND c.CourseID = sc.CourseID AND c.Title = ?");

            ps.setString(1, title);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("LName"));
            }

            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void afficherCoursParEtudiant(int stdID) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");

            /*PreparedStatement ps = con.prepareStatement("SELECT * FROM Student WHERE StudentID IN (SELECT StudentID FROM StudentCourse WHERE CourseID = (SELECT CourseID FROM Course WHERE Title = ?))");*/

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Course WHERE CourseID IN (SELECT CourseID FROM StudentCourse WHERE StudentID = ?)");

            ps.setInt(1, stdID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Title"));
            }

            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }   
    }
	

}
