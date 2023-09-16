package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddRooms extends JFrame implements ActionListener{
    JButton addroom,cancel;
    JComboBox combobed,cleancombo,availablecombo;
    JTextField tfprice,tfroom;
    AddRooms(){
        
    setLayout(null);
    JLabel heading = new JLabel("ADD ROOMS");
    heading.setFont(new Font("Tahoma", Font.BOLD,18));
    heading.setForeground(Color.blue);
    heading.setBounds(150, 20, 200, 20);
    add(heading);
    
    
    JLabel lblroomno = new JLabel("ROOM NO.");
    lblroomno.setFont(new Font("Tahoma", Font.PLAIN,16));
    lblroomno.setBounds(40, 80, 200, 30);
    add(lblroomno);
    
    tfroom = new JTextField();
    tfroom.setBounds(250,80,150,30);
    add(tfroom);
    
    
    JLabel lblavailable = new JLabel("AVAILABILITY");
    lblavailable.setFont(new Font("Tahoma", Font.PLAIN,16));
    lblavailable.setBounds(40, 130, 120, 30);
    add(lblavailable);
    
    String availableOptions[] = {"Available","Occupied"};
    availablecombo = new JComboBox(availableOptions);
    availablecombo.setBounds(250,130,150,30);
    availablecombo.setBackground(Color.white);
    add(availablecombo);
    
    JLabel lblclean = new JLabel("CLEANING STATUS");
    lblclean.setFont(new Font("Tahoma", Font.PLAIN,16));
    lblclean.setBounds(40, 180, 160, 30);
    add(lblclean);
    
    String cleanOptions[] = {"Clean","Dirty"};
    cleancombo = new JComboBox(cleanOptions);
    cleancombo.setBounds(250,180,150,30);
    cleancombo.setBackground(Color.white);
    add(cleancombo);
    
    JLabel lblprice  = new JLabel("PRICE");
    lblprice.setBounds(40,230,160,30);
    lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(lblprice);
    
    tfprice = new JTextField();
    tfprice.setBounds(250, 230, 150, 30);
    add(tfprice);
    
    JLabel lblbed = new JLabel("BED TYPE");
    lblbed.setBounds(40,280,160,30);
    lblbed.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(lblbed);
    
    String bedOptions[] = {"Single bed","Double bed"}; 
    combobed = new JComboBox(bedOptions);
    combobed.setBounds(250, 280, 160, 30);
    combobed.setBackground(Color.white);
    add(combobed);
    
    addroom = new JButton("ADD");
    addroom.setBounds(60, 340, 120, 30);
    addroom.setBackground(Color.BLUE);
    addroom.setForeground(Color.white);
    addroom.addActionListener(this);
    add(addroom);
    
    cancel = new JButton("CANCEL");
    cancel.setBounds(250, 340, 120, 30);
    cancel.setBackground(Color.BLUE);
    cancel.setForeground(Color.white);
    cancel.addActionListener(this);
    add(cancel);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(410,30,500,290);
    add(image);
    
    getContentPane().setBackground(Color.white);
    setBounds(330,200,940,470);
    setVisible(true);
   }
    
 public void actionPerformed(ActionEvent ae){
 if(ae.getSource() == addroom){
     String roomno = tfroom.getText();
     String availability = (String)availablecombo.getSelectedItem();
     String status = (String) cleancombo.getSelectedItem();
     String price = tfprice.getText();
     String type = (String)combobed.getSelectedItem();
     
     try{
         Conn conn  = new Conn();
         String str = "insert into room values('"+roomno+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
         
         conn.s.executeUpdate(str);
         JOptionPane.showMessageDialog(null, "New Room Added Successfully");
         setVisible(false);  
         
     } catch (Exception e){
     e.printStackTrace();
     }
     
 }
 else{
  setVisible(false);
 }
 }      
    
 public static void main(String[] args){

 new AddRooms();   
    
}  
}