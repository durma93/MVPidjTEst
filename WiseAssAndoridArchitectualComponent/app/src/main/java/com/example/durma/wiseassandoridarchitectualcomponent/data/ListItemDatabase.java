package com.example.durma.wiseassandoridarchitectualcomponent.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ListItem.class}, version = 2)
public abstract class ListItemDatabase extends RoomDatabase{

    public abstract ListItemDao listItemDao();

}
