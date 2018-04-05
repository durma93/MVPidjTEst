package com.example.durmeuu.parsingdifferentjsonformatretrofit;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.durmeuu.parsingdifferentjsonformatretrofit.Model.Team;
import com.example.durmeuu.parsingdifferentjsonformatretrofit.adapter.TeamAdapter;
import com.example.durmeuu.parsingdifferentjsonformatretrofit.api.Client;
import com.example.durmeuu.parsingdifferentjsonformatretrofit.api.Service;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Team> teams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        if (getActivity().getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }


        loadJson();
    }

    public Activity getActivity(){
        Context context = this;
        while (context instanceof ContextWrapper){
            if (context instanceof Activity){
                return (Activity) context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    private void loadJson() {

        Service serviceAPI = Client.getClient();
        Call<JsonArray> loadTeamCall = serviceAPI.readTeamArray();

        loadTeamCall.enqueue(new Callback<JsonArray>() {

            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                try {

                    String teamString = response.body().toString();

                    Type listType = new TypeToken<List<Team>>() {}.getType();
                    teams = getTeamListFromJson(teamString, listType);


                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(new TeamAdapter(getApplicationContext(), teams));


                }catch (Exception e){
                    Log.d("onResponse", "There Is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("On Faliure", t.toString());

            }


        });
    }

    public static <T> List<T> getTeamListFromJson(String jsonString, Type type){
        if (!isValid(jsonString)){
            return null;
        }
        return new Gson().fromJson(jsonString,type);

    }

    private static boolean isValid(String json) {
        try{
            new JsonParser().parse(json);
            return true;
        }catch (JsonSyntaxException jse){
            return false;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        loadJson();
    }
}
