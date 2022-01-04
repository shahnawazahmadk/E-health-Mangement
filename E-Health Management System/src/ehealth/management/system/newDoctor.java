package ehealth.management.system;

import java.awt.*;
import java.util.Base64;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

class newDoctor implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,lab,lab1,lab2;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3;
    JComboBox c1,c2;

    newDoctor(){
    	
    	f = new JFrame("Add Doctor");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/hosp3.jpg"));
        Image i3 = img.getImage().getScaledInstance(1000, 620,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id15.setIcon(icc3);

        id8 = new JLabel("New Doctor Details");
        id8.setBounds(30,5,400,25);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(new Color(255,120,56));
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Doctor Name");
        id1.setBounds(50,150,150,30);
        id1.setForeground(new Color(255,255,255));
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("Doctor ID");
        id2.setBounds(400,150,200,30);
        id2.setForeground(new Color(255,255,255));
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Specialisation");
        id3.setBounds(50,200,120,30);
        id3.setForeground(new Color(255,255,255));
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);

        id4= new JLabel("Age");  
        id4.setBounds(400,200,200,30);
        id4.setForeground(new Color(255,255,255));
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

        id5= new JLabel("Email ID");
        id5.setBounds(50,250,100,30);
        id5.setForeground(new Color(255,255,255));
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);

        id6= new JLabel("Password");
        id6.setForeground(new Color(255,255,255));
        id6.setBounds(400,250,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);

        t6=new JPasswordField();
        t6.setBounds(600,250,150,30);
        id15.add(t6);

        id7= new JLabel("Phone number");
        id7.setForeground(new Color(255,255,255));
        id7.setBounds(50,300,130,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id15.add(t7);

       
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,450,150,40);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,450,150,40);
        
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(250,60);
        f.getContentPane().setBackground(Color.WHITE);
        f.setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
    	 String name = t1.getText();
         String docid = t2.getText();
         String spec = t3.getText();
        
         String age = t4.getText();
         String email = t5.getText();
         String pass = t6.getText();
         String phone = t7.getText();
         
         Base64.Encoder en= Base64.getEncoder();
         String estr=en.encodeToString(pass.getBytes());
         System.out.println("Encoded password: "+ estr);
         
         Base64.Decoder dec=Base64.getDecoder();
         String dstr=new String(dec.decode(estr));
         
         //System.out.println("Decoded password: "+dstr);
         
         if(ae.getSource() == b){
             try{
                 DatabaseConnection cc = new DatabaseConnection();
                 int ag=Integer.parseInt(age);
                 int doc=Integer.parseInt(docid);
                 String q = "insert into Doctor values('"+name+"','"+doc+"','"+spec+"','"+ag+"','"+email+"','"+estr+"','"+phone+"')";
                 cc.s.executeUpdate(q);
                 JOptionPane.showMessageDialog(null,"Patient added Successfully");
                 f.setVisible(false);
                 
             }catch(Exception ee)
             {
                 System.out.println("The error is:"+ee);
             }
         }
         else if(ae.getSource() == b1){
        	 
        	 f.setVisible(false);
             
         
         }
        
      
            }
  

	public static void main(String[] arg){
        new newDoctor().f.setVisible(true);
    }
}