package com.evs.testapplication.sastabotique_local.DatabaseContract;
import com.evs.testapplication.sastabotique_local.DatabaseContract.DbContract;
/**
 * Created by AQIB JAVED on 11/18/2018.
 */

public interface QueryHelper {
      String SQL_CREATE_USER_ENTRIES =
            "CREATE TABLE " + DbContract.UserEntery.USER_TABLE_NAME + " (" +
                    DbContract.UserEntery._ID + " INTEGER PRIMARY KEY," +
                    DbContract.UserEntery.USER_USERNAME_COLUMN + " TEXT," +
                    DbContract.UserEntery.USER_CNIC_COLUMN + " TEXT," +
                    DbContract.UserEntery.USER_PASSWORD_COLUMN +" TEXT"+
                    ")";

      String SQL_DELETE_USER_ENTRIES =
            "DROP TABLE IF EXISTS " + DbContract.UserEntery.USER_TABLE_NAME;
}
