package ehealth.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class viewResources extends JFrame implements ActionListener{
 
	JScrollPane sp;
    JTable t1 ;
    JButton b2;
    String x[] = {"TotalBed","OccupiedBed","MedicineRunningOut","TotalDoctor","TotalStaff"};
    String pn;
    String y[][] = new String[20][5];
    int i=0, j=0;
   viewResources(){
    	 super("View Resources");
    	     
        setVisible(true);
        setSize(1260,650);
        setLocation(15,60);
        setLayout(null);
        
      
        
        b2 = new JButton("EXIT");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(620, 550, 130 ,50);
        add(b2);
        
        
      
        b2.addActionListener(this);
        
        
        try{
            DatabaseConnection c1  = new DatabaseConnection();
            String s1 = "select * from Resources";
            PreparedStatement ps=c1.c.prepareStatement(s1);
            ResultSet rs= ps.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("TotalBed");
                y[i][j++]=rs.getString("OccupiedBed");
                y[i][j++]=rs.getString("MedicineRunningOut");
                y[i][j++]=rs.getString("TotalDoctor");
                y[i][j++]=rs.getString("TotalStaff");
               
                        
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
    	
    
        new viewResources().setVisible(true);
    }
    
    
}