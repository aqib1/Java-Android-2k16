package com.example.iqvis.evlearning_batch14_httpget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {
    private EditText name,password,con_password;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=MainActivity.this.name.getText().toString();
                String pass=password.getText().toString();
                String confirmPass=con_password.getText().toString();
                if(name.equals("") | pass.equals("") | confirmPass.equals("")){
                    Toast.makeText(MainActivity.this, "ALL Fields Are Required", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(confirmPass)){
//                        android.os.StrictMode.ThreadPolicy policy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
//                        android.os.StrictMode.setThreadPolicy(policy);
                         RegisterAPI registerAPIViaGet= new RegisterAPI();
                        registerAPIViaGet.execute(name, pass);
                        try {
                            String resp=(String)registerAPIViaGet.get();
                            Toast.makeText(MainActivity.this, ""+resp, Toast.LENGTH_SHORT).show();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "password not same", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }

    private void initComponents() {
        name=(EditText)findViewById(R.id.editText_name);
        password=(EditText)findViewById(R.id.editText_password);
        con_password=(EditText)findViewById(R.id.editText_conPassword);
        signup=(Button)findViewById(R.id.btn_signup);

    }
}
