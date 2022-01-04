package ehealth.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class DoctorMain extends JFrame implements ActionListener{
	
	JFrame f;
	JTable j1;
    JButton b1;
    String h[]={"Sno.","Patient's Name","Phone no.","Problem of the Patient"};
    String d[][]=new String[15][4];  
    int i=0,j=0;
    static String xyz;
    JTextField search;
    String b,prob;
    
	
    public DoctorMain(String xyz) {
    	
    	
    	f=new JFrame("Doctor Data");
    	f.setVisible(true);
    	f.setBackground(Color.black);
    	f.setLayout(null);
    	f.setBounds(100, 100, 1003, 545);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		
		
    	JLabel id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        
    	JLabel id1 = new JLabel("Doctor's Name: ");
		id1.setBounds(227, 6, 139, 20);
		id1.setFont(new Font("Tahoma", Font.BOLD, 16));
		id15.add(id1);
		f.add(id1);
		
		JLabel id2 = new JLabel("");
		id2.setBounds(357, 6, 158, 20);
		id2.setForeground(new Color(178, 34, 34));
		id2.setFont(new Font("Tahoma", Font.BOLD, 16));
		id15.add(id2);
		f.add(id2);
		
		JLabel id3 = new JLabel("Specialisation: ");
		id3.setBounds(578, 6, 121, 20);
		id3.setFont(new Font("Tahoma", Font.BOLD, 16));
		id15.add(id3);
		f.add(id3);
		
		JLabel id4 = new JLabel("");
		id4.setBounds(710, 6, 198, 20);
		id4.setForeground(new Color(178, 34, 34));
		id4.setFont(new Font("Tahoma", Font.BOLD, 16));
		id15.add(id4);
		f.add(id4);
		
		JLabel id5 = new JLabel("Email-Id:");
		id5.setBounds(227, 37, 75, 20);
		id5.setFont(new Font("Tahoma", Font.BOLD, 16));
		id15.add(id5);
		f.add(id5);
		
		JLabel id6 = new JLabel("");
		id6.setBounds(316, 37, 185, 20);
		id6.setForeground(new Color(178, 34, 34));
		id6.setFont(new Font("Tahoma", Font.BOLD, 16));
		id15.add(id6);
		f.add(id6);
		
		JLabel id7 = new JLabel("Phone no: ");
		id7.setBounds(578, 37, 85, 20);
		id7.setFont(new Font("Tahoma", Font.BOLD, 16));
		id15.add(id7);
		f.add(id7);
		
		JLabel id8 = new JLabel("");
		id8.setBounds(673, 37, 158, 20);
		id8.setForeground(new Color(178, 34, 34));
		id8.setFont(new Font("Tahoma", Font.BOLD, 16));
		id15.add(id8);
		f.add(id8);
		
		
		JLabel id = new JLabel("Account info:");
		id.setForeground(new Color(25, 25, 112));
		id.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		id.setBounds(28, 11, 158, 46);
		id15.add(id);
		f.add(id);
		
		try {
			DatabaseConnection c1=new DatabaseConnection();
			String a="SELECT * from Doctor where EmailId='"+xyz+"'";
			ResultSet rs = c1.s.executeQuery(a);
			while(rs.next()) {
			b=rs.getString("DoctorName");
			id2.setText(b);
			String c= rs.getString("Specialisation");
			id4.setText(c);
			String d= rs.getString("EmailId");
			id6.setText(d);
			String e= rs.getString("Phone");
			id8.setText(e);
			
			
			}
			String t="select * from PatientLog where DoctorName='"+b+"'";  
			int w=1;
			String ss=") ";
			ResultSet rs1 = c1.s.executeQuery(t);
			
			while(rs1.next())
			{
				d[i][j++]=w+ss;
				d[i][j++]=rs1.getString("PatientName");
				d[i][j++]=rs1.getString("PatientPhoneno");
                d[i][j++]=rs1.getString("Problem");
                i++;
                j=0;
                w++;
			}
			rs1.close();
			j1=new JTable(d,h);
			j1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row=j1.getSelectedRow();
					search.setText(j1.getModel().getValueAt(row,1).toString());
					prob=j1.getModel().getValueAt(row, 3).toString();
				}
			});
			j1.setForeground(Color.BLACK);
			j1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			f.add(j1);
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		JTextPane remark = new JTextPane();
        remark.setText("Write remark here..");
        remark.setFont(new Font("Tahoma", Font.PLAIN, 12));
        remark.setBounds(316, 408, 378, 89);
        f.add(remark);
        
        JButton b2 = new JButton("Submit");
        b2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		try {
        			DatabaseConnection db=new DatabaseConnection();
        			String a=search.getText();
        			String q=remark.getText();
        			System.out.print(a+"\t"+q);
        			
//        			String w="Select Problem from Patientlog where DoctorName='"+b+"'";
//        			PreparedStatement ps=db.c.prepareStatement(w);
//                    ResultSet rs3  = ps.executeQuery();
//                    if(rs3.next())
//                    {
//                       prob=rs3.getString("Problem");
//                    
//                    }
        			
        			String c="UPDATE PatientLog SET DoctorRemark='"+q+"'WHERE PatientName='"+a+"' AND DoctorName='"+b+"' and Problem='"+prob+"'";
        			int rs = db.s.executeUpdate(c); 
        			
                    if(rs==1){
                    	JOptionPane.showMessageDialog(null, "Remark sent succesfully");
                    }
                    
        		}
        		catch(Exception e) {
        			
        		}
        		
        	}
        });
        b2.setBackground(Color.RED);
        b2.setForeground(new Color(0, 0, 0));
        b2.setFont(new Font("Tahoma", Font.BOLD, 18));
        b2.setBounds(769, 433, 100, 50);
        f.add(b2);
        
        search = new JTextField();
        search.setFont(new Font("Tahoma", Font.BOLD, 16));
        search.setBounds(53, 436, 176, 33);
        f.add(search);
        search.setColumns(10);
		
		b1=new JButton("Print");
		b1.setFont(new Font("Tahoma", Font.BOLD, 16));
		b1.setSize(100, 50);
		b1.setLocation(879, 434);
		f.add(b1,"South");
		
		JScrollPane sp = new JScrollPane(j1);
        sp.setBounds(10,121,969,266);
        f.add(sp);
        b1.addActionListener(this);
	}

	public static void main(String[] args) {
		

	}

	public void actionPerformed(ActionEvent ae1) {
		if(ae1.getSource()==b1) {
		try{
            j1.print();
        }catch(Exception ae){
        	ae.printStackTrace();
        }
		}
		
		
	}

}
