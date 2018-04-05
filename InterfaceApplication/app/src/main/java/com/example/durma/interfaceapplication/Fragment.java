package com.example.durma.interfaceapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Fragment extends android.app.Fragment implements OnWidgetClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButtonTwo button= new ButtonTwo();
        button.setOnWidgetClickListener(this);

        ImageButton imageButton = new ImageButton();
        imageButton.setOnWidgetClickListener(this);
    }


    @Override
    public void onClick(int viewId) {
        //Handle event somehow
    }
}
