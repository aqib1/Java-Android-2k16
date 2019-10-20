package com.example.aqibjaved.sqlitedbapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aqibjaved.sqlitedbapi.db.el.sdb.helper.dbhelper.DbHelper;
import com.example.aqibjaved.sqlitedbapi.sqlite.entities.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        User user= new User("aqib","123456");
//        DbHelper helper= new DbHelper(this);
//        helper.insertData(user);
//        helper.close();
        helper = new DbHelper(this);
        List<User> users= helper.getUsers();
        if(users==null) Toast.makeText(this, "Database is empty", Toast.LENGTH_SHORT).show();
//        else //todo
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.close();
    }
}
