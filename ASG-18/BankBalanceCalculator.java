import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceCalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Balance Calculator");

        JLabel balanceLabel = new JLabel("Initial Balance:");
        balanceLabel.setBounds(30, 30, 120, 25);
        JTextField balanceField = new JTextField();
        balanceField.setBounds(160, 30, 150, 25);

        JLabel transLabel = new JLabel("Transaction Amount:");
        transLabel.setBounds(30, 70, 120, 25);
        JTextField transField = new JTextField();
        transField.setBounds(160, 70, 150, 25);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(30, 110, 110, 30);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(160, 110, 110, 30);

        JLabel resultLabel = new JLabel("Updated Balance: ");
        resultLabel.setBounds(30, 160, 280, 30);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = Double.parseDouble(balanceField.getText());
                double amount = Double.parseDouble(transField.getText());
                double updated = balance + amount;
                resultLabel.setText("Updated Balance: " + updated);
                balanceField.setText(String.valueOf(updated));
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = Double.parseDouble(balanceField.getText());
                double amount = Double.parseDouble(transField.getText());

                if (amount > balance) {
                    JOptionPane.showMessageDialog(frame, "Insufficient balance!");
                } else {
                    double updated = balance - amount;
                    resultLabel.setText("Updated Balance: " + updated);
                    balanceField.setText(String.valueOf(updated));
                }
            }
        });

        frame.add(balanceLabel);
        frame.add(balanceField);
        frame.add(transLabel);
        frame.add(transField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(resultLabel);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}