package com.example.durma.sqlitenewbostontutorijal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputNaziv, inputAutor, inputDuzina;
    TextView ispis;
    MyDBHandler dbHandler;

    Button add;
    Button remove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNaziv = (EditText) findViewById(R.id.inputNaziv);
        inputAutor = (EditText) findViewById(R.id.intputAutor);
        inputDuzina = (EditText) findViewById(R.id.inputDuzina);

        ispis = (TextView) findViewById(R.id.display_text);

        add = (Button) findViewById(R.id.addd);
        remove = (Button) findViewById(R.id.remove);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addButtonClicked(view);
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteButtonClicked(view);
            }
        });

        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();


    }

    //Add a product to the database
    public void addButtonClicked(View view) {
        String naziv = inputNaziv.getText().toString();
        String autor = inputAutor.getText().toString();
        String duzina = inputDuzina.getText().toString();


        if (naziv != null && !naziv.trim().isEmpty() &&
                autor != null && !autor.trim().isEmpty() &&
                duzina != null && !duzina.trim().isEmpty()) {


            try {

                int duz = Integer.parseInt(duzina);
                Products product = new Products(naziv, autor, duz);
                dbHandler.addProduct(product);
                printDatabase();

            } catch (Exception e) {
                inputDuzina.setError("Morate uneti broj");
                inputDuzina.setText("");
            }
      } else {
            inputDuzina.setError("Popunite polje");
            inputAutor.setError("Popunite polje");
            inputNaziv.setError("Popunite polje");
            inputNaziv.setText("");
            inputAutor.setText("");
            inputDuzina.setText("");

    }

    }
    //Delete items
    public void deleteButtonClicked(View view){

        String inputText = inputNaziv.getText().toString();


        if(!inputText.trim().isEmpty()) {
                dbHandler.deleteProduct(inputText);

        }else {
            inputNaziv.setError("Unesite ime videa za brisanje");
        }
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        ispis.setText(dbString);
        inputNaziv.setText("");
        inputAutor.setText("");
        inputDuzina.setText("");


    }

}