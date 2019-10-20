package com.evs.testapplication.sastabotique_local.Sqlite2;

import android.provider.BaseColumns;

/**
 * Created by AQIB JAVED on 11/10/2018.
 */

public final class DbContract {
    private DbContract(){

    }

    public static class DBEntries {
        public static final int DB_VERSION = 1;
        public static final String DB_NAME = "d01amdb.db";

    }

    public static class UserEntries implements BaseColumns{
        public static final String USER_TABLE_NAME = "USER";
        public static final String USER_COLUMN_NAME = "USER_COLUMN_NAME";
        public static final String USER_COLUMN_ADDRESS = "USER_COLUMN_ADDRESS";
        public static final String USER_COLUMN_CNIC = "USER_COLUMN_CNIC";
    }


}
