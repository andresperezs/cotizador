/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author ar00112343
 */
public class DbUtil {
    
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    public String conect = "";
    //public static String conect = "jdbc:mysql://localhost/proyectos?user=root&password=admin";
    
    public DbUtil(String base){     
        
        try {
            Context ctx = new InitialContext();
            System.out.println("BASE - "+base);
            Context envContext = (Context) ctx.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/"+base);
            if (ds != null) {              
              if(connect == null)
                connect = ds.getConnection();
            }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        
        //conect = "jdbc:mysql://10.54.248.122:3306/"+base+"?user=userproyectos&password=Monroe1985";
    } 
    
    public ResultSet getResult(String query){
      try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        System.out.println(query);
         
        statement = connect.createStatement();
        resultSet = statement.executeQuery(query);
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return resultSet;

    }
   
     public boolean ejecutar(String query){
    
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        statement = connect.createStatement();
        statement.executeUpdate(query);
        closeConnection();
        return true;
        
        }catch(Exception e){
            
            System.out.println(e.getMessage());
            closeConnection();
            return false;
        }
        
    }
     
    public String queryValor(String query){
        
        String retorno = "";
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        statement = connect.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        
        while(rs.next()){
            retorno = rs.getString(1);
        }
        
        }catch(Exception e){
            
            System.out.println(e.getMessage());
            closeConnection();
            return retorno;
        }
        closeConnection();
        return retorno;
    }
    
    public Connection getConnection(){
      
        return connect;

    }
     
    public void closeConnection(){
        
        System.out.println("closeConnection");
        try {
            if(resultSet != null)
                resultSet.close();
            if(statement != null)
                statement.close();
            if(connect != null)
                connect.close();
        } catch (SQLException ex) {
            System.out.println("Fallo el closeConnection");
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
}
