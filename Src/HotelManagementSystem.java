package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem(){
        setBounds(100,100,1366,600); //x = 100 y=100 w.r.t screen, default location is top left, //width and height is of frame
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotelperfect.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,600); // x=0 y=0 with respect to frame, default is top left,
        add(image);                             //width and height is of frame
   
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(50, 50, 1000, 90);
        text.setForeground(Color.white);
        text.setFont(new Font("verdana", Font.PLAIN, 50));
        image.add(text);
       
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 100, 30);
        next.setBackground(Color.black);
        next.setForeground(Color.white); 
        next.addActionListener(this);
        next.setFont(new Font("verdana", Font.PLAIN, 20));
        image.add(next);
        setVisible(true);
     
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e) {
            e.printStackTrace();
            }
            text.setVisible(true);
            
            try{
                Thread.sleep(500);
            }catch(Exception e) {
            e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
