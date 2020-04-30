package com.example.todoproject.FastAddTask;

import android.widget.EditText;

import com.example.todoproject.DataBase.Room.Tasks;

import java.util.List;


public interface FastTaskContract {

    interface View {
    }

    interface Presenter {
        void onSaveTask(EditText editText);
    }

    interface Repository {
        void onSaveTaskDB(String nameTask);
        //List<Tasks> onRepositoryPassTask();
    }
}
