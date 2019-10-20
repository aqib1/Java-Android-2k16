package com.evs.testapplication.evsandroid34_lec1_sdkinstallation;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by AQIB JAVED on 10/28/2018.
 */
//extends ListActivity
public class SettingsActivity extends Activity {
    private ImageView titleImage;
    private ListView listView;
    private String [] listItems = {"Home","About us","Contact us","Sign up","Sign in","Exit"};
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listactivity);
        initComponents();
//        adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,listItems);
//        setListAdapter(adapter);
    }

    private void initComponents() {
        titleImage = findViewById(R.id.title_image);
        listView = findViewById(R.id.settingsList);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:{
                        titleImage.setImageResource(R.mipmap.ic_launcher);
                        break;
                    }
                }
            }
        });
    }

//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        switch (position){
//            case 0:{
//                Intent intent = new Intent(SettingsActivity.this,HomeActivity.class);
//                startActivity(intent);
//                break;
//            }
//            case 5:{
//                finish();
//                break;
//            }
//        }
//    }
}
