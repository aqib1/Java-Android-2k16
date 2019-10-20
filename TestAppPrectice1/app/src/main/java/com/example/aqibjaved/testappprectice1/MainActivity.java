package com.example.aqibjaved.testappprectice1;

import android.Manifest;
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
    private Camera camera;
    private Camera.Parameters parameters;
    private ToggleButton tb;
    private EditText message,phone;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRuntimePermission();
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = MainActivity.this.phone.getText().toString();
                String message = MainActivity.this.message.getText().toString();
                try {
                    SmsManager manager = SmsManager.getDefault();
                    manager.sendTextMessage(number, null, message, null, null);
                    Toast.makeText(MainActivity.this,"Message sent",Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
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
        stopCamera();
    }

    private void torchOn() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
    }


    private void initComponents() {
        tb = findViewById(R.id.tb_1);
        send=findViewById(R.id.send);
        message=findViewById(R.id.message);
        phone=findViewById(R.id.number);
    }

    private void setUpRuntimePermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Consts.permissions[0]) != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Consts.permissions[1]) != PackageManager.PERMISSION_GRANTED
                    ){
                requestPermissions(Consts.permissions,Consts.permission_requestcode);
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
            case Consts.permission_requestcode:{
                if(grantResults.length > 0){
                    boolean allow = true;
                    for(int result:grantResults){
                        if(result!=PackageManager.PERMISSION_GRANTED){
                            allow = false;
                            break;
                        }
                    }
                    if(allow) {
                        initCamera();
                    }else{
                        Toast.makeText(this, "You cannot use application without camera permission", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                break;
            }
        }

    }

    private void initCamera() {
        camera = Camera.open();
        parameters = camera.getParameters();
    }
    private void stopCamera(){
        torchOff();
        camera.release();
    }

    private void torchOff() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.stopPreview();
        tb.setChecked(false);
    }
}
