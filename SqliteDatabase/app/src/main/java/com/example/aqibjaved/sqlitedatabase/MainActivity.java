package com.example.aqibjaved.sqlitedatabase;

import android.app.Activity;
import android.os.Bundle;

import com.example.aqibjaved.sqlitedatabase.Entity.UserEntity;
import com.example.aqibjaved.sqlitedatabase.SqliteHelperPkg.DbHelper;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserEntity userEntity = new UserEntity(0,"aqib","123");
        DbHelper dbHelper = new DbHelper(this);
        dbHelper.insert(userEntity);
        dbHelper.close();

        DbHelper dbHelper1 = new DbHelper(this);
        List<UserEntity> list = dbHelper1.readSelection(userEntity);
        dbHelper.close();










    }
}
