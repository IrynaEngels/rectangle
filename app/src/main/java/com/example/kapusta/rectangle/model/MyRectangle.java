package com.example.kapusta.rectangle.model;

import android.graphics.Color;
import android.graphics.RectF;
import android.support.annotation.NonNull;

/**
 * Created by user08 on 26.07.17.
 */

public class MyRectangle implements Comparable<MyRectangle>{
    private RectF mRectf;
    private int color = Color.BLUE;

    public RectF getmRectf() {
        return mRectf;
    }

    public void setmRectf(RectF mRectf) {
        this.mRectf = mRectf;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getArea(){
        return mRectf.width() * mRectf.height();
    }

    @Override
    public int compareTo(@NonNull MyRectangle myRectangle) {
        if(getArea() < myRectangle.getArea()){
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "MyRectangle{" +
                "mRectf=" + mRectf +
                ", color=" + color +
                ", area=" + getArea() +
                '}';
    }
}
