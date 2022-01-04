package ehealth.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.StyledEditorKit.UnderlineAction;

public class PatientData {
	
	JFrame f;
	JLabel id1,id2,id3,id4,id5,id6,id7,id8,id15;
	
	public PatientData() {
		
		f=new JFrame("Patient Data");
		f.setBackground(Color.white);
		f.setLayout(null);
		
		id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
//        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ehealth/management/system/icons/hosp3.jpg"));
//        Image i3 = img.getImage().getScaledInstance(1000, 620,Image.SCALE_DEFAULT);
//        ImageIcon icc3 = new ImageIcon(i3);
//        id15.setIcon(icc3);
        
        id8 = new JLabel("Patient Details");
        id8.setBounds(10,5,400,25);
        id8.setFont(new Font("serif",Font.BOLD,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);
        
        id1 = new JLabel("Patient Name");
        id1.setBounds(50,150,150,30);
        id1.setForeground(new Color(255,255,255));
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);
        
        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(250,60);
        f.getContentPane().setBackground(Color.white);
        f.setResizable(false);
	}

	public static void main(String[] args) {
		PatientData pd=new PatientData();

	}

}
