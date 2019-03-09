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
public class report extends JFrame 
{
    JTextArea t1;

    public report() 
    {
        setSize(700,400);
        t1=new JTextArea(70,70);
        t1.setText("                    ICICI BANK Sector-9");
        t1.append("\n                    SCO 110-111");
        t1.append("\n                    Phone:2654333");
        t1.append("\n");
        t1.append("\n Account No.            Debit                 Credit                             Date/Time                                 Balance"); 
        String dd="Hello";
        try
        {
            String r1="SELECT * from trans ORDER BY AccountNo";
            conn c1=new conn();
            ResultSet rs1=c1.s.executeQuery(r1);
            while(rs1.next())
            {
                t1.append("\n"+rs1.getString("AccountNo")+"                    "+rs1.getString("Debit")+"                        "+rs1.getString("Credit")+"                    "+rs1.getString("Date")+"                     "+rs1.getString("Balance"));
            }
        }
        catch(Exception e)
        {
            
        }
        t1.setEditable(false);
        JScrollPane jsp=new JScrollPane(t1);
        add(jsp);
    }

        
}
