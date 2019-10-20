package com.example.aqibjaved.greatsms;

import android.content.Context;
import android.os.Environment;
import android.telephony.SmsManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by AQIB JAVED on 9/23/2017.
 */

public class SmsHandler {
    private String message;
    private String fileName;
    private Context context;
    private SmsObserver observer;
    private boolean stopSendingMessage=false;
    public SmsHandler(){

    }
    public SmsHandler(Context context,String fileName,String message,SmsObserver smsObserver){
        this.message=message;
        this.fileName=fileName;
        this.observer=smsObserver;
        this.context=context;
    }

    public void setStopSendingMessage(boolean stopSendingMessage) {
        this.stopSendingMessage = stopSendingMessage;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void sendMessages() throws Exception {
        FileConnection connection = new FileConnection();
        connection.readFile();
    }
    private Thread messageThread;
    public void stopSendingMessageThread() throws InterruptedException {
        messageThread.join();
    }
    private class FileConnection implements SmsObserver{
        private int counter;
       public void readFile() throws Exception {
           messageThread = new Thread(()->{
               try {
                   processFile();
               } catch (Exception e) {
                   IObserver("Error occurs due to "+e.getMessage());
               }
           });messageThread.start();

       }
        private int failedMessage=0;
        private void processFile() throws Exception {
            File dir = Environment.getExternalStorageDirectory();
            File file= new File(dir,fileName);
            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line="";
                while((line=reader.readLine())!=null && !stopSendingMessage){
                     Thread.sleep(getContext().getResources().getInteger(R.integer.message_delay));
                    if(!stopSendingMessage) {
                        String number = line;
                        try {
                            SmsManager manager = SmsManager.getDefault();
                            manager.sendTextMessage(number, null, message, null, null);
                            counter++;
                            IObserver(counter + " messages sent successfully");
                        } catch (Exception e) {
                            throw new Exception("Message failed " + (++failedMessage) + "\ndue to " + e.getMessage());
                        }
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        @Override
        public void IObserver(String message) {
            observer.IObserver(message);
        }
    }
}
