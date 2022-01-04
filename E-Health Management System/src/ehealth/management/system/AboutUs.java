package ehealth.management.system;

import java.awt.*;
import javax.swing.*;

public class AboutUs extends JFrame{

	private JPanel contentPane;

        public static void main(String[] args) {
            new AboutUs().setVisible(true);			
	}
    
        public AboutUs() {
            
            super("About Us - Hosptial");
            setBackground(new Color(173, 216, 230));
            setBounds(350, 120, 700, 500);
		
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel l1 = new JLabel("New label");
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/aboutus.jpg"));
            Image i2 = i1.getImage().getScaledInstance(250, 150,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l1 = new JLabel(i3);
            l1.setBounds(400, 40, 250, 150);
            contentPane.add(l1);


            JLabel l3 = new JLabel("Hospital");
            l3.setForeground(new Color(0, 231, 200));
            l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l3.setBounds(140, 40, 200, 55);
            contentPane.add(l3);

            JLabel l4 = new JLabel("Mangement System");
            l4.setForeground(new Color(127, 156, 0));
            l4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l4.setBounds(70, 90, 405, 40);
            contentPane.add(l4);

            JLabel l5 = new JLabel("v5.1");
            l5.setForeground(new Color(30, 144, 255));
            l5.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
            l5.setBounds(185, 140, 100, 21);
            contentPane.add(l5);


            JLabel l6 = new JLabel("Developed By : Rahil Arora "
            		+ "and Shahnawaz Ahmad");
            l6.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
            l6.setBounds(70, 198, 600, 50);
            contentPane.add(l6);

          
            JLabel l7 = new JLabel("<HTML><U><B>Training Project</B></U></HTML>");
            l7.setFont(new Font("Trebuchet MS", Font.BOLD , 30));
            l7.setBounds(70, 320, 600, 34);
            l7.setForeground(new Color(127, 0, 0));
            contentPane.add(l7);
            
            JLabel l9 = new JLabel("Contact : rahil.arora@incedoinc.com,"+ "\n"+ " shahnawaz.ahmad@incedoinc.com");
            l9.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
            l9.setBounds(70, 250, 600, 34);
            contentPane.add(l9);


            JLabel l10 = new JLabel("Phone - +91-9805235959, +91-8726564699");
            l10.setForeground(new Color(47, 79, 79));
            l10.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
            l10.setBounds(70, 400, 600, 34);
            contentPane.add(l10);
                
                
            contentPane.setBackground(Color.WHITE);
	}
        

}


