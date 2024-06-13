package Fsec;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class login extends JFrame implements ActionListener {
    JLabel filesecurel, pinl,emaill;
    JButton loginb, registrationb;
    JTextField pintf,emailtf;
    JComboBox<String> cb1;
    static Pinmail otpMailer = registration.otpMailer; // Shared Pinmail instance
    static String registeredEmail; // Store the email of the registered user

    public login() {
        Font f2 = new Font("Comic Sans", Font.BOLD, 45);
        Font f3 = new Font("Segoe UI", Font.BOLD, 18);

        setSize(650, 450);
        setTitle("Login");
        setLayout(null);

        filesecurel = new JLabel("FILE SECURE");
        filesecurel.setBounds(100, 40, 450, 45);
        filesecurel.setHorizontalAlignment(JLabel.CENTER); 
        filesecurel.setForeground(new Color(0,144,160));
        filesecurel.setFont(f2);
        add(filesecurel);
        
        emaill = new JLabel("Email:");
        emaill.setBounds(160, 130, 100, 45);
        emaill.setForeground(Color.BLACK);
        emaill.setFont(f3);
        add(emaill);

        emailtf = new JTextField();
        emailtf.setBounds(220, 135, 170, 40);
        emailtf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char ch = ke.getKeyChar();
                if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_SPACE || ch == '@' || ch == '.')) {
                    getToolkit().beep();
                    ke.consume();
                }
            }
        });
        add(emailtf);

        String s1[] = {"@gmail.com", "@yahoo.com", "@rediffmail.com", "@outlook.com", "@msn.co.in"};
        cb1 = new JComboBox<String>(s1);
        cb1.setBounds(390, 135, 100, 38);
        add(cb1);

        pinl = new JLabel("Pin:");
        pinl.setBounds(170, 205, 200, 45);
        pinl.setForeground(Color.BLACK);
        pinl.setFont(f3);
        add(pinl);

        pintf = new JTextField();
        pintf.setBounds(220,210, 150, 40);
        add(pintf);

        loginb = new JButton("LOGIN");
        loginb.setBounds(130, 300, 150, 60);
        loginb.setBackground(new Color(0,144,160));
        loginb.setForeground(Color.WHITE);
        loginb.setFont(f3);
        loginb.addActionListener(this);
        add(loginb);

        registrationb = new JButton("REGISTRATION");
        registrationb.setBounds(350, 300, 170, 60);
        registrationb.setBackground(new Color(0,144,160));
        registrationb.setForeground(Color.WHITE);
        registrationb.setFont(f3);
        registrationb.addActionListener(this);
        add(registrationb);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginb) {
            String pin = pintf.getText();
            if (otpMailer.verifyOTP(registeredEmail, pin)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new SecureType();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid PIN.");
            }
        } else if (e.getSource() == registrationb) {
            new registration();
            dispose();
        }
    }

    public static void main(String[] args) {
        
        registeredEmail = "projectsystem21@gmail.com"; 
        new login();
    }
}
