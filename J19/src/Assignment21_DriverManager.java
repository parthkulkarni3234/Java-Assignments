import java.sql.*;

public class Assignment21_DriverManager {
    public static void main(String[] args) {
        try {
            // 1. Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. DriverManager creates the Connection
            String db = "jdbc:mysql://localhost:3306/JAVASG";
            Connection con = DriverManager.getConnection(db, "root", "sit@123");
            System.out.println("Connection established");

            // 3. Statement executes SQL
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO student VALUES (10, 'aditi')");
            System.out.println("1 row inserted");

            ResultSet rs = st.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + " " + rs.getString("name"));
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}