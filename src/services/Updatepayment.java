package services;

import dao.UserDAO;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Updatepayment {

    PreparedStatement pst;
    ResultSet rs;
    private String bike_number;

    public String getBike_number() {
        return bike_number;
    }

    public void setBike_number(String bike_number) {
        this.bike_number = bike_number;
    }

    public int payment(String bike_number) {
        setBike_number(bike_number);
        UserDAO u = new UserDAO();
        if (u.paymentReq(getBike_number()) == 1) {
            return 1;
        }
        return 0;
    }

    public String[] myresult(String bike_number) {
        setBike_number(bike_number);
        String data[] = new String[2];
        UserDAO udo = new UserDAO();
        try {
            rs = udo.showRecords(bike_number);
            data[0] = rs.getString("amount");
            data[1] = rs.getString("bike_number");
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
