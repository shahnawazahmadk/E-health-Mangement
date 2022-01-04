package ehealth.management.system;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

class addResources extends JFrame implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id8,id15;
    JTextField t1,t2,t3,t4,t5;
    JButton b,b1;
    

    addResources(){
    	
    	f = new JFrame("Add Resources");
    	f.setVisible(true);
        f.setBackground(Color.white);
        f.setLayout(null);
        

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/addresmain.jpg"));
        Image i3 = img.getImage().getScaledInstance(1000, 620,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id15.setIcon(icc3);

        id8 = new JLabel("New Resource Details");
        id8.setBounds(10,5,400,25);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(new Color(255,120,56));
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Total Bed");
        id1.setBounds(35,150,150,30);
        id1.setForeground(Color.black);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("Occupied Bed");
        id2.setBounds(400,150,200,30);
        id2.setForeground(Color.black);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Medicine Shortage");
        id3.setBounds(35,200,160,30);
        id3.setForeground(Color.black);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);

        id4= new JLabel("Total Doctor");  
        id4.setBounds(400,200,200,30);
        id4.setForeground(Color.black);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

        id5= new JLabel("Total Staff");
        id5.setBounds(35,250,100,30);
        id5.setForeground(Color.black);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);

        

       
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
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				
			}
		});
        
        
        f.setSize(900,600);
        f.setLocation(250,60);
        f.getContentPane().setBackground(Color.WHITE);
        f.setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
    	 String totalbeds = t1.getText();
         String docid = t2.getText();
         String medshortage = t3.getText();
        
         String td = t4.getText();
         String ts = t5.getText();
         
         
         if(ae.getSource() == b){
             try{
                 DatabaseConnection cc = new DatabaseConnection();
                 int totalb=Integer.parseInt(totalbeds);
                 int doc=Integer.parseInt(docid);
                 int totaldoctor=Integer.parseInt(td);
                 int totalstaff=Integer.parseInt(ts);
                 String q = "insert into resources values('"+totalb+"','"+doc+"','"+medshortage+"','"+totaldoctor+"','"+totalstaff+"')";
                 int r=cc.s.executeUpdate(q);
                 if(r==1)
                 {
                 JOptionPane.showMessageDialog(null,"Resources added Successfully");
                 f.setVisible(false);
                 }else {
                	 JOptionPane.showMessageDialog(null,"Something went wrong");
                	 f.setVisible(false);
                 }
                 
             }catch(Exception ee)
             {
                 System.out.println("The error is:"+ee);
             }
         }
         
         
         }

	public static void main(String[] arg){
        addResources ad=new addResources();
    }
}