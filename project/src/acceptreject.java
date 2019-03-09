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
public class acceptreject extends JFrame implements ActionListener,ItemListener
{
    JLabel l1,l2;
    JButton b;
    Choice c1,c2,c3;

    public acceptreject() 
    {
        setSize(280,300);
        setLocation(100,100);
        setLayout(new FlowLayout());
        l1=new JLabel("Loan ID");
        l2=new JLabel("Status");
        c3=new Choice();
        c3.add("Accept");
        c3.add("Pending");
        c3.add("Reject");
        c1=new Choice();
        c1.add("Home Loan");
        c1.add("Car Loan");
        c1.add("Cash Loan");
        c1.add("Others");
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
        catch(Exception ex)
        {
            
        }
        add(l1);
        add(c2);
        add(l2);
        add(c3);
        b=new JButton("Submit");
        add(b);
        b.addActionListener(this);
        c3.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String q="Update loan set Status='"+c3.getSelectedItem()+"'where LoanId="+c2.getSelectedItem();
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
        JOptionPane.showMessageDialog(null,"Records Updated");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from loan where Status="+c3.getSelectedItem());
        }
        catch(Exception ex)
        {
            
        }
    }
    
}
