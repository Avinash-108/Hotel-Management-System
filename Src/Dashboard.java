package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard() {
        
        setBounds(0,0,1550,1550);
        setLayout(null);
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotels2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
//----------------------------------------------------------------------------------------------------------------------        
        JLabel text = new JLabel("Fhusigarou Group Welcomes You ");
        text.setBounds(400, 80,1000,50);
        text.setFont(new Font("Tahoma", Font.PLAIN,46));
        text.setForeground(Color.white);
        image.add(text);
//----------------------------------------------------------------------------------------------------------------------------------------------------        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu management = new JMenu("MANAGEMENT");
        management.setForeground(Color.red);
        mb.add(management);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        management.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem adddriver = new JMenuItem("ADD DRIVER");
        adddriver.addActionListener(this);
        admin.add(adddriver);
        
        JMenuItem addroom = new JMenuItem("ADD ROOM");
        addroom.addActionListener(this);
        admin.add(addroom);
        
        setVisible(true);
    }
  
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){    
        new AddEmployee();
        } 
        else if(ae.getActionCommand().equals("ADD ROOM")){
        new AddRooms();
        } else if(ae.getActionCommand().equals("ADD DRIVER")){
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
        new Reception();
        }
        
    }
    
    public static void main(String[] args){
        Dashboard dashboard = new Dashboard();
    }
    
}
