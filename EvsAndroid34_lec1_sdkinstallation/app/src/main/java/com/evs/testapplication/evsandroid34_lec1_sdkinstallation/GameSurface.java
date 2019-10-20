package com.evs.testapplication.evsandroid34_lec1_sdkinstallation;

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

public class GameSurface extends SurfaceView implements Runnable,View.OnTouchListener{
    private SurfaceHolder holder;
    private Thread thread;
    private boolean animation = false;
    private Random random;
    private float ballX = 100,ballY = 100;
    private Bitmap ball;
    public GameSurface(Context context){
        super(context);
        holder = getHolder();
        random = new Random();
        ball = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        this.setOnTouchListener(this);
    }
    public void startGame(){
        animation = true;
        thread = new Thread(this);
        thread.start();
    }
    public void endGame(){
        animation = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Game sayapa
    @Override
    public void run() {
        while (animation){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!holder.getSurface().isValid()) continue;

            int red = random.nextInt(256);
            int blue = random.nextInt(256);
            int green = random.nextInt(256);
            Canvas canvas = holder.lockCanvas();
            if(holder.getSurface().isValid()) {
                canvas.drawRGB(red, blue, green);
                canvas.drawBitmap(ball,ballX,ballY,null);
                holder.unlockCanvasAndPost(canvas);
            }

        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ballX = motionEvent.getX();
        ballY = motionEvent.getY();
        return false;
    }
}
