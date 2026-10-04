import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Assignment24 extends JFrame {
    JTextField tId = new JTextField();
    JTextField tName = new JTextField();
    JTextField tAge = new JTextField();
    JTextField tAddress = new JTextField();
    JTextField tSalary = new JTextField();
    JTextArea area = new JTextArea(10, 40);
    Connection con;

    Assignment24() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVASG", "root", "sit@123");
            System.out.println("Connection established");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage());
            System.exit(0);
        }

        setTitle("JDBC with GUI - COMPANY");
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));
        form.add(new JLabel("ID"));      form.add(tId);
        form.add(new JLabel("Name"));    form.add(tName);
        form.add(new JLabel("Age"));     form.add(tAge);
        form.add(new JLabel("Address")); form.add(tAddress);
        form.add(new JLabel("Salary"));  form.add(tSalary);

        JButton bInsert = new JButton("Insert");
        JButton bUpdate = new JButton("Update");
        JButton bDelete = new JButton("Delete");
        JButton bView = new JButton("View All");
        JPanel buttons = new JPanel();
        buttons.add(bInsert); buttons.add(bUpdate); buttons.add(bDelete); buttons.add(bView);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.NORTH);
        top.add(buttons, BorderLayout.SOUTH);

        area.setEditable(false);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);

        bInsert.addActionListener(e -> insertRecord());
        bUpdate.addActionListener(e -> updateRecord());
        bDelete.addActionListener(e -> deleteRecord());
        bView.addActionListener(e -> viewRecords());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void insertRecord() {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO COMPANY VALUES (?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(tId.getText()));
            ps.setString(2, tName.getText());
            ps.setInt(3, Integer.parseInt(tAge.getText()));
            ps.setString(4, tAddress.getText());
            ps.setInt(5, Integer.parseInt(tSalary.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record inserted");
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void updateRecord() {
        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE COMPANY SET NAME=?, AGE=?, ADDRESS=?, SALARY=? WHERE ID=?");
            ps.setString(1, tName.getText());
            ps.setInt(2, Integer.parseInt(tAge.getText()));
            ps.setString(3, tAddress.getText());
            ps.setInt(4, Integer.parseInt(tSalary.getText()));
            ps.setInt(5, Integer.parseInt(tId.getText()));
            int r = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, r + " record updated");
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void deleteRecord() {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM COMPANY WHERE ID=?");
            ps.setInt(1, Integer.parseInt(tId.getText()));
            int r = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, r + " record deleted");
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void viewRecords() {
        try {
            area.setText("");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM COMPANY");
            while (rs.next()) {
                area.append(rs.getInt("ID") + " | " + rs.getString("NAME") + " | "
                    + rs.getInt("AGE") + " | " + rs.getString("ADDRESS") + " | "
                    + rs.getInt("SALARY") + "\n");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Assignment24());
    }
}