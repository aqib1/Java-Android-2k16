package com.evs.testapplication.sastabotique_local.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by AQIB JAVED on 11/17/2018.
 */


@Entity(tableName = "Employees")
public class EmployeeEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "EMPLOYEE_ID")
    private int id;

    @ColumnInfo(name = "EMPLOYEE_NAME")
    private String name;

    @ColumnInfo(name = "EMPLOYEE_CNIC")
    private String CNIC;

    public String getCNIC() {
        return CNIC;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
