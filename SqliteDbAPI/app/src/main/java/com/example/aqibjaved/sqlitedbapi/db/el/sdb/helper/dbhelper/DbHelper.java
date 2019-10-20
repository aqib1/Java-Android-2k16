package com.example.aqibjaved.sqlitedbapi.db.el.sdb.helper.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aqibjaved.sqlitedbapi.db.el.sdb.contract.struct.DBContract;
import com.example.aqibjaved.sqlitedbapi.db.el.sdb.helper.queryhelper.QueryHelper;
import com.example.aqibjaved.sqlitedbapi.sqlite.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AQIB JAVED on 8/20/2017.
 */

public class DbHelper extends SQLiteOpenHelper{
    public DbHelper(Context contexts){
        super(contexts, DBContract.DBEntry.DB_NAME,null, DBContract.DBEntry.DB_VERSION);
    }
    public List<User> getUsersThroughAPIMethod(String names){
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> users=null;
        String selectionColumns[]={
                DBContract.DBEntry._ID,
                DBContract.DBEntry.COLUMN_USERNAME,
                DBContract.DBEntry.COLUMN_USER_PASSWORD
        };
        String selection = DBContract.DBEntry.COLUMN_USERNAME +" = ?";
        String selectionArgs[]={names};
        String sortOrder= DBContract.DBEntry.COLUMN_USERNAME + "DESC";
        Cursor cursor = db.query(DBContract.DBEntry.TABLE_NAME,selectionColumns,selection,selectionArgs,null,null,sortOrder);
        users= getUsersInside(cursor);
        db.close();
        return users;
    }
    public void delete(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition=DBContract.DBEntry.COLUMN_USERNAME+" = ?";
        String selectionArgs[]={user.getUserName()};
        db.delete(DBContract.DBEntry.TABLE_NAME,condition,selectionArgs);
        db.close();
    }
    private List<User> getUsersInside(Cursor cursor){
        List<User> users=null;
        if(cursor.getCount()>0){
            users = new ArrayList<>();
            cursor.moveToFirst();
            do{
                User user = new User();
                user.set_id(cursor.getInt(cursor.getColumnIndex(DBContract.DBEntry._ID)));
                user.setUserName(cursor.getString(cursor.getColumnIndex(DBContract.DBEntry.COLUMN_USERNAME)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(DBContract.DBEntry.COLUMN_USER_PASSWORD)));
                users.add(user);
            }while (cursor.moveToNext());
        }
        return users;
    }
    public List<User> getUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> users=null;
        Cursor cursor=db.rawQuery(QueryHelper.SQL_READ_TABLE,null);
        users= getUsersInside(cursor);
        db.close();
        return users;
    }
    public long insertData(User user){
        long rowId=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.DBEntry.COLUMN_USERNAME,user.getUserName());
        values.put(DBContract.DBEntry.COLUMN_USER_PASSWORD,user.getPassword());
        rowId=db.insert(DBContract.DBEntry.TABLE_NAME,null,values);
        db.close();
        return rowId;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QueryHelper.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(QueryHelper.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
