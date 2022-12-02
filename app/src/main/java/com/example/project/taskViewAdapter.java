package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class taskViewAdapter extends RecyclerView.Adapter<taskViewAdapter.ViewHolder> {
    private static ArrayList<task> taskList = new ArrayList<>();
    private Context context;

    public taskViewAdapter(Context context, ArrayList<task> taskList) {
        this.context = context;
        this.taskList =taskList;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singletaskdisplay, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.courseNameView.setText(taskList.get(position).getCourseName());
        holder.courseIdView.setText(String.valueOf(taskList.get(position).getCourseId()));
        holder.taskTitleView.setText(String.valueOf(taskList.get(position).getTaskTitle()));
        holder.dueDateView.setText( taskList.get(position).getDueDate());
        holder.dueTimeView.setText( taskList.get(position).getDueTime());
    }


    @Override
    public int getItemCount() {
        return taskList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final View itemView;
        private final TextView courseNameView;
        private final TextView courseIdView;
        private final TextView taskTitleView;
        private final TextView dueDateView;
        private final TextView dueTimeView;



        public ViewHolder(View view) {
            super(view);
            itemView = view;
            courseNameView = view.findViewById(R.id.courseName);
            courseIdView = view.findViewById(R.id.courseID);
            taskTitleView =  view.findViewById(R.id.taskTitle);
            dueDateView =  view.findViewById(R.id.dueDate);
            dueTimeView =  view.findViewById(R.id.dueTime);
        }

        public View getItemView() {
            return itemView;
        }
        public TextView getCourseNameView() {
            return courseNameView;
        }
        public TextView getCourseIdView() {return courseIdView;}
        public TextView getTaskTitleView() {
            return taskTitleView;
        }

        public TextView getDueDateView() {
            return dueDateView;
        }

        public TextView getDueTimeView() {
            return dueTimeView;
        }
    }
}


