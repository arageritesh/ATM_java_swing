package bank.management.system;
import java.util.Random;
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class Signup1 extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, mobTextField,fnameTextField, emailTextField, addressTextField, stateTextField, cityTextField, pinTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    
    Signup1() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Student Registration ." + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel PersonalDetails = new JLabel("page 1: Personal_Details ");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        PersonalDetails.setBounds(290, 80, 400, 30);
        add(PersonalDetails);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        JLabel fname = new JLabel("Father Name");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        JLabel DOB = new JLabel("Date of Birth");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 240, 200, 30);
        add(DOB);

        JLabel Gender = new JLabel("Gender");
        Gender.setFont(new Font("Raleway", Font.BOLD, 20));
        Gender.setBounds(100, 290, 100, 30);
        add(Gender);

        JLabel email = new JLabel("Email");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 100, 30);
        add(email);

        JLabel marital = new JLabel("Married ?");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 100, 30);
        add(marital);

        JLabel address = new JLabel("Addresss");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 100, 30);
        add(address);

        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 100, 30);
        add(city);

        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 100, 30);
        add(state);

        JLabel pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 100, 30);
        add(pincode);
        
        JLabel mob = new JLabel("Mobile");
        mob.setFont(new Font("Raleway", Font.BOLD, 20));
        mob.setBounds(100, 640, 100, 30);
        add(mob);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 200, 30);
        add(fnameTextField);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 200, 30);
        add(emailTextField);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        dateChooser.setForeground(Color.RED);
        add(dateChooser);

        female = new JRadioButton("Female");
        female.setBounds(300, 290, 80, 30);
        add(female);

        male = new JRadioButton("Male");
        male.setBounds(450, 290, 60, 30);
        add(male);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        add(married);

        unmarried = new JRadioButton("unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        add(unmarried);

        other = new JRadioButton("other");
        other.setBounds(630, 390, 100, 30);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 690, 80, 30);
        next.addActionListener(this);
        add(next);
        
        mobTextField = new JTextField();
        mobTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        mobTextField.setBounds(300, 640, 400, 30);
        add(mobTextField);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    private boolean isValidAlphabet(String input) {
        String regex = "^[a-zA-Z ]+$";  // Allow alphabets and spaces
        return Pattern.matches(regex, input);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String DOB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String Gender = null;
        if (male.isSelected()) {
            Gender = "Male";
        } else if (female.isSelected()) {
            Gender = "Female";
        }

        String email = emailTextField.getText();

        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
         String mobile = mobTextField.getText();

        
        if (!isValidAlphabet(name) || !isValidAlphabet(fname)) {
            JOptionPane.showMessageDialog(null, "(Name or Father) name Use only alphabets.");
            return;
        }
         if (mobile.length()!=10) {
            JOptionPane.showMessageDialog(null, "Enter 10 digits mobile number");
            return;
        }

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                 Conn c = new Conn();
                 String query = "insert into signup1 values('" + formno + "','" + name + "','"
                         + fname + "','" + DOB + "','" + Gender + "','" + email + "','" + address + "','"
                        + marital + "','" + city + "','" + state + "','" + pin + "','" + mobile + "')";
                c.s.executeUpdate(query);
            }

            setVisible(false);
            new Signup2(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new Signup1();
    }
}
