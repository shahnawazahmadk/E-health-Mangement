package ehealth.management.system;





import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.xml.crypto.Data;



import java.sql.*;

public class patientMain extends JFrame implements ActionListener{
 
    JLabel l1,l2,l3;
    JTable t1;
    JButton b1,b2,b3;
    JTextField t2, t3,t4;
    String x[] = {"DoctorName","DocId","Specialisation","Age","EmailId","Phone"};
    String pn;
    String y[][] = new String[20][6];
    int i=0, j=0;
    String xyz,phone,docname,demail,prob;
    
    patientMain(String u){
    	super("Patient Details");
    	
    	setVisible(true);
    	 xyz=u;
    	 try
    	 {
    	DatabaseConnection c2  = new DatabaseConnection();
    	//System.out.println(u);
        String s2 = "select * from patient where EmailId= '"+u+"'";
        PreparedStatement ps=c2.c.prepareStatement(s2);
        ResultSet rs2  = ps.executeQuery(s2);
        if(rs2.next())
        {
           pn=rs2.getString("PatientName");
        
        }
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     
       
        setSize(1260,650);
        setLocation(15,60);
        setLayout(null);
        
        l1 = new JLabel("Queries or Problem");
        l1.setBounds(50,360,400,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        
        t2 = new JTextField();
        t2.setBounds(400,360,200,70);
        add(t2);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(620, 360, 100 ,30);
        b1.addActionListener(this);
        add(b1);
        
            
        l2 = new JLabel("Doctor name");
        l2.setBounds(50,450,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
        
        t3 = new JTextField();
        t3.setBounds(500,450,200,30);
        add(t3);
        t3.setFont(new Font("serif",Font.BOLD,20));
        t3.setVisible(true);
      
        
        b3 = new JButton("View Remark");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(620, 550, 130 ,50);
        add(b3);
        b3.addActionListener(this);
        
        t4 = new JTextField();
        t4.setBounds(800,500,200,40);
        add(t4);
        t4.setFont(new Font("serif",Font.BOLD,20));
        t4.setVisible(true);
        
        
        try{
            DatabaseConnection c1  = new DatabaseConnection();
            String s1 = "select * from doctor";
            PreparedStatement ps=c1.c.prepareStatement(s1);
            ResultSet rs= ps.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("DoctorName");
                y[i][j++]=rs.getString("DocId");
                y[i][j++]=rs.getString("Specialisation");
                y[i][j++]=rs.getString("Age");
                y[i][j++]=rs.getString("EmailId");
                y[i][j++]=rs.getString("Phone");
              
                i++;
                j=0;
            }
            
            t1 = new JTable(y,x);
            t1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row=t1.getSelectedRow();
					t3.setText(t1.getModel().getValueAt(row,0).toString());
					docname=t3.getText();
					//System.out.println(docname);
					try {
					DatabaseConnection c2=new DatabaseConnection();
					String f1="select EmailId from patientlog where DoctorName='"+docname+"'";
      	            PreparedStatement ps2=c2.c.prepareStatement(f1);
      	            ResultSet rs4  = ps2.executeQuery();
            
      	            if(rs4.next())
      	            {
      	            	demail=rs4.getString("EmailId");
      	            	System.out.println(demail);
      	            }
						}
					catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			});
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //docname=t3.getSelectedText();
        
        
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,1200,330);
        add(sp);
        
        getContentPane().setBackground(Color.WHITE);
        
        
    }
    public void actionPerformed(ActionEvent ae){
    	
        
      
        if(ae.getSource() == b1){
            try{
            	  DatabaseConnection c1 = new DatabaseConnection();
               	  
            	  String f="select phone from patient where EmailId='"+xyz+"'";
            	  PreparedStatement ps=c1.c.prepareStatement(f);
                  ResultSet rs3  = ps.executeQuery();
                  if(rs3.next())
                  {
                     phone=rs3.getString("Phone");
                  
                  }
                  
                  String s11 = "insert into patientlog ( Problem ,PatientName, DoctorName, PatientPhoneno, EmailId ) values(?,?,?,?,?)";
 
                  PreparedStatement ps1=c1.c.prepareStatement(s11);
                  ps1.setString(1,t2.getText());
                  ps1.setString(2,pn);
                  ps1.setString(3,t3.getText());
                  ps1.setString(4, phone);
                  ps1.setString(5, demail);
            
                  int aaa =ps1.executeUpdate();
                  if(aaa==1)
                	  
                  {
                	  
                  JOptionPane.showMessageDialog(null, "success");
                  
                  }
            }
                      
             catch(Exception e)
            {
            	 System.out.println(e);
            }
        }
            else if(ae.getSource()==b3)
            {
            	
          	  
            	try
            	{
            		DatabaseConnection c1 = new DatabaseConnection();
          	 String s22 = "Select DoctorRemark from patientlog where PatientName ='"+ pn+"' and EmailId='"+demail+"'";
          	 PreparedStatement ps2=c1.c.prepareStatement(s22);
          	 ResultSet sss=ps2.executeQuery();
          	 
          	 while(sss.next())
             {
          		 t4.setText(sss.getString("DoctorRemark"));

            } 

            	}
          	catch (Exception e)
            	{
          		System.out.println(e);
            	}
          	 
            
    }
    }
    
    public static void main(String[] args){
    	
    
        
    }
    
    
}