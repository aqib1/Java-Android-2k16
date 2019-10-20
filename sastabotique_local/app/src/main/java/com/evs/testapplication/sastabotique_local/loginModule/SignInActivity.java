package com.evs.testapplication.sastabotique_local.loginModule;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;

import com.evs.testapplication.sastabotique_local.AppConts;
import com.evs.testapplication.sastabotique_local.CacheManagment.SharedPrefCacheManagment;
import com.evs.testapplication.sastabotique_local.R;
import com.evs.testapplication.sastabotique_local.signinauthentication.SigninToRestApi;
import com.evs.testapplication.sastabotique_local.signinauthentication.Test;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by AQIB JAVED on 8/18/2018.
 */

public class SignInActivity extends Activity {
    private LinearLayout signinForm,signupForm;
    private EditText userId, password, r_userId, r_password;
    private Button signIn, register;
    private ImageView handle;

    private SlidingDrawer drawer;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);
        initComponents();
        settingUplisteners();
    }

    private void settingUplisteners() {
        SharedPreferences sp=getSharedPreferences("CSRF_TOKKEN_CACHE",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("CSRF","sjfwkjgwghe");
        editor.commit();
        String csrf = sp.getString("CSRF","Not Found");


        drawer.setOnDrawerOpenListener(()->{
            formAvailability(false,true);
            handle.setImageResource(R.drawable.double_down);
        });

        drawer.setOnDrawerCloseListener(()->{
            formAvailability(true,false);
            handle.setImageResource(R.drawable.double_up);
        });

        signIn.setOnClickListener((e)->{
            String useridOrEmail = this.userId.getText().toString();
            String password = this.password.getText().toString();
//            UsersRequest usersRequest = new UsersRequest();
            Test test = new Test();
//            test.execute(usersRequest);
                runOnUiThread(()->{
                    try {
                        test.get();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    } catch (ExecutionException e1) {
                        e1.printStackTrace();
                    }
                });

            SigninToRestApi signinToRestApi = new SigninToRestApi();
            signinToRestApi.execute(useridOrEmail,password);
            try {
                String response = signinToRestApi.get();
                JSONObject jsonObject = new JSONObject(response);
                int statusCode = (int) jsonObject.getInt("STATUS_CODE");
                if(statusCode == 200){
                    String userId = jsonObject.getString("payload.userId");
                    String CSRF_Tokken = jsonObject.getString("CSRF_TOKEN");
                        SharedPrefCacheManagment.
                            getSharedPrefCacheManagment().
                                save(CSRF_Tokken, AppConts.CSRF_TOKKEN_SHARED_PREF_KEY);

                    SharedPrefCacheManagment.getSharedPrefCacheManagment().get(AppConts.CSRF_TOKKEN_SHARED_PREF_KEY,"");
                }



//                String userid= (String)jsonObject.get("payLoad.userId");

//                Toast.makeText(this, jsonObject.getString("userId"), Toast.LENGTH_SHORT).show();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            } catch (JSONException e1) {
                e1.printStackTrace();
            }


//            SigninAuth signinAuth = new SigninAuth();
//            signinAuth.execute("http://192.168.10.3:8080/y/test");
//            try {
//                String result = signinAuth.get();
//                JSONObject jsonObject = new JSONObject(result);
//                Toast.makeText(this, jsonObject.getString("name"), Toast.LENGTH_SHORT).show();
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            } catch (ExecutionException e1) {
//                e1.printStackTrace();
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
        });
    }
    private void formAvailability(boolean signinfrom, boolean signupform){
        signinForm.setClickable(signinfrom);
        signupForm.setClickable(signupform);
    }
    private void initComponents() {
        drawer = findViewById(R.id.signupdrawer);
        userId = findViewById(R.id.username_edittext);
        r_userId = findViewById(R.id.r_username);
        password = findViewById(R.id.password_edittext);
        r_password = findViewById(R.id.r_password);
        handle = findViewById(R.id.auth_handle);
        signIn = findViewById(R.id.signin_edittext);
        register = findViewById(R.id.register);
        signupForm = findViewById(R.id.registerform);
        signinForm = findViewById(R.id.signinactivity_form);
        SharedPrefCacheManagment.getSharedPrefCacheManagment()
            .setContext(SignInActivity.this.getApplicationContext()).
                init();
    }
}
