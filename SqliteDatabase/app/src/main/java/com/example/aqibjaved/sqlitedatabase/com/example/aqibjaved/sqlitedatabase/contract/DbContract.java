package com.example.aqibjaved.sqlitedatabase.com.example.aqibjaved.sqlitedatabase.contract;

import android.provider.BaseColumns;

/**
 * Created by AQIB JAVED on 11/19/2017.
 */

public final class DbContract {
    private DbContract(){

    }
    public static class DbEntry implements BaseColumns{
        public static final String DB_NAME="user.db";
        public static final String USER_TABLE_NAME = "USER_TABLE";
        public static final String USERNAME_COLUMN = "USERNAME_COLUMN";
        public static final String PASSWORD_COLUMN = "USERNAME_PASSWORD";
        public static final int DATABASE_VERSION = 0;

    }
}
