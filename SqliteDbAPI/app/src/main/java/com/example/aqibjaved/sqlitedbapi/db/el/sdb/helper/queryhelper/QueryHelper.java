package com.example.aqibjaved.sqlitedbapi.db.el.sdb.helper.queryhelper;

import com.example.aqibjaved.sqlitedbapi.db.el.sdb.contract.struct.DBContract;

/**
 * Created by AQIB JAVED on 8/19/2017.
 */

public final class QueryHelper {
    private QueryHelper(){

    }
    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + DBContract.DBEntry.TABLE_NAME + " (" + DBContract.DBEntry._ID + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL," + DBContract.DBEntry.COLUMN_USERNAME + " TEXT," + DBContract.DBEntry.COLUMN_USER_PASSWORD + " TEXT);";
    public static final String SQL_READ_TABLE = "SELECT * FROM "+DBContract.DBEntry.TABLE_NAME;
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.DBEntry.TABLE_NAME;

}
