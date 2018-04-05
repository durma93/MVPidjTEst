package com.example.durma.mediumretrofitmvprxjavaexample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.durma.mediumretrofitmvprxjavaexample.R;
import com.example.durma.mediumretrofitmvprxjavaexample.adapter.MovieAdapter;
import com.example.durma.mediumretrofitmvprxjavaexample.model.MovieResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.rvMovies)
    RecyclerView rvMoview;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private String TAG = "MAIN activity";
    private RecyclerView.Adapter adapter;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupMVP();
        setViews();
        getMovieList();

    }

    private void setupMVP(){
        mainPresenter = new MainPresenter(this);
    }

    private void setViews(){

        setSupportActionBar(toolbar);
        rvMoview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getMovieList(){
        mainPresenter.getMovies();
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();

    }

    @Override
    public void displayMovies(MovieResponse movieResponse) {
        if (movieResponse != null) {
            Log.d(TAG, "displayMovies: "+movieResponse.getResults().get(1).getTitle());

            adapter = new MovieAdapter(movieResponse.getResults(), MainActivity.this);

            rvMoview.setAdapter(adapter);
        }else {
            Log.d(TAG, "Movie Response is null");
        }
    }

    @Override
    public void displayError(String s) {
        showToast(s);
    }
}
