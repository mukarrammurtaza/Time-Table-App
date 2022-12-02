package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class mainActivityAdapter extends RecyclerView.Adapter<mainActivityAdapter.ViewHolder> {
    List<course> courseList;
    private Context context;

    public mainActivityAdapter(Context context, List<course> courseList) {
        this.context = context;
        this.courseList = courseList;

    }

    public void filterList(List<course> filterlist) {

        courseList = filterlist;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlecoursedisplay, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.courseNameView.setText(courseList.get(position).getCourseName());
        holder.courseIdView.setText(String.valueOf(courseList.get(position).getCourseId()));
        holder.courseRoomView.setText(String.valueOf(courseList.get(position).getRoomNumber()));
        holder.courseSTimeView.setText( courseList.get(position).getCourseSTime());
        holder.courseETimeView.setText( courseList.get(position).getCourseETime());
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, editCourseActivity.class);
                intent.putExtra("courseName", holder.courseNameView.getText().toString());
                intent.putExtra("courseId", String.valueOf(holder.courseIdView.getText().toString()));
                intent.putExtra("courseRoom", String.valueOf( holder.courseRoomView.getText()));
                intent.putExtra("courseSTime", holder.courseSTimeView.getText().toString());
                intent.putExtra("courseETime", holder.courseETimeView.getText().toString());
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return courseList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final View itemView;
        private final TextView courseNameView;
        private final TextView courseIdView;
        private final TextView courseRoomView;
        private final TextView courseSTimeView;
        private final TextView courseETimeView;


        public ViewHolder(View view) {
            super(view);
            itemView = view;
            courseNameView = view.findViewById(R.id.courseName);
            courseIdView = view.findViewById(R.id.courseID);
            courseRoomView =  view.findViewById(R.id.courseRoom);
            courseSTimeView =  view.findViewById(R.id.courseSTime);
            courseETimeView =  view.findViewById(R.id.courseETime);
        }

        public View getItemView() {
            return itemView;
        }
        public TextView getCourseNameView() {
            return courseNameView;
        }
        public TextView getCourseRoomView() {
            return courseRoomView;
        }
        public TextView getCourseSTimeView() {
            return courseSTimeView;
        }
        public TextView getCourseETimeView() {return courseETimeView; }
        public TextView getCourseIdView() {return courseIdView;}
    }
}


