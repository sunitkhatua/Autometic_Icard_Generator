package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmployeeId;
    JButton delete, back;
    
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelemployeeid = new JLabel("Employee Id");
        labelemployeeid.setBounds(50,50,100,30);
        add(labelemployeeid);
        
        cEmployeeId = new Choice();
        cEmployeeId.setBounds(200,50,150,30);
        add(cEmployeeId);
        
        try{
            Conn c = new Conn();
            String query = "select * from detailsforidcard";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cEmployeeId.add(rs.getString("EmployeeId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Employee Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        JLabel lblname = new JLabel("");
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        JLabel labelmobile = new JLabel("Employee Mobile");
        labelmobile.setBounds(50,150,100,30);
        add(labelmobile);
        
        JLabel lblmobile = new JLabel("");
        lblmobile.setBounds(200,150,100,30);
        add(lblmobile);
        
        JLabel labelemail = new JLabel("Employee Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail = new JLabel("");
        lblemail.setBounds(200,200,150,30);
        add(lblemail);
        
        try{
            Conn c = new Conn();
            String query = "select * from detailsforidcard where employeeid = '"+cEmployeeId.getSelectedItem()+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("Name"));
                lblmobile.setText(rs.getString("Mobile"));
                lblemail.setText(rs.getString("Email"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cEmployeeId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try{
            Conn c = new Conn();
            String query = "select * from detailsforidcard where employeeid = '"+cEmployeeId.getSelectedItem()+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("Name"));
                lblmobile.setText(rs.getString("Mobile"));
                lblemail.setText(rs.getString("Email"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
            }
        });
        
        delete = new JButton("Remove");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==delete){
            try{
                Conn c = new Conn();
                String query = "delete from detailsforidcard where EmployeeId = '"+cEmployeeId.getSelectedItem()+"'";
                c.s.execute(query);
                JOptionPane.showMessageDialog(null,"Employee Information Removed");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new RemoveEmployee();
    }
}
