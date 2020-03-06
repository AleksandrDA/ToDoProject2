package com.example.todoproject.Main;

import com.example.todoproject.DataBase.Room.Tasks;

import java.util.List;

public interface MainContract {

    interface MainView {
        void onViewTask(List<Tasks> tasks);
    }

    interface MainPresenter {
        void onPassTaskMainView(List<Tasks> tasks);
    }

    interface ReceiveDataRoom {
        void onDataReceive (List<Tasks> tasks);
    }
}
