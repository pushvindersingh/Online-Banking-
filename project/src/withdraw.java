/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Raman
 */
public class withdraw extends JFrame implements ActionListener{
    Choice c1;
	    JLabel l1,l2,l3;
	    JTextField t1;
	    JButton b1;


    public withdraw() {
        setSize(600,400);
	        l1=new JLabel("Account no");
	        l2=new JLabel("Deposit Amount");
	        t1=new JTextField(20);
	        c1=new Choice();
	        try
	        {
	            conn c=new conn();
	            ResultSet rs=c.s.executeQuery("Select * from bank");
	            while(rs.next())
	            {
	               c1.add(rs.getString("AccountNo"));
	            }
	            
	        }
	        catch(Exception ex)
	        {
	    }
	setLayout(new FlowLayout());
	add(l1);
	add(c1);
	add(l2);
	add(t1);
	b1=new JButton("Withdraw");
	add(b1);
	b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String q1="Update bank set Balance=Balance-"+t1.getText()+" where AccountNo="+c1.getSelectedItem();
		     try
		     {
		         conn c=new conn();
		         c.s.executeUpdate(q1);
		         ResultSet rs=c.s.executeQuery("Select * from bank where AccountNo="+c1.getSelectedItem());
		         double balance=0;
		         if(rs.next())
		         {
		             balance=rs.getDouble("Balance");
		             
		          //   SimpleDateFormat df = new SimpleDateFormat("DD/MM/YYYY");
		            // Date date = df.parse(datestr);
		             String t=new java.util.Date().toString();
		            q1="insert into trans values("+c1.getSelectedItem()+","+t1.getText()+",0,'"+ t+"',"+balance+")";
		             c.s.executeUpdate(q1);
		         }
		     }
		     catch(Exception ex)
		     {
		       ex.printStackTrace();
		     }
		     JOptionPane.showMessageDialog(null,"Records Updated");
		     t1.setText("");
    }
    
}
