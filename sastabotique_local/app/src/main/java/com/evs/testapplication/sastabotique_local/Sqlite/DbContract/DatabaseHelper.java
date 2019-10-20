package com.evs.testapplication.sastabotique_local.Sqlite.DbContract;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AQIB JAVED on 9/22/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, FeedReaderContract.FeedEntry.DB_NAME, null, FeedReaderContract.FeedEntry.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QueryHelper.USERDETAILS_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(QueryHelper.USERDETAILS_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void insertData(int id, String userName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.USER_ID_COLUMN_OF_USERDETAILS_TABLE,id);
        values.put(FeedReaderContract.FeedEntry.USERNAME_COLUMN_OF_USERDETAILS_TABLE,userName);
        db.insert(FeedReaderContract.FeedEntry.USER_DETAILS_TABLE,null,values);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,oldVersion,newVersion);

    }
}
