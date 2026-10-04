import java.sql.*;

public class Assignment20 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/JAVASG";
            Connection con = DriverManager.getConnection(db, "root", "sit@123");
            System.out.println("Connection established");

            Statement st = con.createStatement();

            // INSERT
            int r = st.executeUpdate("INSERT INTO COMPANY VALUES (1, 'Paul', 32, 'California', 20000)");
            System.out.println(r + " row inserted");
            r = st.executeUpdate("INSERT INTO COMPANY VALUES (2, 'Allen', 25, 'Texas', 15000)");
            System.out.println(r + " row inserted");

            // UPDATE
            r = st.executeUpdate("UPDATE COMPANY SET SALARY = 25000 WHERE ID = 1");
            System.out.println(r + " row updated");

            // DELETE
            r = st.executeUpdate("DELETE FROM COMPANY WHERE ID = 2");
            System.out.println(r + " row deleted");

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}