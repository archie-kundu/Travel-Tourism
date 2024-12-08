import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class AdminDashboard extends JFrame implements ActionListener {
    JButton addHotel,updateAdminDetails,viewAdminDetails;
    int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    String username;
    AdminDashboard(String username){
        this.username=username;
        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 75);
        add(p1);
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2= i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(5,0,80,80);
        p1.add(image);
        //heading
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80,15,300,50);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        p1.add(heading);
        //side panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 75, 300, 900);
        add(p2);
        addHotel = new JButton("Add Hotels");
        addHotel.setBounds(0,0,300,50);
        addHotel.setBackground(new Color(0,0,102));
        addHotel.setForeground(Color.WHITE);
        addHotel.setFont(new Font("Tahoma", Font.PLAIN,20));
        addHotel.setMargin(new Insets(0,0,0,130));
        addHotel.setFocusable(false);
        addHotel.addActionListener(this);
        p2.add(addHotel);

        updateAdminDetails = new JButton("Update Admin Details");
        updateAdminDetails.setBounds(0,50,300,50);
        updateAdminDetails.setBackground(new Color(0,0,102));
        updateAdminDetails.setForeground(Color.WHITE);
        updateAdminDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        updateAdminDetails.setMargin(new Insets(0,0,0,35));
        updateAdminDetails.setFocusable(false);
        updateAdminDetails.addActionListener(this);
        p2.add(updateAdminDetails);

        viewAdminDetails = new JButton("View Admin Details");
        viewAdminDetails.setBounds(0,100,300,50);
        viewAdminDetails.setBackground(new Color(0,0,102));
        viewAdminDetails.setForeground(Color.WHITE);
        viewAdminDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewAdminDetails.setMargin(new Insets(0,0,0,60));
        viewAdminDetails.setFocusable(false);
        viewAdminDetails.addActionListener(this);
        p2.add(viewAdminDetails);

        //background image
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/admin_dashboard.jpg"));
        Image i5= i4.getImage().getScaledInstance(screenWidth,screenHeight,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel bgimage=new JLabel(i6);
        bgimage.setBounds(0,0,screenWidth,screenHeight);
        add(bgimage);

        JLabel text=new JLabel("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        bgimage.add(text);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addHotel){
            new AddHotel();
        }
        else if(ae.getSource() == viewAdminDetails){
            new ViewAdmin(username);
        }
        else if(ae.getSource() == updateAdminDetails){
            new UpdateAdmin(username);
        }
    }
    public static void main(String[] args){
        new AdminDashboard("");
    }
}