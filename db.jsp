<%@ page import="java.sql.*, java.util.*" %>
<%!
    // ====== CHANGE THESE TO MATCH YOUR MySQL SETUP ======
    private static final String DB_URL  = "jdbc:mysql://localhost:3306/asg30_db"
            + "?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";
    // =====================================================

    private static boolean tablesReady = false;

    private synchronized Connection getConn() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        if (!tablesReady) {
            try (Statement st = con.createStatement()) {
                st.executeUpdate("CREATE TABLE IF NOT EXISTS employee ("
                    + "emp_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL,"
                    + "department VARCHAR(100) NOT NULL, designation VARCHAR(100) NOT NULL,"
                    + "salary DECIMAL(10,2) NOT NULL)");
                st.executeUpdate("CREATE TABLE IF NOT EXISTS patient ("
                    + "patient_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL,"
                    + "age INT NOT NULL, disease VARCHAR(150) NOT NULL,"
                    + "treatment_status VARCHAR(30) NOT NULL)");
            }
            tablesReady = true;
        }
        return con;
    }

    // escape HTML special characters in output
    private String esc(String s) {
        if (s == null) return "";
        return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;")
                .replace("\"","&quot;").replace("'","&#39;");
    }
%>
