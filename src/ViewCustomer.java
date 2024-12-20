import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;
    ViewCustomer(String username){
        setBounds(350,100,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,110,150,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(220,230,150,25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,290,150,25);
        add(lblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(220,290,150,25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(460,50,150,25);
        add(lblcountry);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(650,50,150,25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(460,110,150,25);
        add(lbladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(650,110,150,25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(460,170,150,25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(650,170,150,25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(460,230,150,25);
        add(lblemail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(650,230,200,25);
        add(labelemail);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(375,350,100,30);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,400,600,200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(600,400,600,200);
        add(image1);

        try{
            Conn c= new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("Username"));
                labelid.setText(rs.getString("Id"));
                labelnumber.setText(rs.getString("Number"));
                labelname.setText(rs.getString("Name"));
                labelgender.setText(rs.getString("Gender"));
                labelcountry.setText(rs.getString("Country"));
                labeladdress.setText(rs.getString("Address"));
                labelphone.setText(rs.getString("Phone"));
                labelemail.setText(rs.getString("Email"));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
        new ViewCustomer("");
    }
}