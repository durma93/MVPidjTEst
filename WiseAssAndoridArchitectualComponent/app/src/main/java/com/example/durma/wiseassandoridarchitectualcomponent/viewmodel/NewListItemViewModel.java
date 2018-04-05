package com.example.durma.wiseassandoridarchitectualcomponent.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.durma.wiseassandoridarchitectualcomponent.data.ListItem;
import com.example.durma.wiseassandoridarchitectualcomponent.data.ListItemRepository;

public class NewListItemViewModel extends ViewModel {

    private ListItemRepository repository;

    public NewListItemViewModel(ListItemRepository repository) {
        this.repository = repository;
    }

    public void addNewItemToDatabase(ListItem listItem){
        new AddItemTask().execute(listItem);
    }

    private class AddItemTask extends AsyncTask<ListItem,Void,Void>{

        @Override
        protected Void doInBackground(ListItem... listItems) {
            repository.insert(listItems[0]);
            return null;
        }
    }
}
