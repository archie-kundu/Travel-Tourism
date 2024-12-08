import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonalDetails,updatePersonalDetails,viewPersonalDetails,deletePersonalDetails,checkpackages,bookpackages,viewpackages,viewhotels,bookhotels,viewbookedhotels,destinations,payments,calculator,notepad,about;
    Dashboard(String username) {
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
        //add personal details
        addPersonalDetails=new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,48);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.setFocusable(false);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        //update personal details
        updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,48,300,48);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.setFocusable(false);
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        //view personal details
        viewPersonalDetails=new JButton("View Details");
        viewPersonalDetails.setBounds(0,96,300,48);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.setFocusable(false);
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        //delete personal details
        deletePersonalDetails=new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,144,300,48);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,35));
        deletePersonalDetails.setFocusable(false);
        p2.add(deletePersonalDetails);
        //check packages
        checkpackages=new JButton("Check Packages");
        checkpackages.setBounds(0,192,300,48);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,100));
        checkpackages.setFocusable(false);
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        //book packages
        bookpackages=new JButton("Book Packages");
        bookpackages.setBounds(0,240,300,48);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.WHITE);
        bookpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,105));
        bookpackages.setFocusable(false);
        bookpackages.addActionListener(this);
        p2.add(bookpackages);
        //view packages
        viewpackages=new JButton("View Packages");
        viewpackages.setBounds(0,288,300,48);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackages.setMargin(new Insets(0,0,0,105));
        viewpackages.setFocusable(false);
        viewpackages.addActionListener(this);
        p2.add(viewpackages);
        //view hotels
        viewhotels=new JButton("View Hotels");
        viewhotels.setBounds(0,336,300,48);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,130));
        viewhotels.setFocusable(false);
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        //book hotels
        bookhotels=new JButton("Book Hotels");
        bookhotels.setBounds(0,384,300,48);
        bookhotels.setBackground(new Color(0,0,102));
        bookhotels.setForeground(Color.WHITE);
        bookhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotels.setMargin(new Insets(0,0,0,130));
        bookhotels.setFocusable(false);
        bookhotels.addActionListener(this);
        p2.add(bookhotels);
        //view booked hotels
        viewbookedhotels=new JButton("View Booked Hotels");
        viewbookedhotels.setBounds(0,432,300,48);
        viewbookedhotels.setBackground(new Color(0,0,102));
        viewbookedhotels.setForeground(Color.WHITE);
        viewbookedhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookedhotels.setMargin(new Insets(0,0,0,60));
        viewbookedhotels.setFocusable(false);
        viewbookedhotels.addActionListener(this);
        p2.add(viewbookedhotels);
        //destinations
        destinations=new JButton("Destinations");
        destinations.setBounds(0,480,300,48);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,125));
        destinations.setFocusable(false);
        destinations.addActionListener(this);
        p2.add(destinations);
        //payments
        payments=new JButton("Payments");
        payments.setBounds(0,528,300,48);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,145));
        payments.setFocusable(false);
        payments.addActionListener(this);
        p2.add(payments);
        //calculator
        calculator=new JButton("Calculator");
        calculator.setBounds(0,576,300,48);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,145));
        calculator.setFocusable(false);
        calculator.addActionListener(this);
        p2.add(calculator);
        //notepad
        notepad=new JButton("Notepad");
        notepad.setBounds(0,624,300,48);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,155));
        notepad.setFocusable(false);
        notepad.addActionListener(this);
        p2.add(notepad);
        //about
        about=new JButton("About");
        about.setBounds(0,672,300,48);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,175));
        about.setFocusable(false);
        about.addActionListener(this);
        p2.add(about);
        //background image
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5= i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel bgimage=new JLabel(i6);
        bgimage.setBounds(0,0,1650,1000);
        add(bgimage);
        //
        JLabel text=new JLabel("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        bgimage.add(text);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==addPersonalDetails)
            new AddCustomer(username);
        else if (ae.getSource()==viewPersonalDetails)
            new ViewCustomer(username);
        else if (ae.getSource()==updatePersonalDetails)
            new UpdateCustomer(username);
        else if (ae.getSource()==checkpackages)
            new CheckPackages();
        else if (ae.getSource()==bookpackages)
            new BookPackages(username);
        else if (ae.getSource()==viewpackages)
            new ViewPackages(username);
        else if (ae.getSource()==viewhotels)
            new CheckHotels();
        else if (ae.getSource()==destinations)
            new Destinations();
        else if (ae.getSource()==bookhotels)
            new BookHotels(username);
        else if (ae.getSource()==viewbookedhotels)
            new ViewBookedHotels(username);
        else if (ae.getSource()==payments)
            new Payment(username);
        else if (ae.getSource()==calculator)
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        else if (ae.getSource()==notepad)
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        else if (ae.getSource()==about)
            new About();
        else
            new Delete(username);

    }
    public static void main(String[] args) {
        new Dashboard("");
    }
}
