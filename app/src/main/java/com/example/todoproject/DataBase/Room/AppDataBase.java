package com.example.todoproject.DataBase.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//вписал exportSchema в build.gradle: рекомендуется иметь историю версий в базе кода, и вы должны зафиксировать этот файл в своей системе контроля версий (но не поставляйте его вместе с приложением!)
//всегда поднимайте версию приложения в AppDatabase классе, а потом уже меняйте структуру Entity классов. Если сделать наоборот - то миграционный тест не сможет создать базу первой версии, потому что 1.json описывает уже вторую версию.
@Database(entities = {Tasks.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TasksDao tasksDao();
}
