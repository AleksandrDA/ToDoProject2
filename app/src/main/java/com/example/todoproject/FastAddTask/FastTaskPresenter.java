package com.example.todoproject.FastAddTask;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

public class FastTaskPresenter implements FastTaskContract.Presenter {

    private static final String TAG = "myLogs";
    private FastTaskRepository dbTask;

    //сохранение задачи
    @Override
    public void onSaveTask(final EditText editText) {
        final String nameTask = editText.getText().toString();
        if(!nameTask.isEmpty()) {
            String[] nameAsyncTask = {nameTask};
            new AsyncTaskDB().execute(nameAsyncTask);
            Log.d(TAG,"onSaveTask work in class FastTaskPresenter");
        }
    }

    static class AsyncTaskDB extends AsyncTask<String, Void, Void> {

        private FastTaskRepository dbTask;

        @Override
        protected Void doInBackground(String... params) {
            dbTask = new FastTaskRepository();
            final String nameAsyncTask = params[0];
            dbTask.onSaveTaskDB(nameAsyncTask);
            Log.d(TAG,"AsyncTask work " + Thread.currentThread().getName());
            return null;
        }
    }

}


