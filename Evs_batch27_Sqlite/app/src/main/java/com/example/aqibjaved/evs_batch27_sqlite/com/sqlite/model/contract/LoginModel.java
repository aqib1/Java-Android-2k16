package com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.model.contract;

/**
 * Created by AQIB JAVED on 3/25/2018.
 */

public class LoginModel {
    private int id;
    private String username;

    public LoginModel(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    private String password;

    public LoginModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
}
