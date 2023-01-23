package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
//import java.util.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
//    Random ran = new Random();
//    int number = ran.nextInt(999999);
    String EmployeeId;
    JTextField tfname, tfemail, tfmobile, tfbloodgroup, tfdesignation, tfaddress;
    JComboBox mf;
    JDateChooser dcdob;
    JLabel heading, labelname, labelemail, labelmobile, labelemployeeid, tfemployeeid, labelbloodgroup, labeldesignation, labeldateofbirth, labeladdress, labelgender; 
    JButton add, back;
            
    UpdateEmployee(String EmployeeId){
        this.EmployeeId = EmployeeId;
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
       
       JLabel lblname = new JLabel();
       lblname.setBounds(50, 177, 150, 30);
       add(lblname);
       
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
       
       tfemployeeid = new JLabel();
       tfemployeeid.setBounds(50, 250, 150, 30);
       tfemployeeid.setFont(new Font("serif", Font.PLAIN,20));
       add(tfemployeeid);
       
       labelbloodgroup = new JLabel("Blood Group");
       labelbloodgroup.setBounds(600,220,150,30);
       labelbloodgroup.setFont(new Font("serif", Font.PLAIN,20));
       add(labelbloodgroup);
       
       JLabel lblbloodgroup = new JLabel();
       lblbloodgroup.setBounds(600, 250, 150, 30);
       add(lblbloodgroup);
       
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
       
       JLabel lbldob = new JLabel();
       lbldob.setBounds(50,320,150,30);
       add(lbldob);
       
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
       JLabel iblmf = new JLabel();
       iblmf.setBackground(Color.WHITE);
       iblmf.setBounds(600, 320, 70, 30);
       add(iblmf);
       
       try{
           Conn c = new Conn();
           String query = "select * from detailsforidcard where EmployeeId = '"+EmployeeId+"'";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next()){
               lblname.setText(rs.getString("Name"));
               tfemployeeid.setText(rs.getString("EmployeeId"));
               lblbloodgroup.setText(rs.getString("BloodGroup"));
               lbldob.setText(rs.getString("DateOfBirth"));
               iblmf.setText(rs.getString("Gender"));
               tfaddress.setText(rs.getString("Address"));
               tfmobile.setText(rs.getString("Mobile"));
               tfdesignation.setText(rs.getString("Designation"));
               tfemail.setText(rs.getString("Email"));
               
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       
        add = new JButton("Update Details");
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
       
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String Email = tfemail.getText();
            String Mobile = tfmobile.getText();
            String Address = tfaddress.getText();
            String Designation = tfdesignation.getText();
            
            
            try{
                Conn conn = new Conn();
                String query = "update detailsforidcard set Email='"+Email+"', Mobile='"+Mobile+"', Address='"+Address+"', Designation='"+Designation+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateEmployee("");
    }
}
