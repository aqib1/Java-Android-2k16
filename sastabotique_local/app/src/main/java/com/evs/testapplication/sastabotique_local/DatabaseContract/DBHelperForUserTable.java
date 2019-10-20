package com.evs.testapplication.sastabotique_local.DatabaseContract;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evs.testapplication.sastabotique_local.Dao.UserEntityTable;

/**
 * Created by AQIB JAVED on 11/18/2018.
 */

public class DBHelperForUserTable extends SQLiteOpenHelper {

    public DBHelperForUserTable(Context context){
        super(context,DbContract.DBEntery.DATABASE_NAME,null,DbContract.DBEntery.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QueryHelper.SQL_CREATE_USER_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(QueryHelper.SQL_DELETE_USER_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public long writeData(UserEntityTable table){
        SQLiteDatabase db = this.getWritableDatabase();
        long row = -1;
        try {
            ContentValues cv = new ContentValues();
            cv.put(DbContract.UserEntery._ID, table.getId());
            cv.put(DbContract.UserEntery.USER_USERNAME_COLUMN, table.getName());
            cv.put(DbContract.UserEntery.USER_PASSWORD_COLUMN, table.getPassword());
            cv.put(DbContract.UserEntery.USER_CNIC_COLUMN, table.getCNIC());
           row = db.insert(DbContract.UserEntery.USER_TABLE_NAME,null,cv);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }
    return row;
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,oldVersion,newVersion);
    }
}
