package com.example.aqibjaved.evs_batch27_customlistview_mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private String elements [] = {"Home","Signup","SignIn","Forget Password","Exit"};
    private List<ListEntity> listEntities;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMediaPlayer();
        initComponents();
    }

    private void setMediaPlayer() {
        final MediaPlayer player = MediaPlayer.create(this,R.raw.iphone_6_original);
        Thread thread = new Thread(new Runnable(){
            public void run(){
            player.start();
                try {
                    Thread.sleep(2000);
                    player.stop();
                    player.seekTo(0);
                }catch(InterruptedException e){

                }
            }
        });thread.start();
    }

    private void initComponents() {
        listView = findViewById(R.id.listView_1);
        listEntities = new ArrayList<>();
        for(int x=0;x<elements.length;x++){
            ListEntity entity = new ListEntity();
            entity.setTitle(elements[x]);
            if(x%2==0){
                entity.setId(R.drawable.even);
            }else{
                entity.setId(R.drawable.odd);
            }
            listEntities.add(entity);
        }
        listView.setAdapter(new CustumListAdaptor(listEntities,this));
    }
}
