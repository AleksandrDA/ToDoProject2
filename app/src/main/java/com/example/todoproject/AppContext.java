package com.example.todoproject;

import android.app.Application;
import android.content.Context;

// класс для получения ApplicationContext, контекст предназначался для SQLiteOpenHelper
public class AppContext extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
    return context;
    }
}