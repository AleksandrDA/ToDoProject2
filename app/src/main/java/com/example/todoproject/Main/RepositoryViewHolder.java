package com.example.todoproject.Main;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todoproject.R;

public class RepositoryViewHolder extends RecyclerView.ViewHolder {

    TextView taskRecycler;

    public RepositoryViewHolder (View itemView) {
        super(itemView);
        taskRecycler = itemView.findViewById(R.id.item_recycler_task);
    }

    /*@Override
    public void setTask(String task) {

        taskRecycler.setText(task);
    }*/
}
