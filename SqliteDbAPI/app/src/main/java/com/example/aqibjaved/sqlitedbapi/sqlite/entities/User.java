package com.example.aqibjaved.sqlitedbapi.sqlite.entities;

/**
 * Created by AQIB JAVED on 8/20/2017.
 */

public class User {
    private int _id;
    private String userName;
    private String password;
    public User(){

    }
    public User(String userName,String password){
        this.userName=userName;
        this.password=password;
    }
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
