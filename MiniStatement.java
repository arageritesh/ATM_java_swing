package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String pin;

    MiniStatement(String pin) {
        this.pin = pin;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        // Display card number
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login1 where pin= '" + pin + "'");
            while (rs.next()) {
                card.setText("card Number :  " + rs.getString("accountNO").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("accountNO").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Display mini statement
        try {
            Conn conn = new Conn();

            // Retrieve and display individual transactions
            ResultSet rs = conn.s.executeQuery("select * from bank1 where pin= '" + pin + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount") + "<br><br><html>");
            }

            // Count the number of transactions for the given PIN
            ResultSet countRs = conn.s.executeQuery("select count(*) as transactionCount from bank1 where pin= '" + pin + "'");
            int transactionCount = 0;

            if (countRs.next()) {
                transactionCount = countRs.getInt("transactionCount");
            }

            // Display the total number of transactions
            mini.setText("<html>Total Transactions: " + transactionCount + "<br><br>" + mini.getText() + "<html>");
        } catch (Exception e) {
            System.out.println(e);
        }

        mini.setBounds(20, 140, 400, 200);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new MiniStatement("");
    }
}
