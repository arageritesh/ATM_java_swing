package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit, back;
    String pin;
    

    Deposit(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Enter amount to deposit");
        text.setFont(new Font("Osward", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.WHITE);
        label.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 14));
        amount.setBounds(170, 350, 320, 25);
        label.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 460, 150, 30);
        deposit.addActionListener(this);
        label.add(deposit);

        back = new JButton("Back");
        back.setBounds(355, 490, 150, 30);
        back.addActionListener(this);
        label.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String depositAmount = amount.getText();
            java.util.Date date = new java.util.Date(); 

            if (depositAmount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount to deposit");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "INSERT INTO bank1 VALUES ('" + pin + "','" + date + "','Deposit','" + depositAmount + "')";
                    conn.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Amount deposited successfully!");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Deposit("");
    }
}