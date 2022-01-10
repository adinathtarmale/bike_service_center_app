package services;

import dao.AdminDAO;
import java.sql.Connection;
import java.sql.ResultSet;

public class AdminWorkService {
    Connection con=null;
    AdminDAO ado=null;
    private String bike_number = null;
    private String progress = null;
    private String amount = null;
    
    public AdminWorkService(){
        this.ado = new AdminDAO();
    }

    public String getBike_number() {
        return bike_number;
    }

    public void setBike_number(String bike_number) {
        this.bike_number = bike_number;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    @SuppressWarnings("empty-statement")
    public ResultSet dispRequest(){
        ResultSet rs;
        rs = ado.dispRequest();
        return rs;
    }
    
    public int startendRequest(String bike_number, String progress){
        setBike_number(bike_number);
        setProgress(progress);
        if (ado.daoStartEndreq(getBike_number(), getProgress()) != 0) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int startendRequest(String bike_number, String progress, String amount){
        setBike_number(bike_number);
        setProgress(progress);
        setAmount(amount);
        if(ado.daoStartEndreq(getBike_number(), getProgress(), getAmount())!=0){
            return 1;
        }
        return 0;
    }
}
