package com.example.aqibjaved.torchandsmsapp;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    private ToggleButton tb;
    private Camera camera;
    private Camera.Parameters parameters;
    private Button sendMessage;
    private EditText number,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkForRunTimePermissions();
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num= number.getText().toString();
                String mess=message.getText().toString();
                if(num.isEmpty() || mess.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter number and message first", Toast.LENGTH_SHORT).show();
                }else{
                    SmsManager smsManager= SmsManager.getDefault();
                    try{
                        smsManager.sendTextMessage(num,null,mess,null,null);
                        Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb.isChecked()){
                    torchOn();
                }else{
                    torchOff();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        torchOff();
        stopCamera();
    }

    private void torchOff() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.stopPreview();
        tb.setChecked(false);
    }
    private void stopCamera(){
        camera.release();
    }
    private void torchOn() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
    }

    private void initComponents() {
        tb = findViewById(R.id.tb_1);
        sendMessage = findViewById(R.id.button);
        message= findViewById(R.id.editText);
        number = findViewById(R.id.editText2);
    }

    private void initCamera(){
        camera = Camera.open();
        parameters = camera.getParameters();
    }
    private void checkForRunTimePermissions() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Constants.runtimePermissions[0])
                    != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Constants.runtimePermissions[1])
                            != PackageManager.PERMISSION_GRANTED

                    ){
                requestPermissions(Constants.runtimePermissions,Constants.requestCodeForRuntimePermissions);
            }else{
                initCamera();
            }
        }else{
            initCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case Constants.requestCodeForRuntimePermissions:{
                if(grantResults[0]== PackageManager.PERMISSION_GRANTED
                    &&
                        grantResults[1]== PackageManager.PERMISSION_GRANTED
                        ){
                    initCamera();
                }else{
                    Toast.makeText(this, "You cannot use this application without camera permission", Toast.LENGTH_SHORT).show();
                    finish();
                }

                break;
            }


        }

    }
}
