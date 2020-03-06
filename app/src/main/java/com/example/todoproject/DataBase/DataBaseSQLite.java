package com.example.todoproject.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.todoproject.FastAddTask.FastTaskRepository;

import java.util.ArrayList;
import java.util.List;

public class DataBaseSQLite extends SQLiteOpenHelper {

    private static final String db_name = "tasksinSQLite";
    private static final int db_version = 1;
    private static final String db_table = "tasks";
    private static final String db_column = "taskName";

    private static final String TAG = "myLogs";
    private FastTaskRepository fastTaskRepository;

    public DataBaseSQLite(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL)", db_table, db_column);
        db.execSQL(queryCreate);
            Log.d(TAG, "DB onCreate " + Thread.currentThread().getName());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String queryDelete = String.format("DELETE TABLE IF EXISTS %s", db_table);
        db.execSQL(queryDelete);
        onCreate(db);
        Log.d(TAG, "worked method onUpgrade in class DataBaseSQLite " + Thread.currentThread().getName());
    }

    public void insertData(String nameTask) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(db_column, nameTask);
        db.insertWithOnConflict(db_table,null, values, SQLiteDatabase.CONFLICT_REPLACE);
        //getAllTasks();
        Log.d(TAG, "method insertData work in class DataBaseSQLite " + nameTask + Thread.currentThread().getName());
    }

    public void editData(String nameTask) {
    }

    public void deleteData(String nameTask) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(db_table, db_column + " = ?", new String[]{nameTask});
        db.close();
    }

    /*public ArrayList<String> getAllTasks() {
        ArrayList<String> all_tasks = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(db_table, new String[]{db_column}, null, null, null,null, null);
        while(cursor.moveToLast()) {
            int index = cursor.getColumnIndex(db_column);
            all_tasks.add(cursor.getString(index));
        }
        fastTaskRepository = new FastTaskRepository();
        fastTaskRepository.onPassTask(all_tasks);
        Log.d(TAG, "method getAllTasks work in class DataBaseSQLite " + Thread.currentThread().getName());
        cursor.close();
        return all_tasks;
    }*/
}
