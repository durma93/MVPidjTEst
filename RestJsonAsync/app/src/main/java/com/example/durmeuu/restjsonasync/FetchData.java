package com.example.durmeuu.restjsonasync;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Durmeuu on 12/20/17.
 */

public class FetchData extends AsyncTask<Void,Void,Void> {

    String data="";
    String dataParsed="";
    String singleParsed="";


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://s.strictapp.com/api/projects/master/358?api_token=H49pweIzc0gw0I64BmuUiSxWzSmueFtJaZpTUZBSEeg7hqjbos4V9AJ1op2V");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while (line !=null){
                line = bufferedReader.readLine();
                data = data + line;

            }                                                                                       // Gotova implementacija za fetching json u app

            Log.d("sira", data.toString());

          /*  JSONArray jsonArray = new JSONArray(data);                                              //PARSIRANJE JSON-a
            for (int i=0;i<jsonArray.length();i++){
              *//*  JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                singleParsed = "Name:" + jsonObject.get("name") + "\n" +
                                "Password:" + jsonObject.get("password") + "\n" +
                                "Contact:" + jsonObject.get("contact") + "\n" +
                                "Country:" + jsonObject.get("country") + "\n";

                dataParsed = dataParsed +singleParsed + "\n";
                *//*

            }*/
            JSONObject jsonObject = new JSONObject(data);
            String name = jsonObject.getJSONObject("data").getJSONArray("versions").getJSONObject(0).getJSONObject("user").getString("first_name");

            Log.d("NAME", name);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (JSONException e) {
            e.printStackTrace();
        }*/ catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.text.setText(this.dataParsed);                                                       //Postavljanje texta na aktivnosti
    }
}
