package com.evs.testapplication.sastabotique_local.Dao;

/**
 * Created by AQIB JAVED on 11/11/2018.
 */

public class UserTableDao {
    private int _ID;
    private String name;
    private String address;
    private String CNIC;

    public String getName() {
        return name;
    }

    public int get_ID() {
        return _ID;
    }

    public String getAddress() {
        return address;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }
}
