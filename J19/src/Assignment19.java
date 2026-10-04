import java.sql.*;

public class Assignment19 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/JAVASG";
            Connection con = DriverManager.getConnection(db, "root", "sit@123");
            System.out.println("Connection established");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM COMPANY");

            while (rs.next()) {
                System.out.println("ID      = " + rs.getInt("ID"));
                System.out.println("NAME    = " + rs.getString("NAME"));
                System.out.println("AGE     = " + rs.getInt("AGE"));
                System.out.println("ADDRESS = " + rs.getString("ADDRESS"));
                System.out.println("SALARY  = " + rs.getInt("SALARY"));
                System.out.println();
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}