package com.example.iqvis.evlearning_batch14_httpget;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;




// * Created by IQVIS on 11/14/2016.
//

public class RegisterAPI extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] objects) {
        String username=(String)objects[0];
        String password=(String)objects[1];
        String link=AppConsts.initAddr+"username="+username+"&password="+password;
        try {
            URI uri= new URI(link);
            HttpClient client= new DefaultHttpClient();
            HttpGet get= new HttpGet();
            get.setURI(uri);
            HttpResponse response=client.execute(get);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String mess="";
            StringBuilder builder= new StringBuilder();
            while((mess=reader.readLine())!=null){
                builder.append(mess);
            }

            reader.close();
            return builder.toString();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
