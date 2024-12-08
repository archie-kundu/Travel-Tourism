import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton signup,login,password,back;
    JTextField tfusername,tfpassword;
    Login()
    {
        //create frame
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        //panel for user icon
        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        //user icon
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,80,200,200);
        p1.add(image);
        //panel for elements
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        //username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        p2.add(lblusername);
        tfusername=new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        //password
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        p2.add(lblpassword);
        tfpassword=new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        //login button
        login=new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.setFocusable(false);
        login.addActionListener(this);
        p2.add(login);
        //sign-up button
        signup=new JButton("Sign Up");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.setFocusable(false);
        signup.addActionListener(this);
        p2.add(signup);
        //forget password button
        password=new JButton("Forgot Password?");
        password.setBounds(230,240,130,30);
        password.setForeground(Color.WHITE);
        password.setFocusable(false);
        password.setBorder(new LineBorder(new Color(133,193,233)));
        password.addActionListener(this);
        password.setBackground(new Color(133,193,233));
        p2.add(password);
        //back
        //forget password button
        back=new JButton("Back");
        back.setBounds(60,240,130,30);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.setBackground(new Color(133,193,233));
        back.addActionListener(this);
        p2.add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login)
        {
            String username=tfusername.getText();
            String password=tfpassword.getText();
            try {
                String query = "select * from account where password='" + password+ "' AND username='" + username + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(rs.getString("name"),username);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                    setVisible(false);
                    new Login();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }
        else if(ae.getSource()==back) {
            setVisible(false);
            new User();
        }
        else{
            setVisible(false);
            new ForgotPassword();
        }
    }
    public static void main(String[] args)
    {

        new Login();
    }
}
