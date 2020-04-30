package com.example.todoproject.FastAddTask;

import android.graphics.PorterDuff;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.todoproject.R;


public class FastAddTask extends AppCompatActivity implements FastTaskContract.View {

    private FastTaskPresenter ftPresenter;
    private static final String TAG = "myLogs";

    //DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fast_add_task);

        final EditText etNameTask = findViewById(R.id.etNameTask);
        ImageView ivAdd = findViewById(R.id.ivAdd);

        //создание Presenter
       if(ftPresenter == null) {
           ftPresenter = new FastTaskPresenter();

           /*// подключаемся к БД
           SQLiteDatabase db = dbHelper.getWritableDatabase();
           // создаем объект для создания и управления версиями БД
           dbHelper = new DBHelper(this);*/
       }

        Toolbar fastToolbar = findViewById(R.id.toolbar_fast_task);
        setSupportActionBar(fastToolbar);

        //обработка событий в EditText
        etNameTask.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                ImageView ivAddTask = findViewById(R.id.ivAdd);
                if(count != 0) {
                    final int greenColor = ContextCompat.getColor(FastAddTask.this, R.color.colorFab);
                    ivAddTask.setColorFilter(greenColor, PorterDuff.Mode.SRC_ATOP);
                } else {
                    final int blackColor = ContextCompat.getColor(FastAddTask.this, R.color.black);
                    ivAddTask.setColorFilter(blackColor, PorterDuff.Mode.SRC_ATOP);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        //обработка нажатия на картинку, которая сохраняет задачу
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etNameTask.getText().toString().isEmpty()) {
                    ftPresenter.onSaveTask(etNameTask);
                    etNameTask.getText().clear();
                    Log.d(TAG, "user did click");
                } else {
                    Toast toast = Toast.makeText(FastAddTask.this, R.string.et_text_input, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
    }

    //создание меню в Toolbar
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_launch_task, menu);
        return true;
    }

    /*class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "email text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }*/
}

