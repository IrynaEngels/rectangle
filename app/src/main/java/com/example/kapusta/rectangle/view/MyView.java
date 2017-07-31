package com.example.kapusta.rectangle.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.kapusta.rectangle.R;
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
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        p = new Paint();
    }

    public void generateRandomFigures() {
        float y = 50;
        arrayRectan.clear();
        for (int i = 0; i < 3; i++) {
            MyRectangle mRectangle = new MyRectangle();
            float x = (float)Math.random()*400;
            float z = (float)Math.random()*100;
            mRectangle.setmRectf(new RectF(x, y + 50, x + (float)Math.random()*130,y + 50 + z));
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

        float x = 0;
        float y = 0;
        for(MyRectangle rect: arrayRectan) {
            if (rect.getmRectf().top + rect.getmRectf().width() <= canvas.getWidth()) {
                p.setColor(rect.getColor());

                p.setStyle(Paint.Style.STROKE);
                rect.getmRectf().left = x;
                rect.getmRectf().top = y;
//            rect.getmRectf().right = rect.getmRectf().left + rect.getmRectf().width();
//            rect.getmRectf().bottom = x + rect.getmRectf().height();

                canvas.drawRect(rect.getmRectf(), p);
                x += rect.getmRectf().width();

            }
            else {
                y += rect.getmRectf().height();
                p.setColor(rect.getColor());

                p.setStyle(Paint.Style.STROKE);
                rect.getmRectf().left = x;
                rect.getmRectf().top = y;

                canvas.drawRect(rect.getmRectf(), p);


            }
        }
    }

    public float area(RectF rect){
        return rect.width() * rect.height();
    }


}
