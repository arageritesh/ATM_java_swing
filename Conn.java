
package bank.management.system;
import java.sql.*;


public class Conn
{
     Connection c;
     Statement s;
    public Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///","root","ias@2486");
            
            s=c.createStatement();
        }
        
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
    public static void main(String args[]) throws SQLException 
    {
        Conn c=new Conn();
        
        
              String query="create database pqr" ;
              //c.s.execute(query);
              
              String query1="use pqr";
              c.s.execute(query1);
              
              String query2="create table me(id int,name varchar(255))";
              c.s.execute(query2);
              
        
        
        
}
}
