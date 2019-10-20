package com.example.aqibjaved.evsbatch24_lec1;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.models.SignIn;
import com.service.SignInService;

public class MainActivity extends Activity {
    private EditText username,password;
    private Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        initComponents();
        settingUpListener();

    }

    private void settingUpListener() {
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username=MainActivity.this.username.getText().toString();
                String password=MainActivity.this.password.getText().toString();
                SignInService service = new SignInService();
              boolean valid=  service.verifyCredentials(new SignIn(username,password));
                if(valid){
                    Toast.makeText(MainActivity.this,"you logged in successfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Enter your valid credentials",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void initComponents() {
        username=(EditText)findViewById(R.id.et_username);
        password=(EditText)findViewById(R.id.et_userpassword);
        signin=(Button)findViewById(R.id.btn_signin);
    }
}
