/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db_test_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author gloadelyn.mercado916
 */
public class DB_test_connect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            String host = "jdbc:derby://localhost:1527/DBtests";
            String dbName = "student";
            String dbPass = "student";
            Connection conn = DriverManager.getConnection(host, dbName, dbPass);
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM STUDENT.test1";
            ResultSet Rset = state.executeQuery(SQL);
            
            System.out.println("*******TEST 1*******\nQuestion: Answer" );
            
            while(Rset.next())
            {
                String question = Rset.getString("question");
                Boolean a = Rset.getBoolean("answer");
                String answer;
                if(a)
                {
                    answer = "TRUE";
                }
                else
                {
                    answer = "FALSE";
                }
                
                System.out.println(question + ": " + answer);
            }
            
            
            System.out.println("********TEST 2*********\nQuestion: Anser");
            
            
            SQL = "SELECT * FROM STUDENT.test2";
            Rset = state.executeQuery(SQL);
            while(Rset.next())
            {
                String question = Rset.getString("question");
                Boolean a = Rset.getBoolean("answer");
                String answer;
                if(a)
                {
                    answer = "TRUE";
                }
                else
                {
                    answer = "FALSE";
                }
                
                System.out.println(question + ": " + answer);
            }
            
            
            
        }
        catch(SQLException err)
        {
            System.out.println(err.getMessage());
        }
        
        
        
        // TODO code application logic here
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


