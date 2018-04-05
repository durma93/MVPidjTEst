package com.refactor.view;

import android.os.Bundle;

import com.refactor.repository.Book;
import java.util.List;

public interface BooksActivityView {
    void onCreate(Bundle savedInstanceState);

    void displayBooks(List<Book> bookList);
    void displayNoBooks();
}
