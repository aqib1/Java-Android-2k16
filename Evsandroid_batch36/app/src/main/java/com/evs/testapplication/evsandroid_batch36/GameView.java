package com.evs.testapplication.evsandroid_batch36;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by AQIB JAVED on 1/13/2019.
 */

public class GameView extends SurfaceView implements Runnable{

    private SurfaceHolder holder;
    private boolean isRunning = false;
    private static final int frames = 175;
    private static final int seconds = 5;
    private Bitmap image;
    private Thread t1;
    private float sX = 100,sY = 100;
    private static final int fps = (frames / seconds);
    public GameView(Context context) {
        super(context);
        initHolder();
        initSprite();
        gameThread();

    }

    private void initSprite() {
        image = BitmapFactory.decodeResource(getResources(),R.drawable.even);
    }

    private void gameThread() {
        t1 = new Thread(this);
    }

    private void initHolder() {
        this.holder = this.getHolder();
    }

    public void startGame(){
        isRunning = true;
        t1.start();
    }

    public void stopGame(){
        isRunning = false;
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (isRunning){
            sleep();
            if(!isSurfaceValid()) continue;
            Canvas canvas = getCanvas();
            canvas.drawRGB(255,0,0);
            canvas.drawBitmap(image,sX,sY,null);
            unLockAndWriteCanvas(canvas);

            animation();
        }
    }

    private void animation() {
        sX+=2;sY+=2;
    }

    private void unLockAndWriteCanvas(Canvas canvas) {
        this.holder.unlockCanvasAndPost(canvas);
    }


    private void sleep() {
        try {
            Thread.sleep(fps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isSurfaceValid() {
        return this.holder.getSurface().isValid();
    }

    public Canvas getCanvas() {
        return this.holder.lockCanvas();
    }
}
