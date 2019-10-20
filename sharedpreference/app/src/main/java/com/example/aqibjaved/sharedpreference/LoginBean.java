package com.example.aqibjaved.sharedpreference;

/**
 * Created by AQIB JAVED on 10/28/2017.
 */

public class LoginBean {
    private String user_name;
    private String password;
public LoginBean(String username, String password){
    this.user_name=username;
    this.password=password;
}
    public LoginBean(){}
    public String getPassword() {
        return password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
