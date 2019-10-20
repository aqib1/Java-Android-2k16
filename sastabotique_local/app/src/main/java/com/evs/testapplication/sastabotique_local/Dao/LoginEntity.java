package com.evs.testapplication.sastabotique_local.Dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by AQIB JAVED on 1/6/2019.
 */

@Entity(tableName = "LOGIN")
public class LoginEntity {

    @ColumnInfo(name = "LOGIN_ID")
    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo(name = "LOGIN_USER_NAME")
    private String userName;
    @ColumnInfo(name = "LOGIN_USER_PASSWORD")
    private String password;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
}
