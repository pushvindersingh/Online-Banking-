
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;


public class project extends JFrame implements ActionListener {
    project()
    {
        setSize(1000,800);
        ImageIcon c1=new ImageIcon(ClassLoader.getSystemResource("icon/d.jpg"));
        JLabel l1=new JLabel(c1);
        add(l1);
      JMenuBar mb=new JMenuBar();
      setJMenuBar(mb);
       JMenu f1=new JMenu("Master");
       JMenu j=new JMenu("Logout");
       mb.add(f1);
        JMenuItem first=new JMenuItem("New Account");
        JMenuItem second=new JMenuItem("Deposit");
         JMenuItem third=new JMenuItem("Withdraw");
         JMenuItem fifth=new JMenuItem("List Account");
         JMenu g1=new JMenu("Statement");
         mb.add(g1);
        JMenuItem fourth=new JMenuItem("MiniStatement");
         first.setForeground(Color.blue);
        first.setFont(new Font("Arial",Font.BOLD,12));
        first.setMnemonic('e');
        ImageIcon c2= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/new.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        first.setIcon(c2);
        first.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        ImageIcon c3= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/deposit.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        second.setIcon(c3);
        ImageIcon c4= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/list.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        fifth.setIcon(c4);
        ImageIcon c5= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/withdraw.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        third.setIcon(c5);
        
        ImageIcon c9= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/mini.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        fourth.setIcon(c9);
       
       
        f1.add(first);
          f1.add(second);
            f1.add(third);
              f1.add(fifth);
                g1.add(fourth);
                first.addActionListener(this);
                second.addActionListener(this);
                third.addActionListener(this);
                fifth.addActionListener(this);
                fourth.addActionListener(this);
                JMenu s1=new JMenu("Updation");
                JMenu s2=new JMenu("Reports");
                JMenu s3=new JMenu("Utilities");
                mb.add(s1);
                mb.add(s2);
                mb.add(s3);
                JMenuItem k1=new JMenuItem("Modify Account");
                JMenuItem k2=new JMenuItem("Delete Account");
                s1.add(k1);
                s1.add(k2);
                 ImageIcon c10= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/modify.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        k1.setIcon(c10);
        ImageIcon c11= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/delete.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        k2.setIcon(c11);
                k1.addActionListener(this);
                k2.addActionListener(this);
                JMenuItem p1=new JMenuItem("Customer Reports");
                s2.add(p1);
                 ImageIcon c12= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/report.gif")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        p1.setIcon(c12);
        
                p1.addActionListener(this);
                JMenuItem s11=new JMenuItem("Notepad");
                JMenuItem s12=new JMenuItem("Calculator");
                JMenuItem s13=new JMenuItem("Browser");
                 ImageIcon c6= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        s11.setIcon(c6);
         ImageIcon c7= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        s12.setIcon(c7);
         ImageIcon c8= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/browser.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        s13.setIcon(c8);
                s11.addActionListener(this);
                s12.addActionListener(this);
                s13.addActionListener(this);
                s3.add(s11);
                s3.add(s12);
                s3.add(s13);
       JMenu f11=new JMenu("Loan");
       mb.add(f11);
        JMenuItem f=new JMenuItem("New Request");
         ImageIcon a1= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/new.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        f.setIcon(a1);
        JMenuItem v=new JMenuItem("List Loan Accounts");
        ImageIcon a2= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/list.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        v.setIcon(a2);
        JMenuItem s=new JMenuItem("Accept/reject Loan");
        ImageIcon a3= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/239665.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        s.setIcon(a3);
        JMenuItem t=new JMenuItem("Modify LAccount");
        ImageIcon a4= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/modify.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        t.setIcon(a4);
         JMenuItem fi=new JMenuItem("Delete LAccount");
         ImageIcon a5= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/delete.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        fi.setIcon(a5);
         
         f11.add(f);
         f11.add(v);
          f11.add(s);
            f11.add(t);
              f11.add(fi);
               f.addActionListener(this);
               v.addActionListener(this);
                s.addActionListener(this);
                t.addActionListener(this);
                fi.addActionListener(this);
                mb.add(j);
               JMenuItem jm=new JMenuItem("Exit");
                ImageIcon a6= new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/log.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        jm.setIcon(a6);
         
               j.add(jm);
               jm.addActionListener(this);
                
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        if(msg.equals("Exit"))
            new login().setVisible(true);
                
        if(msg.equals("New Account"))
            new newaccount().setVisible(true);
        if(msg.equals("List Account"))
            new listaccount().setVisible(true);
        if(msg.equals("Deposit"))
            new deposit().setVisible(true);
          if(msg.equals("Withdraw"))
            new withdraw().setVisible(true);
          if(msg.equals("MiniStatement"))
            new ministatement(null).setVisible(true);
          if(msg.equals("Delete Account"))
            new deleteaccount().setVisible(true);
          if(msg.equals("Modify Account"))
            new modifyaccount().setVisible(true);
            if(msg.equals("New Request"))
            new newrequest().setVisible(true);
             if(msg.equals("List Loan Accounts"))
            new listloanaccount().setVisible(true);
               if(msg.equals("Modify LAccount"))
            new modifylacc().setVisible(true);
             if(msg.equals("Delete LAccount"))
            new deletelacc().setVisible(true);
                   if(msg.equals("Accept/reject Loan"))
            new acceptreject().setVisible(true);
               if(msg.equals("Customer Reports"))
            new report().setVisible(true);
          if(msg.equals("Notepad"))
          {
              try
              {
                  String s="notepad.exe";
                  Runtime.getRuntime().exec(s);
              }
              catch(Exception ex)
              {
          }
    }
          if(msg.equals("Calculator"))
          {
              try
              {
                  String s="calc.exe";
                  Runtime.getRuntime().exec(s);
              }
              catch(Exception ex)
              {
          }
       
    }
          if(msg.equals("Browser"))
          {
              try
              {
                  String s="\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\"";
                  Runtime.getRuntime().exec(s);
              }
              catch(Exception ex)
              {
          }
       
          }
       
          
}
}