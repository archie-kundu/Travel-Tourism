import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class User extends JFrame implements ActionListener{
    JRadioButton ruser, radmin;
    ImageIcon userIcon,adminIcon;

    User() {
        //create frame
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        // Load images
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/user.png"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        userIcon=new ImageIcon(i2);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/admin.png"));
        Image i5= i4.getImage().getScaledInstance(100,105,Image.SCALE_DEFAULT);
        adminIcon=new ImageIcon(i5);


        // Create a label
        JLabel lbllabel = new JLabel("Choose Login Type");
        lbllabel.setBackground(Color.WHITE);
        lbllabel.setFont(new Font("Arial", Font.BOLD, 18));
        lbllabel.setBounds(350, 50, 200, 30);
        add(lbllabel);

        // Create radio buttons
        ruser = new JRadioButton();
        ruser.setBounds(200, 150, 200, 100);
        ruser.setBackground(Color.WHITE);
        ruser.addActionListener(this);
        ruser.setIcon(userIcon); // Set the icon
        JLabel t1=new JLabel("USER");
        t1.setForeground(Color.BLACK);
        t1.setBounds(235,250,200,20);
        add(t1);
        add(ruser);
        radmin = new JRadioButton();
        radmin.setBounds(550, 150, 200, 100);
        radmin.setBackground(Color.WHITE);
        radmin.addActionListener(this);
        radmin.setIcon(adminIcon); // Set the icon
        JLabel t2=new JLabel("ADMIN");
        t2.setForeground(Color.BLACK);
        t2.setBounds(585,250,200,20);
        add(t2);
        add(radmin);
        // Group the radio buttons
        ButtonGroup bg = new ButtonGroup();
        bg.add(ruser);
        bg.add(radmin);
        setVisible(true);

        }
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == ruser) {
                new Login();
            } else {
                new Admin();
            }
            setVisible(false);
        }
    public static void main(String[] args) {
        new User();
    }
}
