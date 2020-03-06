package com.example.todoproject.FastAddTask;

import android.util.Log;

import com.example.todoproject.DataBase.Room.AppDataBase;
import com.example.todoproject.DataBase.Room.StoreObjectDatabase;
import com.example.todoproject.DataBase.Room.Tasks;
import com.example.todoproject.DataBase.Room.TasksDao;
import com.example.todoproject.Main.MainContract;
import com.example.todoproject.Main.MainPresenter;

import java.util.List;


public class FastTaskRepository implements FastTaskContract.Repository {

    private static final String TAG = "myLogs";
    private MainPresenter mainPresenter;
    public MainContract.ReceiveDataRoom receiveDataRoom;


    @Override
    public void onSaveTaskDB(String nameTask) {
        //передача nameTask в DataBaseSQLite (бд на голом SQLite)
        /*dataBase = new DataBaseSQLite(AppContext.getContext());
        dataBase.insertData(nameTask);*/

        //получение Базы данных
        AppDataBase db = StoreObjectDatabase.getInstance().getDatabase();

        //из Database объекта получаем Dao
        TasksDao tasksDao = db.tasksDao();

        Tasks task = new Tasks();
        task.setTaskName(nameTask);
        tasksDao.insertTask(task);

        //передача всех задач которые есть в БД (в столбце task_name) в MainPresenter
        List<Tasks> allTasks = tasksDao.getAll();
        mainPresenter = new MainPresenter(receiveDataRoom);
        mainPresenter.onPassTaskMainView(allTasks);

        Log.d(TAG,"onSaveTaskDB work in class FastTaskRepository " + task + Thread.currentThread().getName());
    }

    /*@Override
    public void onRepositoryPassTask(List<Tasks> tasks) {
        //передача в MainPresenter tasks
        *//*mainPresenter = new MainPresenter();
        mainPresenter.onPassTaskMainView(tasks);*//*

        Log.d(TAG,"onRepositoryPassTask work in class FastTaskRepository " + tasks + Thread.currentThread().getName());
    }*/
}

