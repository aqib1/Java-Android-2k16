package com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.schema.contract;

import android.provider.BaseColumns;

/**
 * Created by AQIB JAVED on 3/25/2018.
 */

public final class DBContract {
    private DBContract(){

    }

    /* Inner class that defines the table contents */
    public static class DBSchema implements BaseColumns {
        public static final String DB_NAME="user.db";
        public static final int DB_VERSION=1;
        public static final String LOGIN_TABLE = "USER_LOGIN";
        public static final String USERNAME_COLUMN = "USERNAME_COLUMN";
        public static final String USERNAME_PASSWORD = "USERNAME_PASSWORD";
        public static final String USERNAME_EMAIL = "USERNAME_EMAIL";
    }

}

