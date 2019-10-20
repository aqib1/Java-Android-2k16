package com.evs.testapplication.sastabotique_local.signinauthentication;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AQIB JAVED on 9/1/2018.
 */

public class SigninAuth extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings) {
        try {
            return HttpResult(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String HttpResult(String url) throws IOException, JSONException {
        URL URL = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) URL.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("name","aqib");
        jsonObject.accumulate("password","123");
        OutputStream outputStream = urlConnection.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
        bw.write(jsonObject.toString());
        bw.flush();
        bw.close();
        outputStream.close();
        urlConnection.connect();
        String response = "No response";
        BufferedReader reader=null;
        StringBuilder builder = null;

        int res_code=urlConnection.getResponseCode();
        if(res_code == HttpURLConnection.HTTP_OK){
            reader= new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line="";
            builder= new StringBuilder();
            while((line=reader.readLine())!=null){
                builder.append(line);
            }
            response = builder.toString();
        }
        return response;
    }


}
