package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
/**
 * Created by Анастасия on 27.11.2017.
 */

public class TestRect implements Drawable, Touchable {
    float x,y,size = 20;
    Paint p = new Paint();


    public TestRect(float x, float y) {
        this.x = x;
        this.y = y;
    }



    @Override
    public void draw(Canvas canvas) {
       // canvas.drawRect(x,y,size,p);
        canvas.drawRect(x,y,x+size,y+size,p);
    }

    @Override
    public void touch(float x, float y) {
   size+=20;
    }
}
