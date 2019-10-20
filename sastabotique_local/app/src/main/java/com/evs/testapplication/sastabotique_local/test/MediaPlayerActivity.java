package com.evs.testapplication.sastabotique_local.test;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.evs.testapplication.sastabotique_local.AbstractRoomDatabase.AbstractDB;
import com.evs.testapplication.sastabotique_local.R;
import com.evs.testapplication.sastabotique_local.Sqlite.DbContract.DatabaseHelper;
import com.evs.testapplication.sastabotique_local.entities.UserEntity;
import com.evs.testapplication.sastabotique_local.fragments.TestFragment;
import com.evs.testapplication.sastabotique_local.services.MediaPlayerService;

import java.util.List;

/**
 * Created by AQIB JAVED on 9/22/2018.
 */

public class MediaPlayerActivity extends Activity{
    private Button startMusic, stopMusic;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_player_activity);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        startMusic.setOnClickListener(v->{
//            DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
//            helper.insertData(1,"");
//            helper.close();
//            https://medium.com/@ajaysaini.official/building-database-with-room-persistence-library-ecf7d0b8f3e9
            UserEntity entity = new UserEntity();
            entity.setId(1);
            entity.setUserName("aqib");
            AbstractDB.getAbstractDB(getApplicationContext())
                    .userDao()
                    .insertAll(entity);
            List<UserEntity> userEntities = AbstractDB.getAbstractDB(getApplicationContext())
                    .userDao()
                    .getAllUser();
            AbstractDB.destroyInstance();
            startService(new Intent(MediaPlayerActivity.this, MediaPlayerService.class));
        });
        stopMusic.setOnClickListener(v->{
            stopService(new Intent(MediaPlayerActivity.this, MediaPlayerService.class));
        });
    }

    private void initComponents() {
        startMusic = findViewById(R.id.mediaplayer_start);
        stopMusic = findViewById(R.id.mediaplayer_stop);
        attachingFragments();
    }

    private void attachingFragments() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        TestFragment testFragment = new TestFragment();
        transaction.replace(R.id.fragment_continer,testFragment);
        transaction
                .commit();


    }
}
