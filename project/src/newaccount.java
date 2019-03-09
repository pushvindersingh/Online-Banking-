
/*import java.awt.FlowLayout;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import javax.swing.JButton;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  import javax.swing.JOptionPane;
  import javax.swing.JTextField; */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class newaccount extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1;
    public newaccount() 
    {
        setSize(280,300);
        setLocation(100,100);
        setLayout(new FlowLayout());
        l1=new JLabel("Account No.");
        l2=new JLabel("Name");
        l3=new JLabel("Balance");
        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        b1=new JButton("Submit");
        add(b1);
        b1.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String q="insert into bank values("+t1.getText()+",'"+t2.getText()+"',"+t3.getText()+")";
        
        try
        {
            conn c1=new conn();
            c1.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Records Inserted");
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    
}

