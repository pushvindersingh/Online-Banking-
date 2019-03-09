
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raman
 */
public class newrequest extends JFrame implements ActionListener 
{
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    Choice c1,c2;

    public newrequest() 
    {
        setSize(800,500);
        setLayout(new FlowLayout());
        l1=new JLabel("Loan Id");
        t1=new JTextField(20);
        l2=new JLabel("Customer Name");
        t2=new JTextField(20);
        l3=new JLabel("Loan Amount");
        t3=new JTextField(20);
        l4=new JLabel("Start Date");
        t4=new JTextField(20);
        l5=new JLabel("No. of Months");
        t5=new JTextField(20);
        l6=new JLabel("Rate Of Interest");
        t6=new JTextField(20);
        l7=new JLabel("EMI");
        t7=new JTextField(20);
        l8=new JLabel("Loan Type");
        c1=new Choice();
        l9=new JLabel("Status");
        c2=new Choice();
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(l8);
        add(c1);
        c1.add("Home Loan");
        c1.add("Personal Loan");
        c1.add("Car Loan");
        c1.add("Education Loan");
        add(l9);
        add(c2);
        c2.add("Pending");
        c2.add("Not Pending");
        b1=new JButton("Submit");
        add(b1);
        b1.addActionListener(this);
        b2=new JButton("Cancel");
        add(b2);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //String msg=e.getActionCommand();
        if(e.getSource()==b2)
        {
            dispose();
            return;
        }
        
            String q="insert into loan values("+t1.getText()+",'"+t2.getText()+"',"+t3.getText()+",'"+t4.getText()+"',"+t5.getText()+","+t6.getText()+","+t7.getText()+",'"+c1.getSelectedItem()+"','"+c2.getSelectedItem()+"')";
            try
            {
                conn c=new conn();
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Records Inserted");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        
    }
    
}
