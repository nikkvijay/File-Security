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
import javax.swing.JTextField;

public class lock extends JFrame implements ActionListener {
    JLabel lockl, filel, emaill;
    JButton sendb,browseb;
    JComboBox<Object> cb1;
    JTextField filetf, emailtf;

    public lock() {
        Font f2 = new Font("Comic Sans", Font.BOLD, 45);
        Font f3 = new Font("Calibri", Font.PLAIN, 18);

        setSize(650, 500);
        setTitle("Lock");
        setLayout(null);

        lockl = new JLabel("LOCK");
        lockl.setBounds(100, 40, 450, 45);
        lockl.setHorizontalAlignment(JLabel.CENTER);
        lockl.setForeground(Color.BLACK);
        lockl.setFont(f2);
        add(lockl);

        filel = new JLabel("File:");
        filel.setBounds(130, 130, 50, 45);
        filel.setForeground(Color.BLACK);
        filel.setFont(f3);
        add(filel);

        filetf = new JTextField();
        filetf.setBounds(190, 135, 210, 40);
        add(filetf);
        
        browseb = new JButton("Browse");
        browseb.setBounds(400, 135, 100, 40);
        browseb.setFont(f3);
        browseb.addActionListener(this);
        add(browseb);

        emaill = new JLabel("Email:");
        emaill.setBounds(130, 200, 200, 45);
        emaill.setForeground(Color.BLACK);
        emaill.setFont(f3);
        add(emaill);

        emailtf = new JTextField();
        emailtf.setBounds(190, 200, 210, 40);
        emailtf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char ch = ke.getKeyChar();
                if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_SPACE)) {
                    lockl.getToolkit().beep();
                    ke.consume();
                }
            }
        });
        add(emailtf);

        String s1[] = {"@gmail.com", "@yahoo.com", "@rediffmail.com", "@outlook.com", "@msn.co.in"};
        cb1 = new JComboBox<Object>(s1);
        cb1.setBounds(400, 200, 100, 40);
        add(cb1);

        sendb = new JButton("SEND");
        sendb.setBounds(250, 290, 150, 60);
        sendb.setFont(f3);
        sendb.addActionListener(this);
        add(sendb);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendb) {
        	SecureType lp = new SecureType();
            dispose(); 
        }
    }

    public static void main(String[] args) {
        new lock();
    }
}
