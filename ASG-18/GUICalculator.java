import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUICalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("GUI Calculator");

        JLabel num1Label = new JLabel("Number 1:");
        num1Label.setBounds(30, 30, 80, 25);
        JTextField num1Field = new JTextField();
        num1Field.setBounds(130, 30, 150, 25);

        JLabel num2Label = new JLabel("Number 2:");
        num2Label.setBounds(30, 70, 80, 25);
        JTextField num2Field = new JTextField();
        num2Field.setBounds(130, 70, 150, 25);

        JButton addButton = new JButton("Add");
        addButton.setBounds(30, 110, 100, 30);

        JButton subButton = new JButton("Subtract");
        subButton.setBounds(150, 110, 100, 30);

        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(30, 160, 250, 30);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double n1 = Double.parseDouble(num1Field.getText());
                double n2 = Double.parseDouble(num2Field.getText());
                resultLabel.setText("Result: " + (n1 + n2));
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double n1 = Double.parseDouble(num1Field.getText());
                double n2 = Double.parseDouble(num2Field.getText());
                resultLabel.setText("Result: " + (n1 - n2));
            }
        });

        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(resultLabel);

        frame.setSize(320, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}