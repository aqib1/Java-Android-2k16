package com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.queries.contract;

import com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.schema.contract.DBContract;

/**
 * Created by AQIB JAVED on 3/25/2018.
 */

public interface IQueries {
    String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.DBSchema.LOGIN_TABLE + " (" +
                    DBContract.DBSchema._ID + " INTEGER PRIMARY KEY," +
                    DBContract.DBSchema.USERNAME_COLUMN + " TEXT," +
                    DBContract.DBSchema.USERNAME_PASSWORD +" TEXT,"+
                    DBContract.DBSchema.USERNAME_EMAIL + " TEXT)";

   String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DBContract.DBSchema.LOGIN_TABLE;
}
