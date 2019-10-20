package com.evs.testapplication.sastabotique_local.Dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by AQIB JAVED on 11/18/2018.
 */

@Entity(tableName = "USERS")
public class UserEntityTable {
    @PrimaryKey(autoGenerate =  true)
    @ColumnInfo(name = "USER_ID")
    private int id;


    private String name;
    private String CNIC;
    private String password;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public String getPassword() {
        return password;
    }
}
