package com.example.iqvis.evlearning_batch14_httpget;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IQVIS on 11/20/2016.
 */
public class RegisterAPIViaPost extends AsyncTask {
    @Override
    protected Object doInBackground(Object ...objects) {
















        String name=(String)objects[0];
        String password=(String)objects[1];
        URLConnection connection=null;
        URL url=null;
        StringBuilder builder=null;
        OutputStreamWriter writer= null;
        BufferedReader reader=null;
        String data="";
        try {
            data=URLEncoder.encode("name","UTF-8")+"="+
                 URLEncoder.encode(name,"UTF-8")+"&"+
                 URLEncoder.encode("password","UTF-8")+"="+
                 URLEncoder.encode(password,"UTF-8");
            url = new URL(AppConsts.initAddr_POST);
            connection=url.openConnection();
            connection.setDoOutput(true);
            writer= new OutputStreamWriter(connection.getOutputStream());
            writer.write(data);
            writer.flush();
            reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            builder= new StringBuilder();
            String line="";
            while((line=reader.readLine())!=null){
                builder.append(line);
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        String name=(String)objects[0];
//        String password=(String)objects[1];
//        StringBuilder builder=null;
//        URLConnection connection=null;
//        URL url=null;
//        OutputStreamWriter writer=null;
//        BufferedReader reader= null;
//        String data=null;
//
//        try {
//            data=URLEncoder.encode("name","UTF-8")+"="+
//                 URLEncoder.encode(name,"UTF-8")+"&"+
//                 URLEncoder.encode("password","UTF-8")+
//                 URLEncoder.encode(password,"UTF-8")
//            ;
//            url= new URL(AppConsts.initAddr_POST);
//            connection=url.openConnection();
//            connection.setDoOutput(true);
//            writer= new OutputStreamWriter(connection.getOutputStream());
//            writer.write(data);
//            writer.flush();
//            reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            builder= new StringBuilder();
//            String line="";
//            while((line=reader.readLine())!=null){
//                builder.append(line);
//            }
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                writer.close();
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }


//        URL url= null;
//        URLConnection connection=null;
//        OutputStreamWriter writer=null;//for sending request
//        BufferedReader reader= null;//for reading response
//        StringBuilder builder= null;
//        String data="";
//        try {
//            data=URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&" +
//                    URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        try {
//            url = new URL(AppConsts.initAddr_POST);
//            connection=url.openConnection();
//            connection.setDoOutput(true);
//            writer= new OutputStreamWriter(connection.getOutputStream());
//            writer.write(data);
//            writer.flush();
//            reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line="";
//            builder= new StringBuilder();
//            while((line=reader.readLine())!=null){
//                builder.append(line);
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                writer.close();
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


//
//        String name=(String)objects[0];
//        String password=(String)objects[1];
//        URL url=null;
//        URLConnection urlConnection=null;
//        OutputStreamWriter writer=null;
//        StringBuilder builder = null;
//        BufferedReader reader = null;
//        String data;
//        try {
//            data=URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&" +
//                    URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
//            try {
//                url=new URL(AppConsts.initAddr_POST);
//                urlConnection=url.openConnection();
//                urlConnection.setDoOutput(true);
//                writer= new OutputStreamWriter(urlConnection.getOutputStream());
//                writer.write(data);
//                writer.flush();
//                reader= new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                String line;
//                builder= new StringBuilder();
//                while ((line=reader.readLine())!=null){
//                    builder.append(line);
//                }
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                try {
//                    writer.close();
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        String username=(String)objects[0].toString();
//        String userpassword=(String)objects[1].toString();
//        StringBuilder builder = new StringBuilder();
//        URLConnection urlConnection=null;
//        OutputStreamWriter writer= null;
//        URL url=null;
//        BufferedReader reader = null;
//        String data="";
//        try {
//            data=URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")
//            +"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(userpassword,"UTF-8");
//            ;
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            url = new URL(AppConsts.initAddr_POST);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        try {
//            urlConnection=url.openConnection();
//            urlConnection.setDoOutput(true);
//            writer= new OutputStreamWriter(urlConnection.getOutputStream());
//            writer.write(data);
//            writer.flush();
//            reader= new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//            String line="";
//            while ((line=reader.readLine())!=null){
//                builder.append(line);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                writer.close();
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
        return builder.toString();
    }
}
