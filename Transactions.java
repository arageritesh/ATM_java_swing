package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, bal, exit, pinn, mini, fast, with;
  String pin;
    Transactions(String pin) 
    {
        this.pin=pin;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
         JLabel label =new JLabel(i3);
         label.setBounds(0,0,900,900);
         add(label);
         
          JLabel text =new JLabel ("Select your Transaction");
         text.setFont(new Font("Osward",Font.BOLD,16));
         text.setBounds(210,300,700,35);
         text.setForeground(Color.WHITE);
          label.add(text);

        deposit = new JButton("Deposit ");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        label.add(deposit);

         with =new JButton ("Withdrawn");
         with.setBounds(355,415,150,30);
         with.addActionListener(this);
         label.add(with);
         
        fast =new JButton ("Fastcash");
         fast.setBounds(170,450,150,30);
         fast.addActionListener(this);
         label.add(fast);
         
          mini =new JButton ("Mini Satement");
          mini.setBounds(355,450,150,30);
          mini.addActionListener(this);
          label.add( mini);
          
           pinn =new JButton ("PIN change");
          pinn.setBounds(170,485,150,30);
          pinn.addActionListener(this);
          label.add( pinn);
          
           bal =new JButton ("Balance Enquiry");
          bal.setBounds(355,485,150,30);
          bal.addActionListener(this);
          label.add( bal);
         
           exit =new JButton ("Exit");
          exit.setBounds(355,520,150,30);
          exit.addActionListener(this);
          label.add(exit);
          
          
         
       
       
       
       
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
       
       
   
    
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if (ae.getSource() == with) {
            setVisible(false);
            new Withdrawn(pin).setVisible(true);
        }
         else if (ae.getSource() == fast) {
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        }
         else if (ae.getSource() == pinn) {
            setVisible(false);
            new Pinchange(pin).setVisible(true);
        }
        
        else if (ae.getSource() == bal) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if (ae.getSource() == mini) {
            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
        
        
        
        
        // ... (add similar conditions for other buttons)
    }

    public static void main(String args[]) 
    {
        new Transactions("");
    }
}

