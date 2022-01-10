package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
    public static Connection con;
    
    static{
        con =  MyConnection.connect();
    }
    // for admin login perpose
    public int adminLogin(String username, String password){        
        try {
            PreparedStatement pst = con.prepareStatement("Select username, pass_word from services where username=? and pass_word=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    // for admin to accept and start the request of service
    public int daoStartEndreq(String bike_number, String progress){  
        try{
            PreparedStatement pst = con.prepareStatement("select bike_number from services where bike_number=?");
            pst.setString(1, bike_number);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                PreparedStatement pst1 = con.prepareStatement("update services set progress = ? where bike_number = ?");
                pst1.setString(1, progress);
                pst1.setString(2, bike_number);
                if(0!=pst1.executeUpdate()){
                    return 1;
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    // for admin to finish, stop and generating service amount
    public int daoStartEndreq(String bike_number, String progress, String amount){
        try{
            PreparedStatement pst = con.prepareStatement("select bike_number from services where bike_number=?");
            pst.setString(1, bike_number);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                PreparedStatement pst1 = con.prepareStatement("update services set progress = ?, amount = ? where bike_number = ?");
                pst1.setString(1, progress);
                pst1.setString(2, amount);
                pst1.setString(3, bike_number);
                if(0!=pst1.executeUpdate()){
                    return 1;
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public ResultSet dispRequest(){
        ResultSet rs = null;
        try{
            PreparedStatement pst = con.prepareStatement("select bike_number, date_request, progress, mobile_no from services");
            rs = pst.executeQuery();
            rs.next();              // admin record row excluded
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rs;
    }
}
