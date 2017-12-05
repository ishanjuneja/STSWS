/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Windows_
 */
public class DBConnection {
    private Connection DBConnection;
    public Connection connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("connection success");
        }
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("connection failed"+cnfe);
        }
        String url = "jdbc:mysql://localhost:3306/example1";
        try{
            DBConnection = (Connection) DriverManager.getConnection(url, "root", "ishan1234");
            System.out.println("database connected");
            
        }
        catch(SQLException se){
            System.out.println("databse not connected"+se);
        }
        return DBConnection;
    }
        
    
}
