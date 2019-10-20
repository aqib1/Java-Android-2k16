package com.example.aqibjaved.sqlitedatabase.SqliteHelperPkg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.aqibjaved.sqlitedatabase.Entity.UserEntity;
import com.example.aqibjaved.sqlitedatabase.com.example.aqibjaved.sqlitedatabase.contract.DbContract;
import com.example.aqibjaved.sqlitedatabase.queryHelper.QueryHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by AQIB JAVED on 11/19/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private Context context = null;
    public DbHelper(Context context){
        super(context, DbContract.DbEntry.DB_NAME,null,DbContract.DbEntry.DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QueryHelper.SQL_CREATE_ENTRIES);
    }
    public void insert(UserEntity entity){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContract.DbEntry._ID, entity.getId());
        contentValues.put(DbContract.DbEntry.USERNAME_COLUMN,entity.getUserName());
        contentValues.put(DbContract.DbEntry.PASSWORD_COLUMN,entity.getUserPassword());
        db.insert(DbContract.DbEntry.USER_TABLE_NAME,null,contentValues);
        db.close();
    }
    private List<UserEntity> read(String [] projection,String selection,String[] selectionArgs,String sortOrder){
        SQLiteDatabase db = getReadableDatabase();
        List<UserEntity> data = new ArrayList<>();
        Cursor cursor =db.query(DbContract.DbEntry.USER_TABLE_NAME,projection,null,null,null,null,null,null);
        while(cursor.moveToNext()){
            UserEntity entity = new UserEntity();
            entity.setId(cursor.getInt(cursor.getColumnIndex(DbContract.DbEntry._ID)));
            entity.setUserName(cursor.getString(cursor.getColumnIndex(DbContract.DbEntry.USERNAME_COLUMN)));
            entity.setUserPassword(cursor.getString(cursor.getColumnIndex(DbContract.DbEntry.PASSWORD_COLUMN)));
            data.add(entity);
        }
        cursor.close();
        db.close();
        return data;
    }
    public List<UserEntity> readSelection(UserEntity entity){
        if(entity == null){
            Toast.makeText(context,"Selection args are not found",Toast.LENGTH_LONG).show();
            return null;
        }
        if(entity.getId() == null && entity.getUserName() == null && entity.getUserPassword() == null){
            Toast.makeText(context,"Selection args are not found",Toast.LENGTH_LONG).show();
            return null;
        }
        String projection[]={
                DbContract.DbEntry._ID,
                DbContract.DbEntry.USERNAME_COLUMN,
                DbContract.DbEntry.PASSWORD_COLUMN
        };
        int size = 0;
        if(entity.getId() != null){
            size++;
        }
        if(entity.getUserName() !=null){
            size++;
        }
        if(entity.getUserPassword() !=null){
            size++;
        }
        String selection = "";
        String selectionArgs[] = new String[size];
        if(entity.getId() != null){
            selection += DbContract.DbEntry._ID +" = ? ";
            selectionArgs[0] = Integer.toString(entity.getId());
        }
        if(entity.getUserName() !=null){
            selection += DbContract.DbEntry.USERNAME_COLUMN +" = ? ";
            selectionArgs[1] = entity.getUserName();
        }
        if(entity.getUserPassword() !=null){
            selection += DbContract.DbEntry.PASSWORD_COLUMN +" = ? ";
            selectionArgs[2] = entity.getUserPassword();
        }
        return read(projection,selection,selectionArgs,null);
    }
    public List<UserEntity> readAll(){
        String projection[]={
                DbContract.DbEntry._ID,
                DbContract.DbEntry.USERNAME_COLUMN,
                DbContract.DbEntry.PASSWORD_COLUMN
        };
        return read(projection,null,null,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(QueryHelper.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
