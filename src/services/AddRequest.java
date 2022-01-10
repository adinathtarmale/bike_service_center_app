package services;
import dao.UserDAO;
import java.sql.ResultSet;

public class AddRequest {
    ResultSet rs;
    UserDAO ud = new UserDAO();

    private String usernameAddReq;
    private String mobileNoAddreq;
    private String bikeNumAddReq;
    private String bikeNameAddReq;
    private String dateAddReq;

    public String getUsernameAddReq() {
        return usernameAddReq;
    }

    public void setUsernameAddReq(String usernameAddReq) {
        this.usernameAddReq = usernameAddReq;
    }

    public String getMobileNoAddreq() {
        return mobileNoAddreq;
    }

    public void setMobileNoAddreq(String mobileNoAddreq) {
        this.mobileNoAddreq = mobileNoAddreq;
    }

    public String getBikeNameAddReq() {
        return bikeNameAddReq;
    }

    public void setBikeNameAddReq(String bikeNameAddReq) {
        this.bikeNameAddReq = bikeNameAddReq;
    }

    public String getBikeNumAddReq() {
        return bikeNumAddReq;
    }

    public void setBikeNumAddReq(String bikeNumAddReq) {
        this.bikeNumAddReq = bikeNumAddReq;
    }

    public String getDateAddReq() {
        return dateAddReq;
    }

    public void setDateAddReq(String dateAddReq) {
        this.dateAddReq = dateAddReq;
    }

    public int insertAddServicesTbl(String[] custAdd) {
        
        if(custAdd[0].equals("") || custAdd[1].equals("") || custAdd[2].equals("") || custAdd[3].equals("") || custAdd[4].equals("")){
            return 0;
        }else{
            if (ud.addRequ(custAdd)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
