package ehealth.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Project extends JFrame implements ActionListener {
	public static void main(String[] args) {
		Project p=new Project();
		p.setVisible(true);
	}
	Project(){
        super("E-Health Management System");
        
        setSize(1920,1040);
        setLocation(-7, 0);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/third.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1400, 650,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        
        add(l1);
        
        
        
        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem m1 = new JMenuItem("Login");
        master.setForeground(Color.BLUE);
        
        
        m1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('A');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        
        
        m1.addActionListener(this);
        

  
        JMenu user = new JMenu("Patient");
        JMenuItem u1 = new JMenuItem("Patient Login");
        JMenuItem u2 = new JMenuItem("New Patient");
        user.setForeground(Color.RED);
        
        u1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/icon3.png"));
        Image image4 = icon4.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setMnemonic('C');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        
        u2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/icon4.jpg"));
        Image image5 = icon5.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image5));
        u2.setMnemonic('D');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);
        
        u1.addActionListener(this);
        u2.addActionListener(this);
        
        JMenu doctor = new JMenu("Doctor");
        JMenuItem a1 = new JMenuItem("Doctor Login");
        doctor.setForeground(Color.BLUE);
        
        a1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon23 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/icon14.jpg"));
        Image image24 = icon23.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        a1.setIcon(new ImageIcon(image24));
        a1.setMnemonic('M');
        a1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        a1.setBackground(Color.WHITE);
        doctor.add(a1);
       
        a1.addActionListener(this);
        
        
     
        JMenu about = new JMenu("About");
        JMenuItem aboutus = new JMenuItem("About Us");
        about.setForeground(Color.BLUE);
        
        aboutus.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon21 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/icon13.jpg"));
        Image image22 = icon21.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        aboutus.setIcon(new ImageIcon(image22));
        aboutus.setMnemonic('L');
        aboutus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        aboutus.setBackground(Color.WHITE);
        about.add(aboutus);
        aboutus.addActionListener(this);

        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.RED);
        

        ex.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/icon12.png"));
        Image image11 = icon11.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);   
         master.add(m1);
  
        user.add(u1);
        user.add(u2);
        
   
        doctor.add(about);
        exit.add(ex);
        
        setJMenuBar(mb);    
        mb.add(master);
       
        mb.add(doctor);
        mb.add(user);
        mb.add(exit);
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent ae)
    {
    	String msg=ae.getActionCommand();
    	System.out.println(msg);
    	  if(msg.equals("Patient Login"))
    	  {
              patientLogin pl=new patientLogin();
              
             
    	  }
    	  else if(msg.equals("Exit"))
    	  {
    		  System.exit(0);
    	  }
    	  else if(msg.equals("Login"))
    	  {
    		 AdminLogin al=new AdminLogin();
    		 al.setVisible(true);
    		 
    	  }
    	  else if(msg.equals("Doctor Login"))
    	  {
    		  DoctorLogin dl=new DoctorLogin();
    		  dl.setVisible(true);
    	  }
    	  else if(msg.equals("New Patient"))
    	  {
    		  newPatient np=new newPatient();
    		  
    	  }
    	  else if(msg.equals("About Us")) {
    		  AboutUs au=new AboutUs();
    		  au.setVisible(true);
    	  }
    }
    
    
    
	}
