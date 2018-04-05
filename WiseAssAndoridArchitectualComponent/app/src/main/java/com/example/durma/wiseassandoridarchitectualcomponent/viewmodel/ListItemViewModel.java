package com.example.durma.wiseassandoridarchitectualcomponent.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.durma.wiseassandoridarchitectualcomponent.data.ListItem;
import com.example.durma.wiseassandoridarchitectualcomponent.data.ListItemRepository;

public class ListItemViewModel extends ViewModel {

    private ListItemRepository repository;

    public ListItemViewModel(ListItemRepository repository) {
        this.repository = repository;
    }

    public LiveData<ListItem> getListItemById(String id){
        return repository.getListItem(id);
    }
}
