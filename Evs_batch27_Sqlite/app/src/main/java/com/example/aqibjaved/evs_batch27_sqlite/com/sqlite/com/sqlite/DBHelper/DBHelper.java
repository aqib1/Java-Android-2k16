package com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.com.sqlite.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.model.contract.LoginModel;
import com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.queries.contract.IQueries;
import com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.schema.contract.DBContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AQIB JAVED on 3/25/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, DBContract.DBSchema.DB_NAME, null, DBContract.DBSchema.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(IQueries.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(IQueries.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public List<LoginModel> read(LoginModel model){
        if(model.getPassword().isEmpty() || model.getUsername().isEmpty())
            throw new IllegalArgumentException("Username and password required");
        SQLiteDatabase db = this.getReadableDatabase();
        List<LoginModel> data = new ArrayList<>();
        String [] projections ={
                DBContract.DBSchema._ID,
                DBContract.DBSchema.USERNAME_COLUMN,
                DBContract.DBSchema.USERNAME_PASSWORD,
                DBContract.DBSchema.USERNAME_EMAIL
        };
        String selection = DBContract.DBSchema.USERNAME_COLUMN+"= ? and "+DBContract.DBSchema.USERNAME_PASSWORD+" = ?";
        String [] selectionArgs={model.getUsername(),model.getPassword()};
        Cursor cursor=db.query(DBContract.DBSchema.LOGIN_TABLE,projections,selection,selectionArgs,null,null,null);

        while(cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex(DBContract.DBSchema._ID));
            String name= cursor.getString(cursor.getColumnIndex(DBContract.DBSchema.USERNAME_COLUMN));
            String password= cursor.getString(cursor.getColumnIndex(DBContract.DBSchema.USERNAME_PASSWORD));
            String email= cursor.getString(cursor.getColumnIndex(DBContract.DBSchema.USERNAME_EMAIL));
            LoginModel loginModel = new LoginModel(id,name,password,email);
            data.add(loginModel);
        }
        cursor.close();
        db.close();
        return data;
    }

    public void insert(LoginModel model){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.DBSchema._ID,model.getId());
        contentValues.put(DBContract.DBSchema.USERNAME_COLUMN,model.getUsername());
        contentValues.put(DBContract.DBSchema.USERNAME_PASSWORD,model.getPassword());
        contentValues.put(DBContract.DBSchema.USERNAME_EMAIL,model.getEmail());
        db.insert(DBContract.DBSchema.LOGIN_TABLE,null,contentValues);
        db.close();
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,oldVersion,newVersion);
    }
}
