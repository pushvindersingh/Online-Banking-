/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
/**
 *
 * @author Raman
 */
public class conn {
    Connection c;
    
    public Statement s;
    
    public conn()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///emp","root","");
            s=c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
