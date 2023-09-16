package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;
public class Checkout extends JFrame implements ActionListener{
    
    JLabel lblroomno,lblcheckintime,lblcheckouttime;
    Choice ccustomer;
    JButton back,checkout;
    Checkout(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30); 
        text.setFont(new Font("Raleway", Font.PLAIN,20));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 25);
        add(ccustomer);
        
        
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);
        
        lblroomno = new JLabel();
        lblroomno.setBounds(150,130,100,30);
        add(lblroomno);
        
        JLabel lblcheckin = new JLabel("Check-in Time");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,180,150,30);
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 230, 150, 30);
        add(lblcheckouttime);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLUE);
        checkout.setForeground(Color.white);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.white);
        back.setBounds(180, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/checkout.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 30, 400, 300);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomno.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
             
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        setBounds(300,200,800,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkout) {
           String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
           String query2 = "update room set availability = 'Available' where room_no = '"+lblroomno+"'";
           
           try{
              Conn c = new Conn();
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              
              JOptionPane.showMessageDialog(null, "Checkout done");
              setVisible(false);
              new Reception();
              
           } catch(Exception e){
               e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
    
    
    
    
    public static void main(String[] args){
        new Checkout();
    }
}
