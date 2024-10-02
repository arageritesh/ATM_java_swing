package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    JButton deposit, bal, back, pinn, mini, fast, with;
    String pin;

    Fastcash(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("SELECT WITHDRAWN AMOUNT");
        text.setFont(new Font("Osward", Font.BOLD, 16));
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        label.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        label.add(deposit);

        with = new JButton("Rs 500");
        with.setBounds(355, 415, 150, 30);
        with.addActionListener(this);
        label.add(with);

        fast = new JButton("Rs 1000");
        fast.setBounds(170, 450, 150, 30);
        fast.addActionListener(this);
        label.add(fast);

        mini = new JButton("Rs 2000");
        mini.setBounds(355, 450, 150, 30);
        mini.addActionListener(this);
        label.add(mini);

        pinn = new JButton("Rs 5000");
        pinn.setBounds(170, 485, 150, 30);
        pinn.addActionListener(this);
        label.add(pinn);

        bal = new JButton("Rs 10000");
        bal.setBounds(355, 485, 150, 30);
        bal.addActionListener(this);
        label.add(bal);

        back = new JButton("back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        label.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3); // Rs 500
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank1 where pin='" + pin + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;  // Stop the transaction if balance is insufficient
                }

                Date date = new Date();
                String query = "insert into bank1 values('" + pin + "','" + date + "','Withdrawn','" + amount + "') ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Debited Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new Fastcash("");
    }
}
