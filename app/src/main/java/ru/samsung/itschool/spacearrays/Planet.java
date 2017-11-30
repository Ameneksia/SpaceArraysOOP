package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Planet {
    float x;
    float y;
    int pr;
    double R=150;
    float a=0;
    Bitmap pic;

    Planet(Bitmap pic){
        this.x = 180;
        this.y = 180;
        this.pr = 255;
        this.pic = pic;
    }

    void move(){
       // a+=0.001;
       // this.x += (float)R*Math.cos(a);
       // this.y += (float) R*Math.sin(a);
    }

    Paint paint = new Paint();
    Matrix matrix = new Matrix();
    void draw(Canvas canvas){
       matrix.setScale(0.5f, 0.5f);
        //Study mathematics, dear young programmer :)

        matrix.postTranslate(x, y);
       if(pr>0) paint.setAlpha(pr--);

        canvas.drawBitmap(pic, matrix, paint);
    }


}
