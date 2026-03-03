
package com.mycompany.jdbc;
import java.sql.*;
/**
 *
 * @author Ali Ekin Ayhan
 */
public class JDBC {

    public static void main(String[] args) {
        
        /*
            7 steps of a jdbc is: 
            import the packeges  -->  java.sql.*;
            load and register 
            create connection
            create statement 
            execution
            process the results 
            close the connection 
        */
        
        /* Url rule is 
           What you are going to connect with 
           Which DBMS 
           Which database
        */
        
        /* 
           resultSet.next(); This method returns true if we have next row (response from database)          
           And sometimes there is Before start of resultset exception and for the avoid from this
           exception we can use next method to shift cursor 
        */
        
        // Crud Create Read Update Delete
        
        /* Fetch or Read
            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1) +" - ");
                System.out.print(resultSet.getString(2) +" - ");
                System.out.print(resultSet.getString(3) +" - ");
                System.out.println(resultSet.getInt(4));
                
            }
            */
        
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "ekin6262";
        String query = "select * from student";
        String query2 = "insert into student (studentName,studentSurname,studentAge) values ('Ali Ekin', 'Ayhan', 25)";

        
        // studentName,studentSurname,studentAge)
                    
        try{           
            // Load and register and it is optional if we delete it program will still work
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            // Create Connection
        Connection connection = DriverManager.getConnection(url,username,password);
        
            System.out.println("Connection Established");
            
            // Cteate Statement
            Statement statement = connection.createStatement();
            
            // Execute Statement
            statement.executeUpdate(query2);
            ResultSet resultSet = statement.executeQuery(query); // This method will return ResultSet type
            
            
            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1) +" - ");
                System.out.print(resultSet.getString(2) +" - ");
                System.out.print(resultSet.getString(3) +" - ");
                System.out.println(resultSet.getInt(4));
                
            }
            
            
            // Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection Closed");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Couldn't Established");
        }
    }
}
