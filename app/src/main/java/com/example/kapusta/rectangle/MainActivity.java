package com.example.kapusta.rectangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kapusta.rectangle.view.MyView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}
