package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    Choice ccustomer;
    JButton check,update,back;
    UpdateCheck(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
        add(text);
        
        JLabel lblid = new JLabel("Customer id");
        lblid.setBounds(30, 80, 100, 20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(220, 80, 150, 30);
        add(ccustomer);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
             
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 110, 20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(220, 120, 150, 25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 100, 20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 160, 150, 25);
        add(tfname);
        
        JLabel lblcheckin  = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 200, 100, 20);
        lblcheckin.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(220, 200, 150, 25);
        add(tfcheckin);
        
        JLabel lblpaid  = new JLabel("Amount Paid");
        lblpaid.setBounds(30, 240, 100, 20);
        lblpaid.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(220, 240, 150, 25);
        add(tfpaid);
        
        JLabel lblpending  = new JLabel("Amount Pending");
        lblpending.setBounds(30, 280, 100, 20);
        lblpending.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(220, 280, 150, 25);
        add(tfpending);
        
        check = new JButton("Check");
        check.setBounds(30, 340, 100, 30);
        check.setBackground(Color.BLUE);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(150, 340, 100, 30);
        update.setBackground(Color.BLUE);
        update.setForeground(Color.white);
        update.addActionListener(this); 
        add(update);
        
        back = new JButton("Back");
        back.setBounds(270, 340, 100, 30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.white);
        back.addActionListener(this);  
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/check.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        
        
    
        setBounds(300,200,980,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try {
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                  tfroom.setText(rs.getString("room"));
                  tfname.setText(rs.getString("name"));
                  tfcheckin.setText(rs.getString("checkintime"));
                  tfpaid.setText(rs.getString("deposit"));
                  
                  
               
               }
               ResultSet rs2 =c.s.executeQuery("select * from room where room_no = '"+tfroom.getText()+"'");
               while(rs2.next()){
                     String price = rs2.getString("price");
                     int amountPaid = Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                     tfpending.setText("" + amountPaid);
                }
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();
            
            try{
               Conn c  = new Conn();
               c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"',checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"'");
               JOptionPane.showMessageDialog(null, "Data Updated Successfully");
               setVisible(false);
               new Reception();
               
            } catch(Exception e){
            
            }
        
        }
        else {
          setVisible(false);
          new Reception();
        }
        
   }
    
   
    public static void main(String[] args){
        new UpdateCheck();
    }
}
