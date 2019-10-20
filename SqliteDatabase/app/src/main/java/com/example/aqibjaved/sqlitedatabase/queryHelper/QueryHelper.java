package com.example.aqibjaved.sqlitedatabase.queryHelper;

import android.provider.BaseColumns;

import com.example.aqibjaved.sqlitedatabase.com.example.aqibjaved.sqlitedatabase.contract.DbContract;

/**
 * Created by AQIB JAVED on 11/19/2017.
 */

public final class QueryHelper {
    private QueryHelper() {

    }
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DbContract.DbEntry.USER_TABLE_NAME + " (" +
                    DbContract.DbEntry._ID + " INTEGER PRIMARY KEY," +
                    DbContract.DbEntry.USERNAME_COLUMN + " TEXT," +
                    DbContract.DbEntry.PASSWORD_COLUMN + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DbContract.DbEntry.USER_TABLE_NAME;
}
