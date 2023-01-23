package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tfemail, tfmobile, tfbloodgroup, tfdesignation, tfaddress;
    JComboBox mf;
    JDateChooser dcdob;
    JLabel heading, labelname, labelemail, labelmobile, labelemployeeid, tfemployeeid, labelbloodgroup, labeldesignation, labeldateofbirth, labeladdress, labelgender; 
    JButton add, back;
            
    AddEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        heading = new JLabel("Add Employee");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
       labelname = new JLabel("Name");
       labelname.setBounds(50,150,150,30);
       labelname.setFont(new Font("serif", Font.PLAIN,20));
       add(labelname);
       
       tfname = new JTextField();
       tfname.setBounds(50, 177, 150, 30);
       add(tfname);
       
       labelemail = new JLabel("E-mail");
       labelemail.setBounds(320,150,150,30);
       labelemail.setFont(new Font("serif", Font.PLAIN,20));
       add(labelemail);
       
       tfemail = new JTextField();
       tfemail.setBounds(320, 177, 150, 30);
       add(tfemail);
       
       labelmobile = new JLabel("Mobile");
       labelmobile.setBounds(600,150,150,30);
       labelmobile.setFont(new Font("serif", Font.PLAIN,20));
       add(labelmobile);
       
       tfmobile = new JTextField();
       tfmobile.setBounds(600, 177, 150, 30);
       add(tfmobile);
       
       labelemployeeid = new JLabel("Employee ID");
       labelemployeeid.setBounds(50,220,150,30);
       labelemployeeid.setFont(new Font("serif", Font.PLAIN,20));
       add(labelemployeeid);
       
       tfemployeeid = new JLabel(""+number);
       tfemployeeid.setBounds(50, 250, 150, 30);
       tfemployeeid.setFont(new Font("serif", Font.PLAIN,20));
       add(tfemployeeid);
       
       labelbloodgroup = new JLabel("Blood Group");
       labelbloodgroup.setBounds(600,220,150,30);
       labelbloodgroup.setFont(new Font("serif", Font.PLAIN,20));
       add(labelbloodgroup);
       
       tfbloodgroup = new JTextField();
       tfbloodgroup.setBounds(600, 250, 150, 30);
       add(tfbloodgroup);
       
       labeldesignation = new JLabel("Designation");
       labeldesignation.setBounds(320,220,150,30);
       labeldesignation.setFont(new Font("serif", Font.PLAIN,20));
       add(labeldesignation);
       
       tfdesignation = new JTextField();
       tfdesignation.setBounds(320, 250, 150, 30);
       add(tfdesignation);
       
       labeldateofbirth = new JLabel("Date Of Birth");
       labeldateofbirth.setBounds(50,290,150,30);
       labeldateofbirth.setFont(new Font("serif", Font.PLAIN,20));
       add(labeldateofbirth);
       
       dcdob = new JDateChooser();
       dcdob.setBounds(50,320,150,30);
       add(dcdob);
       
       labeladdress = new JLabel("Address");
       labeladdress.setBounds(320,290,150,30);
       labeladdress.setFont(new Font("serif", Font.PLAIN,20));
       add(labeladdress);
       
       tfaddress = new JTextField();
       tfaddress.setBounds(320, 320, 250, 30);
       add(tfaddress);
       
       labelgender = new JLabel("Gender");
       labelgender.setBounds(600,290,150,30);
       labelgender.setFont(new Font("serif", Font.PLAIN,20));
       add(labelgender);
       
       String gender[] = {"Male", "Female"};
       mf = new JComboBox(gender);
       mf.setBackground(Color.WHITE);
       mf.setBounds(600, 320, 70, 30);
       add(mf);
       
        add = new JButton("Add Details");
        add.setBounds(250, 400,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 400,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
       
        
//        ////// Image Browse ///////


        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String Name = tfname.getText();
            String Email = tfemail.getText();
            String Mobile = tfmobile.getText();
            String BloodGroup = tfbloodgroup.getText();
            String DateOfBirth = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String Address = tfaddress.getText();
            String Gender = (String) mf.getSelectedItem();
            String EmployeeId = tfemployeeid.getText();
            String Designation = tfdesignation.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into detailsforidcard values('"+Name+"', '"+Email+"', '"+Mobile+"', '"+BloodGroup+"', '"+DateOfBirth+"', '"+Address+"', '"+Gender+"', '"+EmployeeId+"', '"+Designation+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new AddEmployee();
    }
}
