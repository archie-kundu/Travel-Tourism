import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    String username;
    JLabel labelusername,labelname;
    JComboBox comboid; //drop down
    JButton add,back;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone;
    JRadioButton rmale,rfemale; //buttons of choice
    AddCustomer(String username){
        this.username=username;
        setBounds(350,150,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
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
        labelname=new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        //gender
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        rmale=new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        rfemale=new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        ButtonGroup bg=new ButtonGroup(); //to allow choosing 1 option
        bg.add(rmale);
        bg.add(rfemale);
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
        add=new JButton("Add");
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
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.png"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420,40,400,400);
        add(image);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from account where username='"+this.username+"'");
            while(rs.next()){
                labelusername.setText((rs.getString("Username")));
                labelname.setText((rs.getString("Name")));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=labelusername.getText();
            String id=(String) comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender=null;
            if(rmale.isSelected())
            {
                gender="Male";
            }
            else
                gender="Female";
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            try{
                Conn c=new Conn();
                String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
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
        new AddCustomer("");
    }
}
