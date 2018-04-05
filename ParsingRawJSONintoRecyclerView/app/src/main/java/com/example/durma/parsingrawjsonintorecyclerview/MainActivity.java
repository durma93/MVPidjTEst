package com.example.durma.parsingrawjsonintorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Object> RecyclerViewItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new RecyclerViewAdapter(this, RecyclerViewItems);
        recyclerView.setAdapter(adapter);

        addMenuFromJson();

    }

    private void addMenuFromJson() {

        try{
            String jsonDataString = readJsonDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i<jsonArray.length();++i){

                JSONObject menuItemObject = jsonArray.getJSONObject(i);

                String name = menuItemObject.getString("name");
                String description = menuItemObject.getString("description");
                String price = menuItemObject.getString("price");
                String category = menuItemObject.getString("category");
                String photo = menuItemObject.getString("photo");

                Pojo p = new Pojo(name,description,price,category,photo);

                RecyclerViewItems.add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(MainActivity.class.getName(),"Unable to parse Json File!!!!",e);
        } catch (JSONException e) {
            e.printStackTrace();

            Log.e(MainActivity.class.getName(),"Unable to parse Json File!!!!",e);
        }
    }

    private String readJsonDataFromFile() throws IOException{
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try{
            String jsonDataString = null;
            inputStream = getResources().openRawResource(R.raw.menu_item);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

            while ((jsonDataString = bufferedReader.readLine())!=null){
                builder.append(jsonDataString);
            }

        } finally {
            if (inputStream!=null){
                inputStream.close();
            }
        }
        return new String(builder);
    }

}
