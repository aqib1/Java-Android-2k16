package com.evs.testapplication.sastabotique_local.evsandroid34.Database.query;
import com.evs.testapplication.sastabotique_local.evsandroid34.Database.contract.DBContract;
/**
 * Created by AQIB JAVED on 12/29/2018.
 */

public interface QueryHelper {
     String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.LoginTableEntry.LOGIN_TABLE_NAME + " (" +
                    DBContract.LoginTableEntry._ID + " INTEGER PRIMARY KEY," +
                    DBContract.LoginTableEntry.LOGIN_USER_NAME + " TEXT," +
                    DBContract.LoginTableEntry.LOGIN_USER_PASSWORD + " TEXT)";

    String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DBContract.LoginTableEntry.LOGIN_TABLE_NAME;

}
