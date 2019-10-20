package com.evs.testapplication.sastabotique_local.models;

/**
 * Created by AQIB JAVED on 9/1/2018.
 */

public class UserModel {
    private String userId;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
