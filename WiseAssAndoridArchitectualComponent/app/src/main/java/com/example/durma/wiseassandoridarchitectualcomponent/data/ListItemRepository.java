package com.example.durma.wiseassandoridarchitectualcomponent.data;


import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

public class ListItemRepository {
    private final ListItemDao listItemDao;

    @Inject
    public ListItemRepository(ListItemDao listItemDao) {
        this.listItemDao = listItemDao;
    }

    public LiveData<List<ListItem>> getListOfData(){

        return listItemDao.getListItems();
    }


    public LiveData<ListItem> getListItem(String id){

        return listItemDao.getListItemById(id);
    }

    public void deleteListItem(ListItem listItem){
        listItemDao.deleteListItem(listItem);
    }

    public void insert(ListItem listItem){
        listItemDao.insertListItem(listItem);
    }

}
