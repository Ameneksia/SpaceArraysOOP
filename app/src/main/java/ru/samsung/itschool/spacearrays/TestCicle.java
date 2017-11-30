package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Paint;



/**
 * Created by Анастасия on 27.11.2017.
 */

public class TestCicle implements Drawable {
    float x,y, r=10;
    Paint p = new Paint();

    TestCicle(float x, float y){
        this.x = x;
        this.y = y;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(x,y,r,p);
    }
}
