package com.example.durma.wiseassandoridarchitectualcomponent.di;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.example.durma.wiseassandoridarchitectualcomponent.data.ListItemDao;
import com.example.durma.wiseassandoridarchitectualcomponent.data.ListItemDatabase;
import com.example.durma.wiseassandoridarchitectualcomponent.data.ListItemRepository;
import com.example.durma.wiseassandoridarchitectualcomponent.viewmodel.CustomViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private final ListItemDatabase database;

    public RoomModule(Application application){
        this.database = Room.databaseBuilder(
                application,
                ListItemDatabase.class,
                "ListItem.db"
        ).build();
    }

    @Provides
    @Singleton
    ListItemRepository provideListItemRepository (ListItemDao listItemDao){
        return new ListItemRepository(listItemDao);
    }

    @Provides
    @Singleton
    ListItemDao provideListItemDao (ListItemDatabase listItemDao){
        return database.listItemDao();
    }

    @Provides
    @Singleton
    ListItemDatabase provideListItemDatabase (Application application) {
        return database;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ListItemRepository repository){
        return new CustomViewModelFactory(repository);
    }
}
