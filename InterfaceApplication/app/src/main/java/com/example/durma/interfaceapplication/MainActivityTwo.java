package com.example.durma.interfaceapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivityTwo extends AppCompatActivity implements OnWidgetClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonTwo button= new ButtonTwo();
        button.setOnWidgetClickListener(this);
    }


    @Override
    public void onClick(int viewId) {
        //Handle event somehow
    }
}
