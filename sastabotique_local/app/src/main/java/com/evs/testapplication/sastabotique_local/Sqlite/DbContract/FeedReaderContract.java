package com.evs.testapplication.sastabotique_local.Sqlite.DbContract;

import android.provider.BaseColumns;

/**
 * Created by AQIB JAVED on 9/22/2018.
 */

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final int DB_VERSION = 1;
        public static final String DB_NAME = "students.db";
        public static final String USER_DETAILS_TABLE = "USER_DETAILS_TABLE";
        public static final String USER_ID_COLUMN_OF_USERDETAILS_TABLE="USER_ID";
        public static final String USERNAME_COLUMN_OF_USERDETAILS_TABLE="USERNAME";

    }
}
