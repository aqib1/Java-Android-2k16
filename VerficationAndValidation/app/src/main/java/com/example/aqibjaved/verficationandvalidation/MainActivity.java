package com.example.aqibjaved.verficationandvalidation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView username;
    private TextView password;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            initComponents();
            settingUpListeners();
        } catch (Exception e) {
            Toast.makeText(this,"Exception : "+e.getMessage(),Toast.LENGTH_LONG).show();
            finish();
        }

    }

    private void settingUpListeners() {
        submit.setOnClickListener((v)->{
            String name = username.getText().toString();
            String pass = password.getText().toString();
            Validation validation = new Validation(name,pass);
            if(validation.validateName() && validation.validatePassword()){

            }
        });
    }

    private void initComponents() throws Exception{
        username = (TextView) findViewById(R.id.et_name);
        password = (TextView) findViewById(R.id.et_password);
        submit = (Button) findViewById(R.id.btn_submit);

    }
}
