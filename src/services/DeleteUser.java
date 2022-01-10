package services;

import dao.UserDAO;

public class DeleteUser {
    private String bike_number;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBike_number() {
        return bike_number;
    }

    public void setBike_number(String bike_number) {
        this.bike_number = bike_number;
    }

    public int delete(String bike_number, String bike_name) {
        setBike_number(bike_number);
        setName(bike_name);
        UserDAO u = new UserDAO();
        if (bike_number.equals("") || bike_name.equals("")) {
            return 0;
        } else {
            if (u.deleteReq(bike_number, bike_name) == 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
