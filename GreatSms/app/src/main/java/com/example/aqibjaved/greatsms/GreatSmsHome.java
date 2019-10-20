package com.example.aqibjaved.greatsms;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GreatSmsHome extends AppCompatActivity {

    private Button sendMsg,stopMsg;
    private EditText filePath,message;
    private Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_great_sms_home);
        runtimePermissions();
        initComponents();
    }

    private void runtimePermissions() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            if (checkSelfPermission(AppConsts.permissions[0]) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(AppConsts.permissions, AppConsts.MESSAGE_PERMISSION_CODE);
            } else {
                initComponents();
            }
        }
    }

    private void initComponents() {
        sendMsg=(Button)findViewById(R.id.start_sending);
        stopMsg=(Button)findViewById(R.id.stop_sending);
        filePath=(EditText)findViewById(R.id.path_to_file);
        message=(EditText)findViewById(R.id.message);
        serviceIntent = new Intent(GreatSmsHome.this,SmsService.class);
        settingUpListener();
    }

    private void settingUpListener() {
        stopMsg.setOnClickListener(v->{
            stopService(serviceIntent);
        });
        sendMsg.setOnClickListener(v->{
            String filePath=GreatSmsHome.this.filePath.getText().toString();
            String message= GreatSmsHome.this.message.getText().toString();
            if(filePath.isEmpty() || message.isEmpty()){
                Toast.makeText(this, "Please enter file path or message first", Toast.LENGTH_SHORT).show();
            }else{
                Thread thread= new Thread(()->{
                    serviceIntent.putExtra(AppConsts.KEY_PATH,filePath);
                    serviceIntent.putExtra(AppConsts.KEY_MESSAGE,message);
                    startService(serviceIntent);
                });
                thread.start();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case AppConsts.MESSAGE_PERMISSION_CODE:
                if(grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "You Can't Use Application Without All Required Permission", Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    initComponents();
                }

                break;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
