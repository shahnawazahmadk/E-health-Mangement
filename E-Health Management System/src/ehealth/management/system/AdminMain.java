package ehealth.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AdminMain extends JFrame implements ActionListener {
	public static void main(String[] args) {
		
	
	}
	AdminMain(){
        super("Admin- E-Health Management System");
        
        setSize(1920,1040);
        setLocation(-7, 0);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/admin.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1280, 660,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        
        add(l1);
        
        
        JMenuBar mb  = new JMenuBar();
        JMenu doctor = new JMenu("Doctor");
        JMenuItem m1 = new JMenuItem("Add Doctor");
        JMenuItem m2 = new JMenuItem("View Doctor");
        doctor.setForeground(Color.BLUE);
        
        
        m1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('A');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        
        
        m1.addActionListener(this);
        
        m2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/adddoctor.png"));
        Image image2 = icon2.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('B');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);
        
        
        m2.addActionListener(this);
        

  
        JMenu user = new JMenu("Patient");
        JMenuItem u1 = new JMenuItem("Add Patient");
        JMenuItem u2 = new JMenuItem("View Patient");
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
        
        JMenu res = new JMenu("Resources");
        JMenuItem a1 = new JMenuItem("Add Resources");
        JMenuItem a2 = new JMenuItem("View Resources");
        res.setForeground(Color.BLUE);
        
        a1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon23 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/addres.png"));
        Image image24 = icon23.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        a1.setIcon(new ImageIcon(image24));
        a1.setMnemonic('M');
        a1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        a1.setBackground(Color.WHITE);
        res.add(a1);
       
        a1.addActionListener(this);
        
        a2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon25 = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/viewr.png"));
        Image image26 = icon25.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        a2.setIcon(new ImageIcon(image26));
        a2.setMnemonic('M');
        a2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        a2.setBackground(Color.WHITE);
        doctor.add(a2);
       
        a2.addActionListener(this);
        

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
        doctor.add(m1);
        doctor.add(m2);
  
        user.add(u1);
        user.add(u2);
        
        res.add(a1);
        res.add(a2);
        
        exit.add(ex);
        
        setJMenuBar(mb);    
        mb.add(doctor);
       
        mb.add(user);
        mb.add(res);
        mb.add(exit);
        
        setFont(new Font("Senserif",Font.BOLD,18));
        setLayout(new FlowLayout());
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
    	String msg=ae.getActionCommand();
    	System.out.println(msg);
    	  if(msg.equals("Add Patient"))
    	  {
              newPatient np=new newPatient();
             
    	  }
    	  else if(msg.equals("Exit"))
    	  {
    		  System.exit(0);
    	  }
    	  else if(msg.equals("View Patient"))
    	  {
    		 viewAdminPatient al=new viewAdminPatient();
    	  }
    	  else if(msg.equals("Add Doctor"))
    	  {
    		  newDoctor dl=new newDoctor();
    	  }
    	  else if(msg.equals("View Doctor"))
    	  {
    		  viewAdminDoctor pt=new viewAdminDoctor();
    		  
    	  }
    	  else if(msg.equals("Add Resources"))
    	  {
    		  new addResources();
    	  }
    	  else if(msg.equals("View Resources"))
    	  {
    		  new viewResources();
    	  }
    	  
    	  
    }
    
    
    
	}

