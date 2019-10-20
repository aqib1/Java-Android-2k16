package com.evs.testapplication.sastabotique_local.Dto;

/**
 * Created by AQIB JAVED on 10/27/2018.
 */

public class UsersRequest {
    private String userId;
    private String email;
    private String password;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
