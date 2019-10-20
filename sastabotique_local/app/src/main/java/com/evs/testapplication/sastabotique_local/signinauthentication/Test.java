package com.evs.testapplication.sastabotique_local.signinauthentication;

import android.os.AsyncTask;
import android.widget.Toast;

import static com.evs.testapplication.sastabotique_local.AppConts.*;
import com.evs.testapplication.sastabotique_local.Dto.UsersRequest;
import com.evs.testapplication.sastabotique_local.Dto.UsersResponse;
import com.evs.testapplication.sastabotique_local.entities.UserEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AQIB JAVED on 10/27/2018.
 */

public class Test extends AsyncTask<UsersRequest,Void,UsersResponse> {
    @Override
    protected UsersResponse doInBackground(UsersRequest... usersRequests) {
        OutputStream outputStream = null;
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();
        UsersResponse userResponse = null;
        try {
            URL url = new URL(URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(POST_METHOD);
            httpURLConnection.setRequestProperty(CONTENT_TYPE_PARAM,CONTENT_TYPE_JSON+"; "+CHARSET_UTF_8);
            outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream,UTF_8);
            writer.write(createJson(usersRequests));
            writer.flush();
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                //String desc = httpURLConnection.getResponseMessage();
                reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                userResponse = JsonToResponse(response.toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return userResponse;
    }

    private UsersResponse JsonToResponse(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setSTATUS_CODE(jsonObject.getInt("STATUS_CODE"));
        usersResponse.setSTATUS_DESCRIPTION(jsonObject.getString("STATUS_DESCRIPTION"));
        usersResponse.setCSRF_TOKEN(jsonObject.getString("CSRF_TOKEN"));
        return usersResponse;
    }

    private String createJson(UsersRequest[] usersRequests) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        UsersRequest request = usersRequests[0];
        jsonObject.accumulate("userId",request.getUserId());
        jsonObject.accumulate("email", request.getEmail());
        jsonObject.accumulate("password",request.getPassword());
        return jsonObject.toString();
    }
}
