package com.example.kapusta.rectangle.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

import com.example.kapusta.rectangle.model.MyRectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Kapusta on 25.07.2017.
 */

public class MyView extends View {
    Paint p;
    ArrayList<MyRectangle> arrayRectan = new ArrayList<>();

    public MyView(Context context) {
        super(context);

        float y = 50;
        p = new Paint();

        for (int i = 0; i < 10; i++) {
            MyRectangle mRectangle = new MyRectangle();
            float x = (float)Math.random()*400;
            float z = (float)Math.random()*100;
            mRectangle.setmRectf(new RectF(x, y + 50, x + (float)Math.random()*90,y + 50 + z));
            arrayRectan.add(mRectangle);
            y+=z;
        }


        Collections.sort(arrayRectan);
        for(MyRectangle rect: arrayRectan) {
            Log.d("Tag", "List: " + rect.toString());
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(80, 102, 204, 255);

        p.setColor(Color.BLUE);
        p.setStrokeWidth(7);


        float x = 50;
        for(MyRectangle rect: arrayRectan) {
            p.setColor(rect.getColor());

            p.setStyle(Paint.Style.STROKE);
            rect.getmRectf().left = 100;
            rect.getmRectf().top = x;

            canvas.drawRect(rect.getmRectf(), p);
            x=rect.getmRectf().height()+10;
        }

    }

    public float area(RectF rect){
        return rect.width() * rect.height();
    }


}
