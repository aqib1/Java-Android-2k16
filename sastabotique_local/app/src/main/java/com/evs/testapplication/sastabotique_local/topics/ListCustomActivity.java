package com.evs.testapplication.sastabotique_local.topics;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.evs.testapplication.sastabotique_local.R;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by AQIB JAVED on 9/15/2018.
 */

public class ListCustomActivity extends Activity{
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<ListEntityBean> li = new ArrayList<>();
    private String [] menus={"Home","Tasks","Agile","Scrums","Settings","EXIT"};
    private EditText name;
    private Button ringMe;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listcustom_activity);
        initComponents();
        settingUpListener();

    }

    private void settingUpListener() {
//        SmsManager manager = SmsManager.getDefault();
//        manager.sendTextMessage("+923237811992",null,"Hi",null,null);

        ringMe.setOnClickListener((v)->{
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            mediaPlayer.start();

        });
        listView.setOnItemClickListener((adap,view,id,l)->{
            if(this.li.get(id).getTitle().equals("EXIT")){
                if(mediaPlayer.isPlaying())mediaPlayer.stop();
                finish();
            }
        });
    }

    private boolean isEven(Predicate<Integer> test, Integer value){
        return test.test(value);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String namVal = this.name.getText().toString();
        outState.putString("Name",namVal);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String name = savedInstanceState.getString("Name");
        this.name.setText(name);
    }

    private void initComponents() {
        ringMe = findViewById(R.id.ringMe);
        name = findViewById(R.id.name);
        listView = findViewById(R.id.menus);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.iphone_6_original);
        for(int x=0;x<menus.length;x++){
                if(isEven(p->p%2==0,x)){
                    li.add(new ListEntityBean(this.menus[x],R.drawable.even));
                }else {
                    li.add(new ListEntityBean(this.menus[x], R.drawable.odd));
                }
        }
        listView.setAdapter(new CustomAdaptor(this.li,this));




        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,menus);
        listView.setAdapter(adapter);
    }


}
