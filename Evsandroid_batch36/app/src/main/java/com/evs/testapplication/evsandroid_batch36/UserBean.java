package com.evs.testapplication.evsandroid_batch36;

import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * Created by AQIB JAVED on 12/22/2018.
 */

public class UserBean {
    private String username;
    private String password;

    public UserBean(){

    }

    public UserBean(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
