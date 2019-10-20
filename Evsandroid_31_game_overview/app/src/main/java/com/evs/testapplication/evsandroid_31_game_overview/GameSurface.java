package com.evs.testapplication.evsandroid_31_game_overview;

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

public class GameSurface extends SurfaceView implements Runnable,View.OnTouchListener {
    private SurfaceHolder holder;
    private float ballX, ballY;
    private Bitmap ball;
    private Thread thread;
    private boolean animation = false;
    private Random random;

    public GameSurface(Context context){
        super(context);
        this.setOnTouchListener(this);
        random = new Random();
        ball = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        ballX = 100;
        ballY = 100;
        settingUpHolder();

    }

    public void onStart(){
        startGame();
    }

    public void onStop(){
        stopGame();
    }

    private void startGame(){
        animation = true;
        thread = new Thread(this);
        thread.start();
    }
    private void stopGame() {
        animation = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void settingUpHolder() {
        holder = getHolder();
    }

    //Game ka sayapa
    @Override
    public void run() {
        while(animation){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!holder.getSurface().isValid())continue;
            int red = random.nextInt(256);
            int blue = random.nextInt(256);
            int green = random.nextInt(256);
            Canvas canvas = holder.lockCanvas();
            canvas.drawRGB(red,blue,green);
            float actualX = ballX - (ball.getWidth()/2);
            float actualY = ballY - (ball.getHeight()/2);
            canvas.drawBitmap(ball,actualX,actualY,null);
            ballX+=50;
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
