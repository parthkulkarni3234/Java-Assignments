import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeRegistrationForm {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Employee Registration Form");

        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(30, 30, 100, 25);
        JTextField idField = new JTextField();
        idField.setBounds(150, 30, 150, 25);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 70, 150, 25);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(30, 110, 100, 25);
        JTextField deptField = new JTextField();
        deptField.setBounds(150, 110, 150, 25);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(30, 150, 100, 25);
        JTextField salaryField = new JTextField();
        salaryField.setBounds(150, 150, 150, 25);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(120, 190, 100, 30);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String dept = deptField.getText();
                String salary = salaryField.getText();

                JOptionPane.showMessageDialog(frame,
                        "Employee ID: " + id +
                        "\nName: " + name +
                        "\nDepartment: " + dept +
                        "\nSalary: " + salary,
                        "Employee Details", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.add(idLabel);
        frame.add(idField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(deptLabel);
        frame.add(deptField);
        frame.add(salaryLabel);
        frame.add(salaryField);
        frame.add(submitButton);

        frame.setSize(350, 280);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}