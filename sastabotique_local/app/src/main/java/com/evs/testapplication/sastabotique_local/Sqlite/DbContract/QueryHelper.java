package com.evs.testapplication.sastabotique_local.Sqlite.DbContract;

/**
 * Created by AQIB JAVED on 9/22/2018.
 */

public interface QueryHelper {
        String USERDETAILS_CREATE_TABLE =
            "CREATE TABLE " + FeedReaderContract.FeedEntry.USER_DETAILS_TABLE+ " (" +
                    FeedReaderContract.FeedEntry.USER_ID_COLUMN_OF_USERDETAILS_TABLE + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.FeedEntry.USERNAME_COLUMN_OF_USERDETAILS_TABLE + " TEXT)";
        String USERDETAILS_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.USER_DETAILS_TABLE;
}
