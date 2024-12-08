import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel[] label=new JLabel[]{l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
    JLabel caption;
    Thread t1;
    public void run(){
        String[] text=new String[]{"Happy Morning","The Sangrilla","The Four Seasons","Raddisson Blu Hotel","The Classic Hotel","The Bay Club","Betelnut Resort","Dwarika's Hotel","Hotel City Centre","Zangmolee Baam"};
        String[] loc=new String[]{"Ladakh","Manali","Mumbai","Delhi","Assam","Andaman Islands","Meghalaya","Kathmandu","Jaipur","Sikkim"};
        try{
            for(int i=0;i<=9;i++){
                label[i].setVisible(true);
                caption.setText(text[i]+"-"+loc[i]);
                Thread.sleep(2500);
                label[i].setVisible(false);
                if(i==9)
                    i=-1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    CheckHotels() {
        setBounds(400, 120, 800, 600);
        //name of hotels
        caption=new JLabel();
        caption.setBounds(50,500,1000,70);
        caption.setFont(new Font("Tahoma",Font.PLAIN,40));
        caption.setForeground(Color.WHITE);
        add(caption);
        ImageIcon i1 = null, i2 = null, i3 = null, i4 = null, i5 = null, i6 = null, i7 = null, i8 = null, i9 = null, i10 = null;
        ImageIcon[] i_image = new ImageIcon[]{i1, i2, i3, i4, i5, i6, i7, i8, i9, i10};
        Image j1 = null, j2 = null, j3 = null, j4 = null, j5 = null, j6 = null, j7 = null, j8 = null, j9 = null, j10 = null;
        Image[] j_image = new Image[]{j1, j2, j3, j4, j5, j6, j7, j8, j9, j10};
        ImageIcon k1 = null, k2 = null, k3 = null, k4 = null, k5 = null, k6 = null, k7 = null, k8 = null, k9 = null, k10 = null;
        ImageIcon[] k_image = new ImageIcon[]{k1, k2, k3, k4, k5, k6, k7, k8, k9, k10};
        for (int i = 0; i < 10; i++) {
            i_image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/hot " + (i + 1) + ".jpg"));
            j_image[i] = i_image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            k_image[i] = new ImageIcon(j_image[i]);
            label[i] = new JLabel(k_image[i]);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);

            t1=new Thread(this);
            t1.start();
            setVisible(true);

        }
    }
    public static void main(String[] args){
        new CheckHotels();
    }
}
