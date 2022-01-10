package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.AddRequest;
import services.ViewRequest;

public class UserDAO {

    public PreparedStatement pst;
    private ResultSet rs;
    public static Connection con;
    public static ViewRequest vr;
    public static AddRequest ar;

    static {
        con = MyConnection.connect();
        vr = new ViewRequest();
        ar = new AddRequest();
    }

    public ResultSet showRecords(String bikeNum) {
        try {
            pst = con.prepareStatement("SELECT username, bike_name, bike_number, date_request, progress, amount FROM services WHERE bike_number = ?");
            pst.setString(1, bikeNum);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addRequ(String[] custAdd) {
        try {
            pst = con.prepareStatement("SELECT username, bike_name, bike_number, date_request, progress FROM services WHERE bike_number = ?");
            pst.setString(1, custAdd[3]);
            rs = pst.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                pst = con.prepareStatement("INSERT INTO services (username, mobile_no, bike_name, bike_number, date_request) VALUES (?, ? ,? ,?, ?)");
                pst.setString(1, custAdd[0]);
                pst.setString(2, custAdd[1]);
                pst.setString(3, custAdd[2]);
                pst.setString(4, custAdd[3]);
                pst.setString(5, custAdd[4]);
                pst.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int updateReq(String date_request, String bike_number) {
        try {
            pst = con.prepareStatement("UPDATE services SET date_request=? where bike_number=?");
            pst.setString(1, date_request);
            pst.setString(2, bike_number);
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int deleteReq(String bike_number, String bike_name) {
        try {
            pst = con.prepareStatement("delete from services where bike_number=? and bike_name=?");
            pst.setString(1, bike_number);
            pst.setString(2, bike_name);
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public int paymentReq(String bike_number) {
        try {
            pst = con.prepareStatement("delete from services where bike_number=? and amount not in ('')");
            pst.setString(1, bike_number);
            if (pst.executeUpdate() == 1) {

                return 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
