package ru.samsung.itschool.spacearrays;


import android.graphics.Bitmap;

public class ControlledRocket extends Rocket {
  private  float targetX, targetY;

    void setTarget( float targetX, float targetY){
        this.targetX = targetX;
        this.targetY = targetY;
        setVX(targetX - getX());
        setVY( targetY - getY());
        float d = getVel();
        setVX(getVX()/d*2);
        setVY(getVY()/d*2);
    }
    ControlledRocket(Bitmap pic){
         super(pic);
    }

}
