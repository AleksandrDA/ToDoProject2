package com.example.todoproject.Main;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.todoproject.DataBase.Room.Tasks;

import java.util.List;

public class MainPresenter implements MainContract.MainPresenter {

    private static final String TAG = "myLogs";
    public MainActivity mainActivity;
    private MainContract.ReceiveDataRoom receiveDataRoomInterface;

    //конструктор принимает interface MainContract.ReceiveDataRoom для передачи информации (List<Tasks> tasks)  в MainActivity
    public MainPresenter(MainContract.ReceiveDataRoom receiveDataRoom) {
        receiveDataRoomInterface = receiveDataRoom;
    }

    @Override
    public void onPassTaskMainView(final List<Tasks> tasks) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                //mainActivity.onViewTask(tasks);
                receiveDataRoomInterface.onDataReceive(tasks);
            }
        });
        Log.d(TAG,"onPassTaskMainView in class MainPresenter " + tasks + Thread.currentThread().getName());
    }
}





