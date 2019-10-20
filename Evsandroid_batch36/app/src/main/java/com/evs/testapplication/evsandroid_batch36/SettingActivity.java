package com.evs.testapplication.evsandroid_batch36;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by AQIB JAVED on 12/9/2018.
 */

public class SettingActivity extends ListActivity {
    private String[] settingsMenus =
            {"Wifi", "Sim card","BT","Data Usage","Display brightness","Exit"};
    private ArrayAdapter<String> arrayAdapter = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position){
            case 2:{
                startService(new Intent(SettingActivity.this,MusicService.class));
                break;
            }
            case 5:{
                stopService(new Intent(SettingActivity.this,MusicService.class));
                finish();

                break;
            }
        }

    }

    private void initComponents() {
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,settingsMenus);
        this.setListAdapter(arrayAdapter);

    }
}
