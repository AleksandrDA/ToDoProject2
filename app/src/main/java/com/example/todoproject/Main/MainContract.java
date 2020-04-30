package com.example.todoproject.Main;

import com.example.todoproject.DataBase.Room.Tasks;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface MainContract {

    interface MainView {
        void onViewTask(List<Tasks> tasks);
    }

    interface MainPresenter {
        void onPassTaskMainView() throws ExecutionException, InterruptedException;
    }
}
