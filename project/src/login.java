
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raman
 */
public class login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    login()
    {
        setSize(1000,800);
        setLayout(new BorderLayout());
        ImageIcon c1=new ImageIcon(ClassLoader.getSystemResource(""));
        JLabel l3=new JLabel(c1);
        add(l3);
        l1=new JLabel("Username");
        l2=new JLabel("Password");
        t1=new JTextField(15);
        t2=new JPasswordField(15);
        b1=new JButton("Login");
        
        l3.setLayout(new FlowLayout());
        l3.add(l1);
        l3.add(t1);
        l3.add(l2);
        l3.add(t2);
        l3.add(b1);
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            conn c1=new conn();
            String u=t1.getText();
            String v=t2.getText();
            String q="Select * from emp1 where Username='"+u+"' and Password='"+v+"'";
            ResultSet rs=c1.s.executeQuery(q);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Valid User");
               new project().setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Wrong User");
            }
        }
        catch(Exception x)
        {
            
        }
    }
    public static void main(String args[])
    {
        login l1=new login();
        l1.setVisible(true);
        l1.setSize(1024,576);
    }
    
}
