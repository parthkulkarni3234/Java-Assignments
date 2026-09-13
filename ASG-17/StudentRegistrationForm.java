import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration Form");

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 80, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(130, 30, 150, 25);

        JLabel rollLabel = new JLabel("Roll No:");
        rollLabel.setBounds(30, 70, 80, 25);
        JTextField rollField = new JTextField();
        rollField.setBounds(130, 70, 150, 25);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(30, 110, 80, 25);
        JTextField courseField = new JTextField();
        courseField.setBounds(130, 110, 150, 25);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 160, 100, 30);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String roll = rollField.getText();
                String course = courseField.getText();

                JOptionPane.showMessageDialog(frame,
                        "Name: " + name + "\nRoll No: " + roll + "\nCourse: " + course,
                        "Student Details", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(rollLabel);
        frame.add(rollField);
        frame.add(courseLabel);
        frame.add(courseField);
        frame.add(submitButton);

        frame.setSize(320, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}