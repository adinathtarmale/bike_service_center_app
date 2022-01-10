package services;

import dao.AdminDAO;

public class AdminLoginService {
    private String username;
    private String pass_word;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return pass_word;
    }

    public void setPassword(String pass_word) {
        this.pass_word = pass_word;
    }

    public int doLogin(String username, String pass_word) {
        setUsername(username);
        setPassword(pass_word);
        AdminDAO ado = new AdminDAO();
        if (ado.adminLogin(getUsername(), getPassword()) != 0) {
            return 1;
        }
        return 0;
    }
}
