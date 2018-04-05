package com.example.ivandjordjevic.hellogridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Uzimanje GridView iz activity_main.xml fajla
        GridView gridview = (GridView) findViewById(R.id.gridview);

        // Punjenje GridView podacima
        gridview.setAdapter(new ImageAdapter(this)); /* ImageAdapter se kreira u sledećem koraku... */


        // Dodavanje osluškivača pojave dogadjaja na GridView
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // Toast u kome će se ispisivati pozicija selektovanog grida
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
