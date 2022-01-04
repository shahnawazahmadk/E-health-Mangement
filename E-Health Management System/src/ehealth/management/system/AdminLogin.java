package ehealth.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Base64;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin extends JFrame implements ActionListener{

	JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;

    AdminLogin(){

        super("Admin Login");

        setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
                setVisible(false);
				
			}
		});
        

        
        
        b3=new JButton("Add Admin");
        b3.setBounds(110,200,120,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);
        

        b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
		            DatabaseConnection c1 = new DatabaseConnection();
		            String u = t1.getText();
		            String v = t2.getText();
		            
		            Base64.Encoder en=Base64.getEncoder();
		            v=en.encodeToString(v.getBytes());
		            
		            String q = "select * from adminlogin where username='"+u+"' and password='"+v+"'";
		            
		            ResultSet rs = c1.s.executeQuery(q);
//		            System.out.println(u);
//		            System.out.println(v);
		            if(rs.next()){
		                new addAdmin();
		                setVisible(false);
		            	//System.out.println("working");
		            }else{
		                JOptionPane.showMessageDialog(null, "Invalid login");
		                setVisible(false);
		            }
		        }catch(Exception e1){
		            e1.printStackTrace();
		        }
		    }
		
		});
        
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(300,200);
        
        

    }
    
    
    
    

    public void actionPerformed(ActionEvent ae){

        try{
            DatabaseConnection c1 = new DatabaseConnection();
            String u = t1.getText();
            String v = t2.getText();
            
            Base64.Encoder en=Base64.getEncoder();
            v=en.encodeToString(v.getBytes());
            
            String q = "select * from adminlogin where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q);
            
            if(rs.next()){
                new AdminMain();
                this.setVisible(false);
            	//System.out.println("working");
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    public static void main(String[] arg){
        AdminLogin dl = new AdminLogin();
    
}
}

