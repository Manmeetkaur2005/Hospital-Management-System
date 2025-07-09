import java.sql.*;
import java.sql.Connection;
import java.io.*;
import java.sql.DriverManager;

public class DBConnection { 
    public static Connection getConnection() {
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root" , "root");
            System.out.println("Connetion Done");
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return conn;

    }
    
}
