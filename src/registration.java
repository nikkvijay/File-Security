import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class registration extends JFrame implements ActionListener {
    JLabel registrationl, emaill;
    JButton sendb;
    JComboBox<String> cb1;
    JTextField emailtf;
    static Pinmail otpMailer = new Pinmail(); // Shared Pinmail instance

    public registration() {
        Font f2 = new Font("Comic Sans", Font.BOLD, 45);
        Font f3 = new Font("Calibri", Font.PLAIN, 18);

        setSize(650, 450);
        setTitle("File Secure");
        setLayout(null);

        registrationl = new JLabel("REGISTRATION");
        registrationl.setBounds(100, 40, 450, 45);
        registrationl.setHorizontalAlignment(JLabel.CENTER);
        registrationl.setForeground(Color.BLACK);
        registrationl.setFont(f2);
        add(registrationl);

        emaill = new JLabel("Email:");
        emaill.setBounds(140, 130, 100, 45);
        emaill.setForeground(Color.BLACK);
        emaill.setFont(f3);
        add(emaill);

        emailtf = new JTextField();
        emailtf.setBounds(190, 135, 170, 40);
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
        cb1.setBounds(360, 135, 100, 39);
        add(cb1);

        sendb = new JButton("SEND");
        sendb.setBounds(250, 250, 150, 60);
        sendb.setFont(f3);
        sendb.addActionListener(this);
        add(sendb);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new login();  // Open the login frame
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendb) {
            String email = emailtf.getText() + cb1.getSelectedItem();
            if (otpMailer.isEmailRegistered(email)) {
                JOptionPane.showMessageDialog(this, "Email is already registered.");
            } else {
                try {
                    otpMailer.sendOTP(email);
                    login.registeredEmail = email;
                    JOptionPane.showMessageDialog(this, "OTP sent to " + email);
                } catch (MessagingException ex) {
                    JOptionPane.showMessageDialog(this, "Error sending OTP: " + ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new registration();
    }
}
