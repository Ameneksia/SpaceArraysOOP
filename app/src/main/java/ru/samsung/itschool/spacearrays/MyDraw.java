package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MyDraw extends View implements View.OnClickListener{

	ArrayList objects = new ArrayList();

	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
	//	makeSky();
	//	this.rocket = new Rocket(BitmapFactory.decodeResource(getResources(), R.drawable.rocket));
	//	this.rocket2 = new Rocket(BitmapFactory.decodeResource(getResources(), R.drawable.rocket));
	//	this.planet = new Planet(BitmapFactory.decodeResource(getResources(), R.drawable.planet));
	//	this.CRocket = new ControlledRocket(BitmapFactory.decodeResource(getResources(), R.drawable.rocket));

		Button button = (Button) findViewById(R.id.TestBut);
		button.setOnClickListener(this);

		objects.add(new TestCicle(50,50));
		objects.add(new TestCicle(250,200));
		objects.add(new TestRect(90,30));
		objects.add(new TestRect(10,175));


	}

	//Rocket rocket, rocket2;
	ControlledRocket CRocket;
Planet planet;

	Paint paint = new Paint();
	@Override
	protected void onDraw(Canvas canvas) {
		
	//	drawSky(canvas);

		for(Object obj: objects){
			if(obj instanceof Drawable)
				((Drawable) obj).draw(canvas);
		}

	//	planet.draw(canvas);
	//	rocket.draw(canvas);
	//	rocket2.draw(canvas);
	//	rocket.move();
	//	rocket2.move();

	//	planet.move();
	//	CRocket.draw(canvas);
	//	CRocket.move();

		// Запрос на перерисовку экрана
		invalidate();
	}
	
	final int numStars = 500;
	
	int xStar[] = new int[numStars];
	int yStar[] = new int[numStars];
	int alphaStar[] = new int[numStars];
	
	void makeSky()
	{
		// Звезды генерируются в зоне maxX на maxY
		int maxX = 2000;
		int maxY = 2000;
		for (int i = 0; i < numStars; i++)
		{	
		   xStar[i] = (int)(Math.random() * maxX);
		   yStar[i] = (int)(Math.random() * maxY);
		   alphaStar[i] = (int)(Math.random() * 256);
		}   
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		for(Object obj: objects) {
			if (obj instanceof Touchable)
				((Touchable) obj).touch(event.getX(), event.getY());
		}
		//CRocket.setTarget(event.getX(),event.getY());
		return super.onTouchEvent(event);
	}
	
	void drawSky(Canvas canvas)
	{
		canvas.drawColor(Color.BLACK);
		paint.setColor(Color.YELLOW);
		paint.setStrokeWidth(2);
		for (int i = 0; i < numStars; i++)
		{	
		   paint.setAlpha(alphaStar[i]);
		   alphaStar[i] += (int)(Math.random() * 11) - 5;
		   if (alphaStar[i] > 255) alphaStar[i] = 255;
		   if (alphaStar[i] < 0) alphaStar[i] = 0;
		   canvas.drawCircle(xStar[i], yStar[i], 3, paint);
		}   
	}


	@Override
	public void onClick(View view) {
		for(int i= 0 ;i< 10; i++){
			objects.add(new TestRect(i*30,i*30));
		}
	}
}
