package com.evs.testapplication.evsandroid31_sdkinstallationproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends Activity {
    private EditText name,password;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        settingUpListeners();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String name = this.name.getText().toString();
        String password = this.password.getText().toString();
//        if(name != null && !name.isEmpty()
//            &&
//                )
        outState.putString("NAME",name);
        outState.putString("PASSWORD",password);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String name = savedInstanceState.getString("NAME");
        String pass = savedInstanceState.getString("PASSWORD");
        this.name.setText(name);
        this.password.setText(pass);
    }

    private void settingUpListeners() {
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                String username = MainActivity.this.name.getText().toString();
                String password = MainActivity.this.password.getText().toString();
                Toast.makeText(MainActivity.this,"User name = "+username, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initComponents() {
        name = findViewById(R.id.edittext_username);
        password = findViewById(R.id.edittext_password);
        submit = findViewById(R.id.submit_button);
    }
}
