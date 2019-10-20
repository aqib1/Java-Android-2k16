package com.evs.testapplication.sastabotique_local.evsandroid36.dto;

/**
 * Created by AQIB JAVED on 1/20/2019.
 */

public class LoginDto {

    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

}
