package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {
    JPasswordField t1, t2;
    JButton back, change;
    String pin;

    Pinchange(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Change your PIN");
        text.setFont(new Font("Osward", Font.BOLD, 20));
        text.setBounds(250, 280, 500, 35);
        text.setForeground(Color.WHITE);
        label.add(text);

        JLabel texta = new JLabel(" New PIN");
        texta.setFont(new Font("Osward", Font.BOLD, 16));
        texta.setBounds(165, 320, 180, 25);
        texta.setForeground(Color.WHITE);
        label.add(texta);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBounds(330, 320, 180, 25);
        label.add(t1);

        JLabel textb = new JLabel(" Confirm  PIN");
        textb.setFont(new Font("Osward", Font.BOLD, 16));
        textb.setBounds(165, 360, 180, 25);
        textb.setForeground(Color.WHITE);
        label.add(textb);

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBounds(330, 360, 180, 25);
        label.add(t2);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        label.add(change); // Fix this line

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        label.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = t1.getText();
                String rpin = t2.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN to confirm");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank1 set pin ='" + rpin + "' where pin ='" + pin + "'";
                String query2 = "update signup3 set PIN ='" + rpin + "' where PIN ='" + pin + "'";
                String query3 = "update login1 set pin ='" + rpin + "' where pin ='" + pin + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully!");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Pinchange("").setVisible(true);
    }
}
