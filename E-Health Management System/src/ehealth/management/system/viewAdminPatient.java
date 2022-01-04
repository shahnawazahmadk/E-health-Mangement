package ehealth.management.system;







import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class viewAdminPatient extends JFrame implements ActionListener{
 
	JScrollPane sp;
    JTable t1 ;
    JButton b2;
    String x[] = {"PatientName","Age","Phone","DateOfBirth","EmailId"};
    String pn;
    String y[][] = new String[20][5];
    int i=0, j=0;
    viewAdminPatient(){
    	 super("Patient Details");
    	     
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
            String s1 = "select * from patient";
            PreparedStatement ps=c1.c.prepareStatement(s1);
            ResultSet rs= ps.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("PatientName");
                y[i][j++]=rs.getString("Age");
                y[i][j++]=rs.getString("Phone");
                y[i][j++]=rs.getString("DateOfBirth");
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