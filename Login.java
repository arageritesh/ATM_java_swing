package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
       
    Login()
    {
        
        setTitle("ATM clone");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM ");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardNo = new JLabel("Card Number");
        cardNo.setFont(new Font("Osward", Font.BOLD, 20)); // Reduced font size
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);

        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Osward", Font.BOLD, 20)); // Reduced font size
        pin.setBounds(120, 220, 400, 40);
        add(pin);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        add(cardTextField);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        add(pinTextField);

        login = new JButton("Login");
        login.setBounds(430, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(300, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign up ");
        signup.setBounds(300, 350, 200, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardNo = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "select * from login1 where accountNo= '" + cardNo + "' and pin ='" + pin + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please insert correct card No. or pin");
                }
            } catch (Exception e) 
            {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
