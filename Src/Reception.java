package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener{
    JButton rooms,department,employee,managerinfo,customerinfo,logout;
    JButton  roomstatus,newCustomer,roomsearch,update,checkout,pickup;
    Reception(){
    getContentPane().setBackground(Color.white);
    setLayout(null);
    
    
    newCustomer = new JButton("New Customer Form");
    newCustomer.setBounds(30,30,200,30);
    newCustomer.setForeground(Color.white);
    newCustomer.setBackground(Color.blue);
    newCustomer.setFont(new Font("Raleway",Font.PLAIN,16));
    newCustomer.addActionListener(this);
    add(newCustomer);
    
    
    rooms = new JButton("Rooms");
    rooms.setBounds(30,70,200,30);
    rooms.setForeground(Color.white);
    rooms.setBackground(Color.blue);
    rooms.setFont(new Font("Raleway",Font.PLAIN,16));
    rooms.addActionListener(this);
    add(rooms);
    
    
    department = new JButton("Department");
    department.setBounds(30,110,200,30);
    department.setForeground(Color.white);
    department.setBackground(Color.blue);
    department.setFont(new Font("Raleway",Font.PLAIN,16));
    department.addActionListener(this);
    add(department);
    
    
    employee = new JButton("All Employees");
    employee.setBounds(30,150,200,30);
    employee.setForeground(Color.white);
    employee.setBackground(Color.blue);
    employee.setFont(new Font("Raleway",Font.PLAIN,16));
    employee.addActionListener(this);
    add(employee);
    
    
    customerinfo = new JButton("Customer Info");
    customerinfo.setBounds(30,190,200,30);
    customerinfo.setForeground(Color.white);
    customerinfo.setBackground(Color.blue);
    customerinfo.setFont(new Font("Raleway",Font.PLAIN,16));
    customerinfo.addActionListener(this);
    add(customerinfo);
    
    
    managerinfo = new JButton("Manager Info");
    managerinfo.setBounds(30,230,200,30);
    managerinfo.setForeground(Color.white);
    managerinfo.setBackground(Color.blue);
    managerinfo.setFont(new Font("Raleway",Font.PLAIN,16));
    managerinfo.addActionListener(this);
    add(managerinfo);
    
    checkout = new JButton("Checkout");
    checkout.setBounds(30,270,200,30);
    checkout.setForeground(Color.white);
    checkout.setBackground(Color.blue);
    checkout.setFont(new Font("Raleway",Font.PLAIN,16));
    checkout.addActionListener(this);
    add(checkout);
    
    update = new JButton("Update Status");
    update.setBounds(30,310,200,30);
    update.setForeground(Color.white);
    update.setBackground(Color.blue);
    update.setFont(new Font("Raleway",Font.PLAIN,16));
    update.addActionListener(this);
    add(update);
    
    roomstatus = new JButton("Update Room Status");
    roomstatus.setBounds(30,350,200,30);
    roomstatus.setForeground(Color.white);
    roomstatus.setBackground(Color.blue);
    roomstatus.setFont(new Font("Raleway",Font.PLAIN,16));
    roomstatus.addActionListener(this);
    add(roomstatus);
    
   
    
    
    pickup = new JButton("Pickup Service");
    pickup.setBounds(30,390,200,30);
    pickup.setForeground(Color.white);
    pickup.setBackground(Color.blue);
    pickup.setFont(new Font("Raleway",Font.PLAIN,16));
    pickup.addActionListener(this);
    add(pickup);
    
    
    roomsearch = new JButton("Search Room");
    roomsearch.setBounds(30,430,200,30);
    roomsearch.setForeground(Color.white);
    roomsearch.setBackground(Color.blue);
    roomsearch.setFont(new Font("Raleway",Font.PLAIN,16));
    roomsearch.addActionListener(this);
    add(roomsearch);
    
    logout = new JButton("Logout");
    logout.setBounds(30,470,200,30);
    logout.setForeground(Color.white);
    logout.setBackground(Color.red);
    logout.setFont(new Font("Raleway",Font.PLAIN,16));
    logout.addActionListener(this);
    add(logout);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception108.jpg"));
    Image i2 = i1.getImage().getScaledInstance(640, 520, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(250,10,640,520);
    add(image);
    
    setBounds(350,200,900,570);
    setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
          setVisible(false);
        new AddCustomer();
        }
        else if(ae.getActionCommand().equals("Rooms")){
        setVisible(false);
        new Room();
        }
        else if(ae.getSource() == department){
        setVisible(false);
        new Department();
        }
        else if(ae.getSource() == employee){
        setVisible(false);
        new EmployeeInfo();
        }
        else if(ae.getSource() == managerinfo){
        setVisible(false);
        new ManagerInfo();        
        }
        else if(ae.getSource() == customerinfo ){
         setVisible(false);
         new CustomerInfo();
            
        }
        else if(ae.getSource() == roomsearch){
            setVisible(false);
            new SearchRoom();
        
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new UpdateCheck();
        
        }
        else if(ae.getSource() == roomstatus){
            setVisible(false);
            new UpdateRoom();
        
        }
        else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource() == pickup){
            setVisible(false);
            new Pickup();
        }
        else if(ae.getSource() == logout){
            setVisible(false);
            System.exit(0);     
        }
    }
    
    public static void main(String[] args){
        new Reception();   
    }
    
}
