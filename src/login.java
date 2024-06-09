import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {
    JLabel filesecurel, pinl;
    JButton loginb, registrationb;
    JTextField pintf;
    static Pinmail otpMailer = registration.otpMailer; // Shared Pinmail instance
    static String registeredEmail; // Store the email of the registered user

    public login() {
        Font f2 = new Font("Comic Sans", Font.BOLD, 45);
        Font f3 = new Font("Calibri", Font.PLAIN, 18);

        setSize(650, 450);
        setTitle("File Secure");
        setLayout(null);

        filesecurel = new JLabel("FILE SECURE");
        filesecurel.setBounds(100, 40, 450, 45);
        filesecurel.setHorizontalAlignment(JLabel.CENTER);
        filesecurel.setForeground(Color.BLACK);
        filesecurel.setFont(f2);
        add(filesecurel);

        pinl = new JLabel("PIN :");
        pinl.setBounds(190, 150, 200, 45);
        pinl.setForeground(Color.BLACK);
        pinl.setFont(f3);
        add(pinl);

        pintf = new JTextField();
        pintf.setBounds(250, 155, 150, 40);
        add(pintf);

        loginb = new JButton("Login");
        loginb.setBounds(130, 250, 150, 60);
        loginb.setFont(f3);
        loginb.addActionListener(this);
        add(loginb);

        registrationb = new JButton("Registration");
        registrationb.setBounds(350, 250, 150, 60);
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
