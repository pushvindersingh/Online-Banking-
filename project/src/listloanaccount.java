/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
/**
 *
 * @author Raman
 */
public class listloanaccount extends JFrame implements ActionListener 
{
    JTable t;
    JButton b;
    String h[]={"LoanId","CustName","LoanAm","StartDate","NoOfMonths","ROI","EMI","LoanType","Status"};
    String d[][]=new String[15][9];
    int i=0,j=0;

    public listloanaccount() 
    {
        super("Loan Details");
        setSize(600,300);
        setLocation(150,150);
        try
        {
          String q="select * from loan";   
          conn c=new conn();
          ResultSet rs=c.s.executeQuery(q);
          while(rs.next())
          {
              d[i][j++]=rs.getString("LoanId");
              d[i][j++]=rs.getString("CustName");
              d[i][j++]=rs.getString("LoanAm");
              d[i][j++]=rs.getString("StartDate");
              d[i][j++]=rs.getString("NoOfMonths");
              d[i][j++]=rs.getString("ROI");
              d[i][j++]=rs.getString("EMI");
              d[i][j++]=rs.getString("LoanType");
              d[i][j]=rs.getString("Status");
              i++;
              j=0;
          }
        }
        catch(Exception e)
        {
            
        }
        t=new JTable(d,h);
        b=new JButton("Print");
        add(b,"South");
        JScrollPane s1=new JScrollPane(t);
        add(s1);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            t.print();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
