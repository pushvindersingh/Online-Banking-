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
public class modifyaccount extends JFrame implements ActionListener,ItemListener
{
    Choice c1;
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1;

    public modifyaccount() 
    {
        setSize(600,400);
        l1=new JLabel("Account No");
        l2=new JLabel("Name");
        l3=new JLabel("Balance");
        t1=new JTextField(20);
        t2=new JTextField(20);
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
        catch(Exception e)
        {
            
        }
        setLayout(new FlowLayout());
        add(l1);
        add(c1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        b1=new JButton("Modify");
        add(b1);
        b1.addActionListener(this);
        c1.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int n=JOptionPane.showConfirmDialog(this,null,"Do you want to Update",JOptionPane.YES_NO_OPTION);
        if(n==1)
        {
            return;
        }
        String q="Update bank set Name='"+t1.getText()+"',Balance="+t2.getText()+"where AccountNo="+c1.getSelectedItem();
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
        t1.setText("");
        t2.setText("");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from bank where AccountNo="+c1.getSelectedItem());
            if(rs.next())
            {
                t1.setText(rs.getString("Name"));
                t2.setText(rs.getString("Balance"));
            }
        }
        catch(Exception ex)
        {
            
        }
    }
    
}
