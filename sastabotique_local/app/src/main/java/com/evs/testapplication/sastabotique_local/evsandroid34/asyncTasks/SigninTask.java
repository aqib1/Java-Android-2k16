package com.evs.testapplication.sastabotique_local.evsandroid34.asyncTasks;

import android.os.AsyncTask;

import com.evs.testapplication.sastabotique_local.evsandroid34.Responses.UserResponse;
import com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.beans.UserBean;

import org.json.JSONException;
import org.json.JSONObject;
import static com.evs.testapplication.sastabotique_local.AppConts.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AQIB JAVED on 12/1/2018.
 */

public class SigninTask extends AsyncTask<JSONObject,Void,UserResponse> {
    @Override
    protected UserResponse doInBackground(JSONObject... jsonObjects) {
        OutputStream outputStream = null;
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();
        UserResponse userResponse = null;
        try {
            URL url = new URL(URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(POST_METHOD);
            httpURLConnection.setRequestProperty(CONTENT_TYPE_PARAM,CONTENT_TYPE_JSON+"; "+CHARSET_UTF_8);
            outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream,UTF_8);
            writer.write(jsonObjects[0].toString());
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

    private UserResponse JsonToResponse(String s) throws JSONException {
        UserResponse response = new UserResponse();
        JSONObject obj = new JSONObject(s);
        response.setResponseCode(obj.getInt("responseCode"));
        response.setResponseDescription(obj.getString("responseDescription"));
        JSONObject payload = obj.getJSONObject("responseData");
        UserBean bean = new UserBean();
        bean.setUserName(payload.getString("userName"));
        bean.setPassword(payload.getString("password"));
        response.setResponseData(bean);
        return response;
    }
}
