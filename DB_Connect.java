/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author gloadelyn.mercado916
 */
public class DB_Connect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            String host = "jdbc:derby://localhost:1527/contact";
            String dbName = "student";
            String dbPass = "student";
            Connection conn = DriverManager.getConnection(host, dbName, dbPass);
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM student.colleagues";
            ResultSet Rset = state.executeQuery(SQL);
            
            System.out.println("ID \t FIRSTNAME \n LastName" );
            
            while(Rset.next())
            {
                int ID = Rset.getInt("ID");
                String FName = Rset.getString("FIRSTNAME");
                String LName = Rset.getString("LASTNAME");
                
                System.out.println(ID + " " + FName + " " + LName);
            }
        }
        catch(SQLException err)
        {
            System.out.println(err.getMessage());
        }
        
        
        
        // TODO code application logic here
    }
    
}
