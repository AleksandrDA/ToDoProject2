package com.example.todoproject.DataBase.Room;

import android.app.Application;
import androidx.room.Room;

public class StoreObjectDatabase extends Application {

    public static StoreObjectDatabase instance;
    private AppDataBase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDataBase.class, "database").build();
    }

    public static StoreObjectDatabase getInstance(){
        return instance;
    }

    public AppDataBase getDatabase() {
        return database;
    }
}
