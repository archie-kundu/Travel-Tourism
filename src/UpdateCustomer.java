import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {
    String username;
    JLabel labelusername,labelname;
    JButton add,back;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone,tfid,tfgender,tfname;
    JRadioButton rmale,rfemale; //buttons of choice
    UpdateCustomer(String username){
        this.username=username;
        setBounds(400,150,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        //heading
        JLabel text=new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        //username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        //id choice
        JLabel lblid=new JLabel("Id Type");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        comboid=new JComboBox(new String[] {"Passport","Aadhaar Card","Pan Card","Ration Card","Voter Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
//        tfid=new JTextField();
//        tfid.setBounds(220,90,150,25);
//        tfid.setBackground(Color.WHITE);
//        add(tfid);
        //fill id
        JLabel lblnumber=new JLabel("Id number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        tfnumber =new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        //name
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        tfname=new JTextField();
        tfname.setBounds(220,170,150,25);
        add(tfname);
        //gender
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        tfgender =new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);
        //country
        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        tfcountry =new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        //address
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        tfaddress =new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        //email
        JLabel lblemail=new JLabel("E-mail");
        lblemail.setBounds(30,330,150,25);
        add(lblemail);
        tfemail =new JTextField();
        tfemail.setBounds(220,330,150,25);
        add(tfemail);
        //phone
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);
        tfphone =new JTextField();
        tfphone.setBounds(220,370,150,25);
        add(tfphone);
        //add button
        add=new JButton("Update");
        add.setBounds(70,430,100,25);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        //back
        back=new JButton("Back");
        back.setBounds(220,430,100,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/profile.png"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420,40,400,400);
        add(image);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username='"+this.username+"'");
            while(rs.next()){
                labelusername.setText((rs.getString("Username")));
                comboid.setSelectedItem(rs.getString("Id"));
                tfnumber.setText(rs.getString("Number"));
                tfname.setText(rs.getString("Name"));
                tfgender.setText(rs.getString("Gender"));
                tfcountry.setText(rs.getString("Country"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id=(String) comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=tfgender.getText();
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            try{
                Conn c=new Conn();
                String query="update customer set Id='"+id+"',Number='"+number+"',Name='"+name+"',Gender='"+gender+"',Country='"+country+"',Address='"+address+"',Phone='"+phone+"',Email='"+email+"' where Username='"+this.username+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new UpdateCustomer("");
    }
}
