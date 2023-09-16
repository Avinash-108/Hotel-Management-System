package hotel.management.system;
import java.sql.Connection;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfname,tfage,tfphone,tfemail,tfsalary,tfadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox drop;
    AddEmployee(){
        setLayout(null);
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("verdana",Font.PLAIN, 15));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN, 15));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblgender);
        
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setBackground(Color.white);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,13));
        add(rbmale);
        
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(280, 130, 100, 30);
        rbfemale.setBackground(Color.white);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,13));
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lbljob);
        
        String[] str = {"Manager","Chef","Porters","Housekeeping","Accountant","Receptionist","Waiter","Desk_Cerk"}; 
        drop = new JComboBox(str);
        drop.setBounds(200, 180, 150, 30);
        drop.setBackground(Color.white);
        add(drop);
        
        JLabel lblphone = new JLabel("PHONE N0.");
        lblphone.setBounds(60,230,120,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 230, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("EMAIL-ID");
        lblemail.setBounds(60,280,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblemail);
        
        tfemail= new JTextField();
        tfemail.setBounds(200, 280, 150, 30);
        add(tfemail);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60,330,120,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN, 15));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200,330,150,30);
        add(tfsalary);
        
        JLabel lbladhar = new JLabel("AADHAR");
        lbladhar.setBounds(60,380,120,30);
        lbladhar.setFont(new Font("Tahoma",Font.PLAIN, 15));
        add(lbladhar);
        
        tfadhar = new JTextField();
        tfadhar.setBounds(200,380,150,30);
        add(tfadhar);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(100,440,200,30);
        submit.setForeground(Color.white);
        submit.setBackground(Color.blue);
        submit.addActionListener(this);
        add(submit);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 10, 450, 400);
        add(image);
        
        
        getContentPane().setBackground(Color.white);
        setBounds(350,200,850,540);
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
   
    String name = tfname.getText();
    String age = tfage.getText();
    String salary = tfsalary.getText();
    String phone = tfphone.getText();
    String email = tfemail.getText();
    String adhar = tfadhar.getText();
    String gender = null;
    
    if(name.equals("")){       // Validation for name
         JOptionPane.showMessageDialog(null, "Name should not be empty");
         
         return;
    }
    if(rbmale.isSelected()){ gender = "male";}
    else if(rbfemale.isSelected()){gender = "female";}
    
    String job = (String)drop.getSelectedItem();
    try{
         Conn c = new Conn();
         
         String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+phone+"','"+email+"','"+salary+"','"+adhar+"')";
         c.s.executeUpdate(query);
         
         JOptionPane.showMessageDialog(null, "Employee added successfully");
         
         setVisible(false);
    } catch(Exception e){
    e.printStackTrace();
    }
    
    } 
    
    public static void main(String[] args){
    new AddEmployee();
    }
}
