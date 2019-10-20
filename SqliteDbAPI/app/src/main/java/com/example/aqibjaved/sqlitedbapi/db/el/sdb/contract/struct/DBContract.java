package com.example.aqibjaved.sqlitedbapi.db.el.sdb.contract.struct;

import android.provider.BaseColumns;

/**
 * Created by AQIB JAVED on 8/19/2017.
 */

public final class DBContract {
    private DBContract(){

    }
    public static class DBEntry implements BaseColumns{
        public static final int DB_VERSION=1;
        public static final String DB_NAME="client.db";
        public static final String TABLE_NAME="USER";
        public static final String COLUMN_USERNAME="USERNAME";
        public static final String COLUMN_USER_PASSWORD="USERPASSWORD";

    }
}
