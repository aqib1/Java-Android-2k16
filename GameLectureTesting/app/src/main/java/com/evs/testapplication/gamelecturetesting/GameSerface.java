package com.evs.testapplication.gamelecturetesting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.Random;

/**
 * Created by AQIB JAVED on 10/20/2018.
 */

public class GameSerface extends SurfaceView implements Runnable,View.OnTouchListener{
    private SurfaceHolder holder;
    private Thread thread;
    private Random random;
    private float ballX,ballY;
    private boolean animation = false;
    public GameSerface(Context context){
        super(context);
        holder = getHolder();
        random = new Random();
        this.setOnTouchListener(this);
    }
    public void startThread(){
        animation = true;
        thread = new Thread(this);
        thread.start();
    }
    public void stopThread(){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void onPause(){
        animation = false;
    }
    public void onResume(){
        animation = true;
    }
    @Override
    public void run() {
        while(animation){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!holder.getSurface().isValid())continue;

            Canvas canvas = holder.lockCanvas();
            int red =random.nextInt(255+1);
            int blue= random.nextInt(255+1);
            int green = random.nextInt(255+1);
            canvas.drawRGB(red,blue,green);

            if(ballX!=0 && ballY!=0) {
                Bitmap ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
                canvas.drawBitmap(ball, ballX-(ball.getWidth()/2), ballY-(ball.getHeight()/2), null);
            }
                holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ballX = motionEvent.getX();
        ballY = motionEvent.getY();
        return false;
    }
}
