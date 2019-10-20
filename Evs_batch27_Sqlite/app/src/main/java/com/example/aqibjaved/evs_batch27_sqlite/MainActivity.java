package com.example.aqibjaved.evs_batch27_sqlite;

import android.app.Activity;
import android.os.Bundle;

import com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.com.sqlite.DBHelper.DBHelper;
import com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.model.contract.LoginModel;
import com.example.aqibjaved.evs_batch27_sqlite.com.sqlite.schema.contract.DBContract;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//https://www.tutorialspoint.com/android/index.htm
        DBHelper contract = new DBHelper(this);
//        LoginModel loginModel= new LoginModel(1,"abc","abc","abc@gmail.com");
//        contract.insert(loginModel);
        LoginModel loginModel= new LoginModel();
        loginModel.setUsername("abc");
        loginModel.setPassword("abc");
        List<LoginModel> li =contract.read(loginModel);
        contract.close();
    }
}
