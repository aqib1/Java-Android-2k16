package com.evs.testapplication.sastabotique_local.DatabaseContract;

import android.provider.BaseColumns;

/**
 * Created by AQIB JAVED on 11/18/2018.
 */

public final class DbContract {
    private DbContract(){

    }
    public static class DBEntery {
        public static final String DATABASE_NAME="C01CIT.db";
        public static final int DATABASE_VERSION=1;
    }
    public static class UserEntery implements BaseColumns {
        public static final String USER_TABLE_NAME="USERS";
        public static final String USER_USERNAME_COLUMN="USERNAME";
        public static final String USER_PASSWORD_COLUMN="PASSWORD";
        public static final String USER_CNIC_COLUMN="CNIC";

    }
    public static class ApplicationUrlsEntry implements BaseColumns{
        public static final String APPLICATION_URLS="URL";
        public static final String APPLICATION_ID_MAPPED = "ID_MAPPED";
    }
}
