package com.evs.testapplication.sastabotique_local.test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

import com.evs.testapplication.sastabotique_local.AbstractRoomDatabase.AbstractDB;
import com.evs.testapplication.sastabotique_local.R;
import com.evs.testapplication.sastabotique_local.entities.EmployeeEntity;
import com.evs.testapplication.sastabotique_local.entities.UserEntity;
import com.evs.testapplication.sastabotique_local.services.MusicService;

import java.util.List;

/**
 * Created by AQIB JAVED on 9/22/2018.
 */


public class ServiceActivity extends Activity {
    private Button startService,stopService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity_layout);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        startService.setOnClickListener(v->{
            startService(new Intent(ServiceActivity.this, MusicService.class));
        });

        stopService.setOnClickListener(v->{
            stopService(new Intent(ServiceActivity.this,MusicService.class));
        });
    }

    private void initComponents() {
        startService = findViewById(R.id.startService);
        stopService = findViewById(R.id.stopService);
        UserEntity entity = new UserEntity();
        entity.setId(1);
        entity.setUserName("aqib");

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("Ali");
        employeeEntity.setCNIC("12345678910");

        AbstractDB abstractDB = AbstractDB.getAbstractDB(this);
        abstractDB.userDao().insertAll(entity);
        abstractDB.employeeDao().insertAll(employeeEntity);

        List<UserEntity> users = abstractDB.userDao().getAllUser();
        //List<EmployeeEntity> employeeEntities = abstractDB.employeeDao().getAllEmployees();




        List<UserEntity> li = abstractDB.userDao().getAllUser();
        Toast.makeText(this, ""+li.get(0).getUserName(), Toast.LENGTH_SHORT).show();

        AbstractDB.destroyInstance();
    }
}
