package services;

import dao.MyConnection;
import dao.UserDAO;
import java.sql.*;
import javax.swing.JOptionPane;

public class UpdateUser {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    private String gdate;
    private String bike_number;

    public String getBike_number() {
        return bike_number;
    }

    public void setBike_number(String bike_number) {
        this.bike_number = bike_number;
    }

    public UpdateUser() {
        con = MyConnection.connect();
    }

    public String getdate() {
        return gdate;
    }

    public void setdate(String date1) {
        this.gdate = date1;
    }

    public int update(String date_request, String bike_number) {
        setdate(date_request);
        setBike_number(bike_number);
        UserDAO u = new UserDAO();

        if (date_request.equals("") || bike_number.equals("")) {

            return 0;

        } else {

            if (u.updateReq(date_request, bike_number) == 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
