package com.example.kapusta.rectangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kapusta on 25.07.2017.
 */

public class MyView extends View {
    Paint p;
    RectF rect;
    RectF rect1;
    ArrayList<RectF> arrayRectan;

    public MyView(Context context) {
        super(context);

        float x = 100 + (float)Math.random()*300;
        float y = 100 + (float)Math.random()*300;
        p = new Paint();
        rect = new RectF(100,100,x,y);
        rect1 = new RectF(100,y + 20,100 + (float)Math.random()*300,y + 20 + (float)Math.random()*300);
        arrayRectan.add(rect);
        arrayRectan.add(rect1);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(80, 102, 204, 255);

        p.setColor(Color.BLUE);
        p.setStrokeWidth(10);

        p.setStyle(Paint.Style.STROKE);
        for(RectF rect: arrayRectan) {
            canvas.drawRect(rect, p);
        }

    }

}
