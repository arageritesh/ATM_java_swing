package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {

    JTextField pan, adhar;
    JButton next;
    JRadioButton yesE, noE, no, yes;
    JComboBox<String> religion, category, occupation, income, education;
    String formno;

    Signup2(String formno) {
        this.formno = formno;

        setLayout(null);
        setTitle("New Application form : Page 2");

        JLabel additionalDetails = new JLabel("page 2 : Additional_Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel labelReligion = new JLabel("Religion");
        labelReligion.setFont(new Font("Raleway", Font.BOLD, 20));
        labelReligion.setBounds(100, 140, 100, 30);
        add(labelReligion);

        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(350, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel labelCategory = new JLabel("Category");
        labelCategory.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCategory.setBounds(100, 190, 200, 30);
        add(labelCategory);

        String[] valCategory = {"General", "SC", "ST", "OBC", "other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(350, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel labelIncome = new JLabel("Income");
        labelIncome.setFont(new Font("Raleway", Font.BOLD, 20));
        labelIncome.setBounds(100, 240, 200, 30);
        add(labelIncome);

        String[] valIncome = {"Null", "<150000", "<250000", "<500000", "upto 1000000"};
        income = new JComboBox<>(valIncome);
        income.setBounds(350, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel labelEducation = new JLabel("Education");
        labelEducation.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEducation.setBounds(100, 290, 100, 30);
        add(labelEducation);

        String[] valEducation = {"Non Graduate", "Graduate", "Post Graduate", "Doctorate", "Others"};
        education = new JComboBox<>(valEducation);
        education.setBounds(350, 290, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel labelOccupation = new JLabel("Work");
        labelOccupation.setFont(new Font("Raleway", Font.BOLD, 20));
        labelOccupation.setBounds(100, 340, 100, 30);
        add(labelOccupation);

        String[] valOccupation = {"Salaried", "Self Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox<>(valOccupation);
        occupation.setBounds(350, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel labelPan = new JLabel("PAN No");
        labelPan.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPan.setBounds(100, 390, 100, 30);
        add(labelPan);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(350, 390, 400, 30);
        add(pan);

        JLabel labelAdhar = new JLabel("Adhar No");
        labelAdhar.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdhar.setBounds(100, 440, 100, 30);
        add(labelAdhar);

        adhar = new JTextField();
        adhar.setFont(new Font("Raleway", Font.BOLD, 14));
        adhar.setBounds(350, 440, 400, 30);
        add(adhar);

        JLabel senior = new JLabel("Senior citizen");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 490, 200, 30);
        add(senior);

        yes = new JRadioButton("Yes");
        yes.setBounds(350, 490, 100, 30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(500, 490, 100, 30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(yes);
        seniorGroup.add(no);

        JLabel exit = new JLabel("Existing account ");
        exit.setFont(new Font("Raleway", Font.BOLD, 20));
        exit.setBounds(100, 540, 200, 30);
        add(exit);

        yesE = new JRadioButton("Yes");
        yesE.setBounds(350, 540, 100, 30);
        yesE.setBackground(Color.WHITE);
        add(yesE);

        noE = new JRadioButton("No");
        noE.setBounds(500, 540, 100, 30);
        noE.setBackground(Color.WHITE);
        add(noE);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(yesE);
        existingGroup.add(noE);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String senior = null;
        if (yes.isSelected()) {
            senior = "yes";
        } else if (no.isSelected()) {
            senior = "no";
        }

        String exit = null;
        if (yesE.isSelected()) {
            exit = "yes";
        } else if (noE.isSelected()) {
            exit = "No";
        }

        String span = pan.getText().trim();
        String sadhar = adhar.getText().trim();

        try {
            if (span.equals("") || sadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN and Aadhar numbers are required");
            } else if (!span.matches("[A-Z0-9]+") || span.length() != 10) {
                JOptionPane.showMessageDialog(null, "Invalid PAN number. Please enter 10 characters consisting of uppercase letters and digits only.");
            } else if (!sadhar.matches("\\d{12}")) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhar number. Please enter 12 digits only.");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signup2 VALUES('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + sadhar + "','" + exit + "','" + senior + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup3(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        new Signup2("");
    }
}
