package com.evs.testapplication.sastabotique_local.evsandroid34.Database.contract;

import android.provider.BaseColumns;

/**
 * Created by AQIB JAVED on 12/29/2018.
 */

public final class DBContract {
    private DBContract(){

    }

    public static class DBEntry{
        //DB DETAILS
        public static final String DBName ="LoginDB.db";
        public static final int DBVersion = 2;

    }

    public static class LoginTableEntry implements BaseColumns{
        public static final String LOGIN_TABLE_NAME = "LOGIN_TABLE_NAME";
        public static final String LOGIN_USER_NAME = "LOGIN_USER_NAME";
        public static final String LOGIN_USER_PASSWORD = "LOGIN_USER_PASSWORD";
    }
}
