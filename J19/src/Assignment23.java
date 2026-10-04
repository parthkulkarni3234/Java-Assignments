import java.sql.*;

public class Assignment23 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/JAVASG";
            Connection con = DriverManager.getConnection(db, "root", "sit@123");
            System.out.println("Connection established");

            // Scrollable ResultSet so we can move in any direction
            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT ID, NAME, SALARY FROM COMPANY");

            rs.first();
            System.out.println("First     : " + rs.getString("NAME"));

            rs.last();
            System.out.println("Last      : " + rs.getString("NAME") + " (row " + rs.getRow() + ")");

            rs.previous();
            System.out.println("Previous  : " + rs.getString("NAME"));

            rs.absolute(1);
            System.out.println("Absolute 1: " + rs.getString("NAME"));

            System.out.println("\nAll rows in reverse order:");
            rs.afterLast();
            while (rs.previous()) {
                System.out.println(rs.getInt("ID") + " " + rs.getString("NAME") + " " + rs.getInt("SALARY"));
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}