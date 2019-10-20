package com.evs.testapplication.sastabotique_local.signinauthentication;

import android.os.AsyncTask;

import com.evs.testapplication.sastabotique_local.AppConts;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AQIB JAVED on 9/2/2018.
 */

public class SigninToRestApi extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... params) {
        String userIdOrEmail = params[0];
        String password = params[1];
        StringBuilder builder = new StringBuilder();

        JSONObject jsonObject = new JSONObject();
        try {
            if (userIdOrEmail.contains("@")) {
                jsonObject.accumulate("email", userIdOrEmail);
            } else {
                jsonObject.accumulate("userId", userIdOrEmail);
            }
            jsonObject.accumulate("password",password);
        }catch (JSONException e){
            e.printStackTrace();
        }
        try {
            URL url = new URL(AppConts.URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            writer.write(jsonObject.toString());
            writer.flush();
            outputStream.close();
            writer.close();
            httpURLConnection.connect();
            int statusCode = httpURLConnection.getResponseCode();
            if(statusCode == HttpURLConnection.HTTP_OK) {
                String response = "";
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while ((response = reader.readLine()) != null) {
                    builder.append(response);
                }
                reader.close();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject1 = new JSONObject(builder.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
