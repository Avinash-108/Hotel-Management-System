package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{
    JTextField tfroom,tfavailable,tfstatus,tfpaid,tfpending;
    Choice ccustomer;
    JButton check,update,back;
    UpdateRoom(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        text.setBounds(30,20,250,30);
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
        lblroom.setBounds(30, 130, 110, 20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(220, 130, 150, 25);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(30, 180, 100, 20);
        lblavailable.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblavailable);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(220, 180, 150, 25);
        add(tfavailable);
        
        JLabel lblstatus  = new JLabel("Cleaning Status");
        lblstatus.setBounds(30, 230, 150, 20);
        lblstatus.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblstatus);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(220, 230, 150, 25);
        add(tfstatus);
        
        check = new JButton("Check");
        check.setBounds(30, 300, 100, 30);
        check.setBackground(Color.BLUE);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(150, 300, 100, 30);
        update.setBackground(Color.BLUE);
        update.setForeground(Color.white);
        update.addActionListener(this); 
        add(update);
        
        back = new JButton("Back");
        back.setBounds(270, 300, 100, 30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.white);
        back.addActionListener(this);  
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/room.jpg"));
        Image i2 = i1.getImage().getScaledInstance(480, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,480,300);
        add(image);
        
      setBounds(300,200,900,400);
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
            
               }
               ResultSet rs2 =c.s.executeQuery("select * from room where room_no = '"+tfroom.getText()+"'");
               while(rs2.next()){
                  tfavailable.setText(rs2.getString("availability"));
                  tfstatus.setText(rs2.getString("cleaning_status"));
                }
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
           
            
            try{
               Conn c  = new Conn();
               c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status = '"+status+"' where room_no = '"+room+"'" );
               JOptionPane.showMessageDialog(null, "Data Updated Successfully");
               
            } catch(Exception e){
            
            }
        
        }
        else {
          setVisible(false);
          new Reception();
        }
        
   }
    
        public static void main(String[] args){
        new UpdateRoom();
    }
}
