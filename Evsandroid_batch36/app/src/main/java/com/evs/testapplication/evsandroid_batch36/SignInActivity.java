package com.evs.testapplication.evsandroid_batch36;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by AQIB JAVED on 12/22/2018.
 */

public class SignInActivity extends Activity {

    private EditText username, password;
    private Button signin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin_activity);
        initComponents();
        settingUpListeners();

        NotificationFragment fragment = new NotificationFragment();


        FragManagerSingletonClass.getInstance().init(this).add(fragment,AppConsts.FRAGMENT_NOTIFICATION_NAME);
        NotificationFragment fragment1 = new NotificationFragment();
        FragManagerSingletonClass.getInstance().remove(fragment).add(fragment1,AppConsts.FRAGMENT_NOTIFICATION_NAME);

        FragManagerSingletonClass.getInstance().replace(fragment,R.id.fragmentContainer);



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String userName = this.username.getText().toString();
        if(!AppConsts.isEmptyOrNullString(userName))
        outState.putString(AppConsts.SHARED_PREF_USER_NAME_KEY,userName);
        String password = this.password.getText().toString();
        if(!AppConsts.isEmptyOrNullString(password))
        outState.putString(AppConsts.SHARED_PREF_USER_PASSWORD_KEY,password);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        String userName = savedInstanceState.getString(AppConsts.SHARED_PREF_USER_PASSWORD_KEY);
        String password = savedInstanceState.getString(AppConsts.SHARED_PREF_USER_PASSWORD_KEY);

        this.username.setText(userName);
        this.password.setText(password);

    }

    private void initComponents() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.btn_sigin);

    }

    private void settingUpListeners() {
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    UserBean bean = getValidUserBean();

                    SharedPrefHolderSingleton.getInstance()
                            .save(bean);


                }catch (IllegalArgumentException e){
                    Toast.makeText(SignInActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private UserBean getValidUserBean() {
        String userName = this.username.getText().toString();
        String password = this.password.getText().toString();
        if(AppConsts.isEmptyOrNullString(userName) || AppConsts.isEmptyOrNullString(password)){
            throw new IllegalArgumentException("Please enter both fields");
        }
        return new UserBean(userName,password);
    }
}
