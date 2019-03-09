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
public class listaccount extends JFrame implements ActionListener
{
    JTable j1;
    JButton b1;
    String h[]={"Account No","Name","Balance"};
    String d[][]=new String[15][3];
    int i=0,j=0;
    public listaccount() 
    {
        super("View Customer Accounts");
        setSize(600,300);
        try
        {
            String q="Select * from bank";
            conn c=new conn();
            ResultSet rs=c.s.executeQuery(q);
            while(rs.next())
            {
                d[i][j++]=rs.getString("AccountNo");
                d[i][j++]=rs.getString("Name");
                d[i][j]=rs.getString("Balance");
                i++;
                j=0;
            }
        }
        catch(Exception e)
        {
            
        }
        j1=new JTable(d,h);
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try
       {
           j1.print();
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
    }
    
}
