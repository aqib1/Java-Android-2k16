package com.evs.testapplication.sastabotique_local.Sqlite2;

/**
 * Created by AQIB JAVED on 11/10/2018.
 */

public interface QueryHelper {
      String SQL_CREATE_ENTRIES =
            "CREATE TABLE " +DbContract.UserEntries.USER_TABLE_NAME  + " (" +
                    DbContract.UserEntries._ID + " INTEGER PRIMARY KEY," +
                    DbContract.UserEntries.USER_COLUMN_NAME+ " TEXT," +
                    DbContract.UserEntries.USER_COLUMN_ADDRESS + " TEXT," +
                    DbContract.UserEntries.USER_COLUMN_CNIC + "TEXT"+
                    ")";

     String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DbContract.UserEntries.USER_TABLE_NAME;
}
