package com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.beans;

/**
 * Created by AQIB JAVED on 11/24/2018.
 */

public class UserBean {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
