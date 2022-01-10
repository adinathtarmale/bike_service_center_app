package services;

import dao.UserDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewRequest {
    private ResultSet rs = null;
    private String userNameView;
    private String bikeNameView;
    private String bikeNumView;

    public String getUserNameView() {
        return userNameView;
    }

    public void setUserNameView(String userNameView) {
        this.userNameView = userNameView;
    }

    public String getBikeNameView() {
        return bikeNameView;
    }

    public void setBikeNameView(String bikeNameView) {
        this.bikeNameView = bikeNameView;
    }

    public String getBikeNumView() {
        return bikeNumView;
    }

    public void setBikeNumView(String bikeNumView) {
        this.bikeNumView = bikeNumView;
    }

    public String[] viewReq(String username,String bikename,String bikenum) {
        setUserNameView(username);
        setBikeNameView(bikename);
        setBikeNumView(bikenum);
        String[] custDetails = new String[4];
        UserDAO ud = new UserDAO();
        try {
            rs = ud.showRecords(bikeNumView);
            if(rs == null){
                return null;
            }
            else if (getUserNameView().equals(rs.getString("username")) && getBikeNameView().equals(rs.getString("bike_name")) && getBikeNumView().equals(rs.getString("bike_number"))) {
                custDetails[0] = rs.getString("bike_name");
                custDetails[1] = rs.getString("bike_number");
                custDetails[2] = rs.getString("date_request");
                custDetails[3] = rs.getString("progress");
                return custDetails;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return custDetails;
    }
}
