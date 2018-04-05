package com.example.durmeuu.projekat41textviewbuttonetc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button, unesi;
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);                                                // Nalazenje dugmeta u xml-u
        textView = (TextView) findViewById(R.id.textView2);
        editText =  (EditText) findViewById(R.id.editText);
        unesi = (Button) findViewById(R.id.button2);

        unesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty()) {

                    String b ="Nista nije uneto";
                    textView.setText(b);
                }else{
                    String a = editText.getText().toString();
                    textView.setText(a);
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Dugme je kliknuto", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
