package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Rocket {
   private float x, y, vx, vy;
     Bitmap pic;

    void setVX(float vx){
        this.vx = vx;
    }
    void setVY(float vy){
        this.vy = vy;
    }
  protected float getVX(){
        return this.vx;
    }

    float getVY(){
        return this.vy;
    }
    //------------------------------
    float getX(){
        return this.x;
    }
    float getY(){
        return this.y;
    }


    Rocket(Bitmap pic){
        this.x = (float)(Math.random()*500);
        this.y = (float)(Math.random()*500);
        this.vx = (float)(Math.random()*11)-5;
        this.vy = (float)(Math.random()*11)-5;
        this.pic = pic;
    }

    void move(){
        this.x += this.vx;
        this.y += this.vy;
    }

    float getVel(){
        return (float)Math.sqrt(vx*vx+vy*vy);
    }

    Paint paint = new Paint();
    Matrix matrix = new Matrix();
    void draw(Canvas canvas){
        matrix.setScale(0.2f, 0.2f);
        //Study mathematics, dear young programmer :)
        matrix.postTranslate(-pic.getWidth()/10,-pic.getHeight()/10);
        matrix.postRotate((float)Math.toDegrees(Math.atan2(vy, vx)) + 45);
        matrix.postTranslate(x, y);
        paint.setAlpha(255);
        canvas.drawBitmap(pic, matrix, paint);
    }
}
