package com.example.durma.mediumretrofitmvprxjavaexample.ui;

import com.example.durma.mediumretrofitmvprxjavaexample.model.MovieResponse;

public interface MainViewInterface {

    void showToast(String s);
    void displayMovies(MovieResponse movieResponse);
    void displayError(String s);
}
