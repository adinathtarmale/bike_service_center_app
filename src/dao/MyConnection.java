package dao;
import java.sql.*;

public class MyConnection {
    public static Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BikeService?zeroDateTimeBehavior=CONVERT_TO_NULL","serviceadmin","serviceadmin");
            return con;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
