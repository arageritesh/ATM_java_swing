package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel accountDetails = new JLabel("page 3 : Account_Details ");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(280, 40, 400, 40);
        add(accountDetails);

        JLabel type = new JLabel("Ac Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving");
        r1.setBounds(100, 180, 150, 20);
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        add(r1);

        r4 = new JRadioButton("Recurring");
        r4.setBounds(300, 180, 150, 20);
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        add(r4);

        r3 = new JRadioButton("Current");
        r3.setBounds(100, 220, 150, 20);
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        add(r3);

        r2 = new JRadioButton("FD");
        r2.setBounds(300, 220, 60, 30);
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        add(r2);

        ButtonGroup gac = new ButtonGroup();
        gac.add(r1);
        gac.add(r2);
        gac.add(r3);
        gac.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel num = new JLabel("XXXX-XXXX-XXXX-1425");
        num.setFont(new Font("Raleway", Font.BOLD, 22));
        num.setBounds(330, 300, 300, 30);
        add(num);

        JLabel num1 = new JLabel("Your card Number");
        num1.setFont(new Font("Raleway", Font.BOLD, 14));
        num1.setBounds(100, 330, 300, 20);
        add(num1);

        JLabel pina = new JLabel("PIN");
        pina.setFont(new Font("Raleway", Font.BOLD, 22));
        pina.setBounds(100, 370, 200, 30);
        add(pina);

        JLabel pinb = new JLabel("XXXX");
        pinb.setFont(new Font("Raleway", Font.BOLD, 22));
        pinb.setBounds(330, 370, 300, 30);
        add(pinb);

        JLabel pind = new JLabel("Your PIN");
        pind.setFont(new Font("Raleway", Font.BOLD, 12));
        pind.setBounds(100, 400, 300, 20);
        add(pind);

        JLabel service = new JLabel("Services");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 450, 200, 30);
        add(service);

        c1 = new JCheckBox("ATM card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct.....");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit = new JButton("submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String type = null;

            if (r1.isSelected()) {
                type = "Saving Account";
            } else if (r2.isSelected()) {
                type = "Fixed Account";
            } else if (r3.isSelected()) {
                type = "Current Account";
            } else if (r4.isSelected()) {
                type = "Recurring Account";
            }
               
            Random random=new Random();
            try {
                if (type == null) {
                    JOptionPane.showMessageDialog(null, "Account type is Required");
                } else {
                    Conn conn = new Conn();
                    String card = "" + Math.abs((random.nextLong() % 90000000) + 504093600000000L);
                    String pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

                    String facility = "";

                    if (c1.isSelected()) {
                        facility = facility + "ATM card";
                    } else if (c2.isSelected()) {
                        facility = facility + "Internet Banking";
                    } else if (c3.isSelected()) {
                        facility = facility + "Mobile Banking";
                    } else if (c4.isSelected()) {
                        facility = facility + "Email Alerts";
                    } else if (c5.isSelected()) {
                        facility = facility + "Cheque Book";
                    } else if (c6.isSelected()) {
                        facility = facility + "E statements";
                    }

                    String query1 = "INSERT INTO signup3 VALUES('" + formno + "','" + type + "','" + card + "','" + pin + "','" + facility + "')";
                    conn.s.executeUpdate(query1);

                    String query2 = "INSERT INTO login1 VALUES('" + formno + "','" + card + "','" + pin + "')";
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + card + "\nPIN: " + pin);
                    setVisible(false);
                    new Login().setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login(formno).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Signup3("");
    }
}
