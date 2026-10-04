import java.sql.*;
import java.util.Scanner;

public class Assignment22{
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/JAVASG";
        Connection con = DriverManager.getConnection(db, "root", "sit@123");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter roll no: ");
        int rollno = sc.nextInt();
        System.out.print("Enter Name: ");
        String name = sc.next();

        // PreparedStatement - INSERT
        PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES (?, ?)");
        ps.setInt(1, rollno);
        ps.setString(2, name);
        ps.executeUpdate();
        System.out.println("1 row inserted");

        // PreparedStatement - SELECT, read with ResultSet
        PreparedStatement ps2 = con.prepareStatement("SELECT * FROM student WHERE rollno >= ?");
        ps2.setInt(1, 1);
        ResultSet rs = ps2.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("rollno") + " " + rs.getString("name"));
        }

        rs.close();
        ps.close();
        ps2.close();
        con.close();
        sc.close();
    }
}