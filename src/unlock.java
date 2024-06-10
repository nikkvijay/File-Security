import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class unlock extends JFrame implements ActionListener {
    JLabel unlockl, filel, pinl;
    JButton unlockb, browseb;
    JTextField filetf, pintf;
    JFrame unlock;

    public unlock() {
        Font f2 = new Font("Comic Sans", Font.BOLD, 45);
        Font f3 = new Font("Calibri", Font.PLAIN, 18);

        setSize(650, 500);
        setTitle("Unlock");
        setLayout(null);

        unlockl = new JLabel("UNLOCK");
        unlockl.setBounds(100, 40, 450, 45);
        unlockl.setHorizontalAlignment(JLabel.CENTER);
        unlockl.setForeground(Color.BLACK);
        unlockl.setFont(f2);
        add(unlockl);

        filel = new JLabel("File:");
        filel.setBounds(130, 130, 50, 45);
        filel.setForeground(Color.BLACK);
        filel.setFont(f3);
        add(filel);

        filetf = new JTextField();
        filetf.setBounds(190, 135, 210, 40);
        add(filetf);
        
        browseb = new JButton("Browse");
        browseb.setBounds(400, 135, 100, 39);
        browseb.setFont(f3);
        browseb.addActionListener(this);
        add(browseb);

        pinl = new JLabel("Pin:");
        pinl.setBounds(130, 200, 50, 45);
        pinl.setForeground(Color.BLACK);
        pinl.setFont(f3);
        add(pinl);

        pintf = new JTextField();
        pintf.setBounds(190, 200, 210, 40);
        pintf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char ch = ke.getKeyChar();
                if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE) {
                    getToolkit().beep();
                    ke.consume();
                }
            }
        });
        add(pintf);
        
        unlockb = new JButton("UNLOCK");
        unlockb.setBounds(250, 290, 150, 60);
        unlockb.setFont(f3);
        unlockb.addActionListener(this);
        add(unlockb);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	if(obj==browseb){
        	JFileChooser jfc = new JFileChooser(); 
            int val = jfc.showOpenDialog(unlock);
            if(val == 0)
             {
                File path = jfc.getSelectedFile();
                filetf.setText(path.getAbsolutePath()); 
            }
        } else if (e.getSource() == unlockb) {
            String filePath = filetf.getText();
            String pin = pintf.getText();
            
            System.out.println("Unlock button clicked with file: " + filePath + " and pin: " + pin);
            
        }
    }

    public static void main(String[] args) {
        new unlock();
    }
}
