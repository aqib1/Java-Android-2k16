package com.evs.testapplication.sastabotique_local.evsandroid36.httpclients;

import android.os.AsyncTask;

import com.evs.testapplication.sastabotique_local.AppConts;
import com.evs.testapplication.sastabotique_local.evsandroid36.dto.LoginDto;
import com.evs.testapplication.sastabotique_local.evsandroid36.dto.Response;
import com.evs.testapplication.sastabotique_local.evsandroid36.dto.UserDto;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * Created by AQIB JAVED on 1/26/2019.
 */

public class AuthHttpClient extends AsyncTask<LoginDto, Void , Response> {


    @Override
    protected Response doInBackground(LoginDto... loginDtos) {
        URL url = null;
        HttpURLConnection urlConnection = null;
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader reader = null;
        StringBuilder responseBuild = new StringBuilder();
        Response response = null;
        try {
            url = new URL(AppConts.URL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(AppConts.POST_METHOD);
            urlConnection.setRequestProperty(AppConts.CONTENT_TYPE_PARAM,AppConts.CONTENT_TYPE_JSON+"; "+AppConts.CHARSET_UTF_8);
            outputStream = urlConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream, AppConts.UTF_8);
           JSONObject requestObj =  parseLoginDtoToJSON(loginDtos);
            outputStreamWriter.write(requestObj.toString());
            outputStreamWriter.flush();
            urlConnection.connect();
            if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    responseBuild.append(line);
                }
               response = reponseToJsonAndResponseObj(responseBuild.toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
                outputStream.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    private Response reponseToJsonAndResponseObj(String s) throws JSONException {
        JSONObject jsonObject = new JSONObject(s);
        Response response = new Response();
        response.setResponse_code(jsonObject.getInt("responseCode"));
        response.setMessage(jsonObject.getString("message"));
        UserDto user = new UserDto();
        user.setUserName(jsonObject.getString("userDto.userName"));
        user.setUserId(jsonObject.getInt("userDto.userId"));
        response.setUserDto(user);
        return response;
    }

    private JSONObject parseLoginDtoToJSON(LoginDto... loginDtos) throws JSONException {
        JSONObject jsonObject = null;
        if(loginDtos.length > 0){
            LoginDto dto = loginDtos[0];
            jsonObject = new JSONObject();
            jsonObject.accumulate("userName",dto.getUserName());
            jsonObject.accumulate("password", dto.getUserPassword());

        }
        return jsonObject;
    }
}
