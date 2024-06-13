package Fsec;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SecureType extends JFrame implements ActionListener{
	JLabel securetype;
    JButton lock, unlock;
    

    public SecureType(){
        Font f2 = new Font("Comic Sans", Font.BOLD, 45);
        Font f3 = new Font("Segoe UI", Font.BOLD, 18);

        new JFrame();
        setSize(650, 350);
        setTitle("Secure Type");
        setLayout(null);

        securetype = new JLabel("SECURE TYPE");
        securetype.setBounds(100, 40, 450, 45);
        securetype.setHorizontalAlignment(JLabel.CENTER);
        securetype.setForeground(new Color(0,144,160));
        securetype.setFont(f2);
        add(securetype);
        
        
		
        
        

        lock = new JButton("LOCK");
        lock.setBounds(130, 150, 150, 60);
       lock. setBackground(new Color(0,144,160));
        lock.setForeground(Color.WHITE);
        lock.setFont(f3);
        lock.addActionListener(this);
        add(lock);

        unlock = new JButton("UNLOCK");
        unlock.setBounds(350, 150, 150, 60);
        unlock.setBackground(new Color(0,144,160));
        unlock.setForeground(Color.WHITE);
        unlock.setFont(f3);
        unlock.addActionListener(this);
        add(unlock);

       

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lock) {
             new lock();
            dispose(); 
        } else if (e.getSource() == unlock) {
             new unlock();
            dispose();
        }
    }

    public static void main(String[] args) {
        new SecureType();
    }
}
