package com.evs.testapplication.sastabotique_local.evsandroid34.Database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evs.testapplication.sastabotique_local.evsandroid34.Database.contract.DBContract;
import com.evs.testapplication.sastabotique_local.evsandroid34.Database.query.QueryHelper;
import com.evs.testapplication.sastabotique_local.evsandroid34.bean.LoginBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AQIB JAVED on 12/29/2018.
 */

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context){
        super(context, DBContract.DBEntry.DBName,null,DBContract.DBEntry.DBVersion);
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

    public long save(LoginBean loginBean){
        long row = -1;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(DBContract.LoginTableEntry.LOGIN_USER_NAME, loginBean.getUserName());
            cv.put(DBContract.LoginTableEntry.LOGIN_USER_PASSWORD, loginBean.getUserPassword());
            row = db.insert(DBContract.LoginTableEntry.LOGIN_TABLE_NAME, null, cv);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }
        return row;
    }

    public List<LoginBean> getLoginInfo(){
        List<LoginBean> data = new ArrayList<>();
        SQLiteDatabase readable = this.getReadableDatabase();
        String [] projections =
                {
                        DBContract.LoginTableEntry._ID,
                        DBContract.LoginTableEntry.LOGIN_USER_NAME,
                        DBContract.LoginTableEntry.LOGIN_USER_PASSWORD

                };

        String selection = DBContract.LoginTableEntry.LOGIN_USER_NAME +" = ?";
        String selectionArgs[] = {"Test"};

        String sortOrder =
                DBContract.LoginTableEntry.LOGIN_USER_PASSWORD + " DESC";

        Cursor cursor = readable.query(DBContract.LoginTableEntry.LOGIN_TABLE_NAME,
                projections,
                selection,
                selectionArgs,null,null,sortOrder);
        while (cursor.moveToNext()){
            LoginBean loginBean = new LoginBean();
            loginBean.setUserName(cursor.getString(cursor.getColumnIndex(DBContract.LoginTableEntry.LOGIN_USER_NAME)));
            loginBean.setUserPassword(cursor.getString(cursor.getColumnIndex(DBContract.LoginTableEntry.LOGIN_USER_PASSWORD)));
            data.add(loginBean);
        }
        readable.close();
        cursor.close();

        return data;
    }


    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,oldVersion,newVersion);
    }
}
