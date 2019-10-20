package com.example.aqibjaved.sqlitedatabase.Entity;

/**
 * Created by AQIB JAVED on 11/19/2017.
 */

public class UserEntity {
    private Integer id;
    private String userName;
    private String userPassword;

    public UserEntity(Integer id, String userName, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public UserEntity(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
