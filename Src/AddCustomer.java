package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    JRadioButton radiofemale,radiomale;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JButton addcustomer,back;
    Choice roomno;
    JLabel checkintime;
    AddCustomer(){
        
        setLayout(null);
        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setBounds(70,10,300,30);
        heading.setFont(new Font("Raleway",Font.PLAIN,18));
        add(heading);
        heading.setForeground(Color.BLUE);
      
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 150, 20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblid);
        
        String options[] = {"Aadhar Card","Passport","Driving License","Voter-id Card","Ration Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(250, 80, 150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35, 120, 150, 20);
        lblnumber.setFont(new Font("RaleWay",Font.PLAIN,16));
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(250,120,150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,160,150,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(250,160,150,25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,200,150,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblgender);
        
        radiomale = new JRadioButton("Male");
        radiomale.setBounds(250,200,80,20);
        radiomale.setBackground(Color.white);
        radiomale.setFont( new Font("Raleway",Font.PLAIN,15));
        add(radiomale);
        
        radiofemale = new JRadioButton("Female");
        radiofemale.setBounds(330,200,80,20);
        radiofemale.setBackground(Color.white);
        radiofemale.setFont( new Font("Raleway",Font.PLAIN,15));
        add(radiofemale);
        
        ButtonGroup radiogender = new ButtonGroup();
        radiogender.add(radiomale);
        radiogender.add(radiofemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,240,150,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(250, 240, 150, 25);
        add(tfcountry);
        
        
        JLabel lblroomno =  new JLabel("Allocated Room Number");
        lblroomno.setBounds(35,280,180,20);
        lblroomno.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblroomno);
        
        
        roomno = new Choice();
        try{
            Conn conn = new Conn();
            String query = "Select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                roomno.add(rs.getString("room_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        roomno.setBounds(250, 280, 150, 25);
        roomno.setBackground(Color.white);
        add(roomno);
        
        JLabel lbltime = new JLabel("Check-In Time");
        lbltime.setBounds(35, 320, 150, 20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lbltime);
        
        Date date = new Date();
        checkintime = new JLabel(""+date);
        checkintime.setBounds(250, 320, 160, 25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,12));
        add(checkintime);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35, 360, 150, 20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(250, 360, 150, 25);
        add(tfdeposit);
        
        addcustomer = new JButton("Add Customer");
        addcustomer.setBounds(60, 420, 150, 25);
        addcustomer.setForeground(Color.WHITE);
        addcustomer.setBackground(Color.BLUE);
        addcustomer.setFont(new Font("Raleway",Font.PLAIN,16));
        addcustomer.addActionListener(this);
        add(addcustomer);
        
        back = new JButton("Back");
        back.setBounds(250, 420, 140, 25);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/customer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(390, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,10,390,480);
        add(image);
     
        getContentPane().setBackground(Color.white);
        setBounds(350,200,800,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        /*
        JComboBox comboid;
        JRadioButton radiofemale,radiomale;
        JTextField tfnumber,tfname,tfcountry,tfdeposit;
        JButton addcustomer,back;
        Choice roomno;
        JLabel checkintime;
     */   
        
        if(ae.getSource() == addcustomer){
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            
            if(radiomale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String room = roomno.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            
            try {
               String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
               String query2 = "update room set availability = 'Occupied' where room_no = '"+room+"'"; 
               
               Conn conn = new Conn();
               
               conn.s.executeUpdate(query);
               conn.s.executeUpdate(query2);
               
               JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
               
               setVisible(false);
               new Reception();
               
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
    new AddCustomer();
    }
}
