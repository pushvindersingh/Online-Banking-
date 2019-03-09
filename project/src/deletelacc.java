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
public class deletelacc extends JFrame implements ActionListener,ItemListener
{
    Choice c1,c2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1;

    public deletelacc() 
    {
        setSize(600,400);
        l1=new JLabel("Loan ID");
       l2=new JLabel("Customer Name");
        l3=new JLabel("Loan Amount");
        l4=new JLabel("Start Date");
        l5=new JLabel("No. of Months");
        l6=new JLabel("Rate of Interest");
        l7=new JLabel("EMI");
        l8=new JLabel("Loan Type");
        l9=new JLabel("Status");
        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);
        t4=new JTextField(20);
        t5=new JTextField(20);
        t6=new JTextField(20);
        t7=new JTextField(20);
        t8=new JTextField(20);
        
        c1=new Choice();
        c1.add("Home Loan");        
        c1.add("Car Loan");        
        c1.add("Cash Loan");        
        c1.add("others");        
        c2=new Choice();
        try
        {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from loan");
            while(rs.next())
            {
                c2.add(rs.getString("LoanId"));
            }
        }
        catch(Exception e)
        {
            
        }
        setLayout(new FlowLayout());
        add(l1);
        add(c2);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(l4);
        add(t3);
        add(l5);
        add(t4);
        add(l6);
        add(t5);
        add(l7);
        add(t6);
        add(l8);
        add(t7);
        add(l9);
        add(t8);
        
        b1=new JButton("Delete");
        add(b1);
        b1.addActionListener(this);
        c2.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        int n=JOptionPane.showConfirmDialog(this,null,"Do you want to Delete",JOptionPane.YES_NO_OPTION);
        if(n==1)
        {
            return;
        }
        String q="delete from loan where LoanId="+c2.getSelectedItem();
        System.out.println(q);
        try
        {
            conn c=new conn();
            c.s.executeUpdate(q);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
         JOptionPane.showMessageDialog(null,"Records Deleted");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from loan where LoanId="+c2.getSelectedItem());
            if(rs.next())
            {
                t1.setText(rs.getString("CustName"));
                t2.setText(rs.getString("LoanAm"));
                t3.setText(rs.getString("StartDate"));
                t4.setText(rs.getString("NoOfMonths"));
                t5.setText(rs.getString("ROI"));
                t6.setText(rs.getString("EMI"));
                t7.setText(rs.getString("LoanType"));
                t8.setText(rs.getString("Status"));
                
            }
        }
        catch(Exception ex)
                {
                    
                }
    }
    
}
