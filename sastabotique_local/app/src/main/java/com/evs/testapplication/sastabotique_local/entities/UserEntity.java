package com.evs.testapplication.sastabotique_local.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "UserDetails")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "USER_ID")
    private int id;
    @ColumnInfo(name = "USER_NAME")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}