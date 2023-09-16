package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener{
    JButton adddriver,cancel;
    JComboBox  availcombo,gendercombo;
    JTextField tfcompany,tfname,tfage,tfmodel,tflocation;
    AddDriver(){
        
    setLayout(null);
    
    JLabel heading = new JLabel("ADD DRIVER");
    heading.setFont(new Font("Tahoma", Font.BOLD,18));
    heading.setForeground(Color.blue);
    heading.setBounds(150, 0, 200, 20);
    add(heading);
    
    
    JLabel lblname = new JLabel("NAME");
    lblname.setFont(new Font("Tahoma", Font.PLAIN,16));
    lblname.setBounds(40, 45, 200, 30);
    add(lblname);
    
    tfname = new JTextField();
    tfname.setBounds(250,45,150,30);
    add(tfname);
    
    
    JLabel lblage = new JLabel("AGE");
    lblage.setFont(new Font("Tahoma", Font.PLAIN,16));
    lblage.setBounds(40, 90, 120, 30);
    add(lblage);
    
    
    tfage = new JTextField();
    tfage.setBounds(250,90,150,30);
    add(tfage);
    
    JLabel lblgender = new JLabel("GENDER");
    lblgender.setFont(new Font("Tahoma", Font.PLAIN,16));
    lblgender.setBounds(40, 135, 160, 30);
    add(lblgender);
    
    String ageOptions[] = {"Male","Female"};
    gendercombo = new JComboBox(ageOptions);
    gendercombo.setBounds(250,135,150,30);
    gendercombo.setBackground(Color.white);
    add(gendercombo);
    
    
    JLabel lblcar  = new JLabel("CAR COMPANY");
    lblcar.setBounds(40,180,160,30);
    lblcar.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(lblcar);
    
    tfcompany = new JTextField();
    tfcompany.setBounds(250, 180, 150, 30);
    add(tfcompany);
    
    JLabel lblmodel = new JLabel("CAR MODEL");
    lblmodel.setBounds(40,225,160,30);
    lblmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(lblmodel);
    
    
    tfmodel = new JTextField();
    tfmodel.setBounds(250, 225, 150, 30);
    add(tfmodel);
    
    JLabel lblavailable = new JLabel("AVAILABILITY");
    lblavailable.setBounds(40,270,160,30);
    lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(lblavailable);
    
    String availableOptions[] = {"Available","Not Available"};
    availcombo = new JComboBox(availableOptions);
    availcombo.setBounds(250,270,150,30);
    availcombo.setBackground(Color.white);
    add(availcombo);
    
    JLabel lbllocation = new JLabel("LOCATION");
    lbllocation.setBounds(40,315,160,30);
    lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(lbllocation);
    
    
    tflocation = new JTextField();
    tflocation.setBounds(250, 315, 150, 30);
    add(tflocation); 
    
    
    
    adddriver = new JButton("ADD");
    adddriver.setBounds(60, 370, 120, 30);
    adddriver.setBackground(Color.BLUE);
    adddriver.setForeground(Color.white);
    adddriver.addActionListener(this);
    add(adddriver);
    
    cancel = new JButton("CANCEL");
    cancel.setBounds(250, 370, 120, 30);
    cancel.setBackground(Color.BLUE);
    cancel.setForeground(Color.white);
    cancel.addActionListener(this);
    add(cancel);
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/driver2.png"));
    Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(450,10,500,400);
    add(image);
    
     
    
    
   
    
    
    getContentPane().setBackground(Color.white);
    setBounds(300,200,980,470);
    setVisible(true);
    
    
 
    
    
    
    }
    
    
    
  
 

 public void actionPerformed(ActionEvent ae){
 if(ae.getSource() == adddriver){
     String name = tfname.getText();
     String age = tfage.getText();
     String gender = (String)gendercombo.getSelectedItem();
     String company = tfcompany.getText();
     String model = tfmodel.getText();
     String availability = (String)availcombo.getSelectedItem();
     String location = tflocation.getText();
   
     
     try{
         Conn conn  = new Conn();
         String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+availability+"','"+location+"')";
         
         conn.s.executeUpdate(str);
         JOptionPane.showMessageDialog(null, "Driver Added Successfully");
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

 new AddDriver();   
    
}  
}