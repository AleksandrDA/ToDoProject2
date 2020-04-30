package com.example.todoproject.Main;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.todoproject.DataBase.MainModel;
import com.example.todoproject.DataBase.Room.Tasks;
import com.example.todoproject.DataBase.Room.TasksDao;
import com.example.todoproject.FastAddTask.FastTaskContract;
import com.example.todoproject.FastAddTask.FastTaskRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainPresenter implements MainContract.MainPresenter {

    private static final String TAG = "myLogs";

    private OnTaskReceived onTaskReceived;
    //private MainModel mainModel = new MainModel();
    private FastTaskRepository fastTaskRepository = new FastTaskRepository();

    private List<Tasks> tasks;

    //конструктор принимает interface MainContract.ReceiveDataRoom для передачи информации (List<Tasks> tasks)  в MainActivity
    public MainPresenter(OnTaskReceived onReceived) {
        onTaskReceived = onReceived;
    }

    @Override
    public void onPassTaskMainView() throws ExecutionException, InterruptedException {
        /*new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                //mainActivity.onViewTask(tasks);
                if(tasks != null) {
                    //receiveDataRoomInterface.onDataReceive(tasks);
                    Log.d(TAG,"Runnable in class MainPresenter " + tasks + Thread.currentThread().getName());
                }
            }
        });*/
        tasks = fastTaskRepository.onRepositoryPassTask();
        sendTaskToMainActivity(tasks);

        Log.d(TAG,"onPassTaskMainView in class MainPresenter " + tasks + Thread.currentThread().getName());
    }


    private void sendTaskToMainActivity(List<Tasks> tasks) throws ExecutionException, InterruptedException {
        onTaskReceived.onReceive(tasks);
    }

    interface OnTaskReceived {
        void onReceive(List<Tasks> tasks) throws ExecutionException, InterruptedException;
    }
}





