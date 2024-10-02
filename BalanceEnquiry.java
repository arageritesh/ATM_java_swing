package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JButton back;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        label.add(back);
        
          Conn c = new Conn();
          int balance = 0;
        try
         {
               ResultSet rs = c.s.executeQuery("select * from bank1 where pin='" + pin + "'");
                
                while (rs.next())
                {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                       
                    }
                }
         }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        JLabel bal = new JLabel("Your current account balance is RS " + balance);
        bal.setForeground(Color.white);
        bal.setFont(new Font("Raleway", Font.BOLD, 16));
        bal.setBounds(170, 300, 400, 30);
        label.add(bal);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
