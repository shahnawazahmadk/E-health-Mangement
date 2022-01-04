package ehealth.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class viewAdminDoctor extends JFrame implements ActionListener{
 
	JScrollPane sp;
    JTable t1 ;
    JButton b2;
    String x[] = {"DoctorName","Specialisation","Age","EmailId"};
    String pn;
    String y[][] = new String[20][4];
    int i=0, j=0;
   viewAdminDoctor(){
    	 super("Doctor Details");
    	     
    	setVisible(true);
        setSize(1260,650);
        setLocation(15,60);
        setLayout(null);
        
      
        setVisible(true);
        b2 = new JButton("EXIT");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(620, 550, 130 ,50);
        add(b2);
        
        
      
        b2.addActionListener(this);
        
        
        try{
            DatabaseConnection c1  = new DatabaseConnection();
            String s1 = "select * from doctor";
            PreparedStatement ps=c1.c.prepareStatement(s1);
            ResultSet rs= ps.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("DoctorName");
                y[i][j++]=rs.getString("Specialisation");
                y[i][j++]=rs.getString("Age");
               
                y[i][j++]=rs.getString("EmailId");              
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        sp = new JScrollPane(t1);
        sp.setBounds(20,20,1200,330);
        add(sp);
       
        getContentPane().setBackground(Color.WHITE);
        
   
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==b2)
    	{
    		setVisible(false);
    		
    		
    	} 
           
    }
    public static void main(String[] args){
    	
    
        
    }
    
    
}