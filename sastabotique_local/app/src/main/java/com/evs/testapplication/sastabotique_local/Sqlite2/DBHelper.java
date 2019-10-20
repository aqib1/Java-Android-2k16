package com.evs.testapplication.sastabotique_local.Sqlite2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evs.testapplication.sastabotique_local.Dao.UserTableDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AQIB JAVED on 11/10/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context,DbContract.DBEntries.DB_NAME,null,DbContract.DBEntries.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QueryHelper.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(QueryHelper.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onUpgrade(db, oldVersion, newVersion);
    }

    public long insert(UserTableDao userTableDao){
        long id = -1;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(DbContract.UserEntries._ID, userTableDao.get_ID());
            cv.put(DbContract.UserEntries.USER_COLUMN_NAME, userTableDao.getName());
            cv.put(DbContract.UserEntries.USER_COLUMN_ADDRESS, userTableDao.getAddress());
            cv.put(DbContract.UserEntries.USER_COLUMN_CNIC, userTableDao.getCNIC());
            id = db.insert(DbContract.UserEntries.USER_TABLE_NAME, null, cv);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }
        return id;
    }
    public List<UserTableDao> getUsers(UserTableDao dao){
        List<UserTableDao> userTableDaoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] projection = {
                    DbContract.UserEntries._ID,
                    DbContract.UserEntries.USER_COLUMN_NAME,
                    DbContract.UserEntries.USER_COLUMN_ADDRESS,
                    DbContract.UserEntries.USER_COLUMN_CNIC
            };

            // Filter results WHERE "title" = 'My Title'
            String selection = DbContract.UserEntries.USER_COLUMN_CNIC + " = ?";
            String[] selectionArgs = {dao.getCNIC()};

            // How you want the results sorted in the resulting Cursor
            String sortOrder =
                    DbContract.UserEntries.USER_TABLE_NAME + " DESC";

            Cursor cursor = db.query(
                    DbContract.UserEntries.USER_TABLE_NAME,   // The table to query
                    projection,             // The array of columns to return (pass null to get all)
                    selection,              // The columns for the WHERE clause
                    selectionArgs,          // The values for the WHERE clause
                    null,                   // don't group the rows
                    null,                   // don't filter by row groups
                    sortOrder               // The sort order
            );

            try {
                while (cursor.moveToNext()) {
                    UserTableDao data = new UserTableDao();
                    data.set_ID(cursor.getInt(cursor.getColumnIndex(DbContract.UserEntries._ID)));
                    data.setName(cursor.getString(cursor.getColumnIndex(DbContract.UserEntries.USER_COLUMN_NAME)));
                    data.setAddress(cursor.getString(cursor.getColumnIndex(DbContract.UserEntries.USER_COLUMN_ADDRESS)));
                    data.setCNIC(cursor.getString(cursor.getColumnIndex(DbContract.UserEntries.USER_COLUMN_CNIC)));
                    userTableDaoList.add(data);

                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                cursor.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        return userTableDaoList;
    }

}
