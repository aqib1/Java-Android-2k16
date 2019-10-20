package com.example.aqibjaved.evsbatch27_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aqibjaved.evsbatch27_android.com.model.signup.User;
import com.example.aqibjaved.evsbatch27_android.com.signup.validators.SignUpValidator;

/**
 * Created by AQIB JAVED on 3/4/2018.
 */

public class SignUp extends Activity{
    private int []IDS = {R.id.et_username,R.id.et_password,R.id.et_cpassword,R.id.contactNumber,R.id.et_email};
    private EditText[] editTexts= new EditText[IDS.length];
    private Button signUp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setName(editTexts[0].getText().toString());
                user.setPassword(editTexts[1].getText().toString());
                user.setConfirmPassword(editTexts[2].getText().toString());
                user.setContactNumber(editTexts[3].getText().toString());
                user.setEmail(editTexts[4].getText().toString());
                SignUpValidator validator = new SignUpValidator();
                if(validator.allFiledEntered(user)){
                    if(validator.isValidUserName(user) && validator.isValidPassword(user) && validator.isValidNumber(user)){
                        //further


                    }else{
                        Toast.makeText(SignUp.this,"Please enter valid information",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void initComponents() {
        for(int x=0;x<IDS.length;x++){
            editTexts[x] = (EditText) findViewById(IDS[x]);
        }
        signUp = (Button)findViewById(R.id.btn_signup);
    }
}
