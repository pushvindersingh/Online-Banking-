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
public class ministatement extends JFrame implements ActionListener{
    
    JLabel l1;
    Integer u1;
    JTextArea a1;
    JPanel p1;
    JTable j1;
    Choice c1;
    JButton b1,b2;
    String h[]={"AcconutNo","Debit","Credit","Date","Balance"};
    String d[][],a;
    int i=0,j=0,m;
    float l=0,k=0;
    String data[][]=new String[25][6];

    public ministatement(String d[][]) {
        super("MiniStatement");
        if(d!=null)
        {
            data=d;
        }
        setSize(800,500);
        l1=new JLabel("Choose Account No.");
        c1=new Choice();
        p1=new JPanel();
        b1=new JButton("Show");
        b2=new JButton("Print");
        p1.add(c1);
        p1.add(b1);
        p1.add(b2);
        try
        {
            String q="Select * from bank";
            conn c=new conn();
            ResultSet rs=c.s.executeQuery(q);
            while(rs.next())
            {
                c1.add(rs.getString("AccountNo"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        add(p1,"North");
        j1=new JTable(data,h);
        JScrollPane jsp=new JScrollPane(j1);
        p1.add(jsp);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String msg=e.getActionCommand();
        if(msg.equals("Show"))
        {
            setVisible(false);
            u1=Integer.parseInt(c1.getSelectedItem());
            try
            {
                String r="Select * from trans where AccountNo="+u1;
                conn c=new conn();
                d=new String[25][5];
                ResultSet rs=c.s.executeQuery(r);
                while(rs.next())
                {
                    d[i][j++]=rs.getString("AccountNo");
                    d[i][j++]=rs.getString("Debit");
                    d[i][j++]=rs.getString("Credit");
                    d[i][j++]=rs.getString("Date");
                    d[i][j++]=rs.getString("Balance");
                    i++;
                    j=0;
                }
                for(m=0;m<i;m++)
                {
                    l+=Float.parseFloat(d[m][1]);
                    k+=Float.parseFloat(d[m][2]);
                    a=d[m][4];
                }
                d[i+1][j++]="Total";
                d[i+1][j++]=l+"";
                d[i+1][j++]=k+"";
                d[i+1][j++]="Balance";
                d[i+1][j]=a;
                j=0;
                j1=new JTable(d,h);
                JScrollPane s1=new JScrollPane(j1);
                add(s1);
                add(b2,"South");
                ministatement b11=new ministatement(d);
                b11.setSize(600,500);
                b11.setResizable(false);
                b11.setVisible(true);
                b11.setLocation(200,200);
                this.setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            i=0;
        }
        else
        {
            try
            {
                j1.print();
            }
            catch(PrinterException er)
            {
                er.printStackTrace();
            }
        }
    }
    
}
