package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.course;

import java.util.List;

public class mainActivityAdapter extends RecyclerView.Adapter<mainActivityAdapter.ViewHolder> {
    List<course> courseList;
    private Context context;

    public mainActivityAdapter(Context context, List<course> productList) {
        this.context = context;
        this.courseList = productList;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.courseNameView.setText(courseList.get(position).getCourseName());
        holder.courseRoomView.setText(String.valueOf(courseList.get(position).getRoomNumber()));
        holder.courseTimeView.setText( courseList.get(position).getCourseSTime());

        holder.getItemView().setOnClickListener(new View.OnClickListener() {

                                                    @Override
                                                    public void onClick(View v) {

//                                                        Intent intent = new Intent(context, ProductActivity.class);
//                                                        // intent.putExtra()
//                                                        intent.putExtra("name", holder.getNameView().getText().toString());
//                                                        intent.putExtra("price", holder.priceView.getText().toString());
//                                                        //intent.putExtra("rating", holder.ratingView.getText().toString());
//                                                        intent.putExtra("image", (productList.get(position).getImage()));
//
//                                                        //quantity
//                                                        context.startActivity(intent);
                                                    }

                                                }

        );


    }


    @Override
    public int getItemCount() {
        return courseList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final View itemView;



        private final TextView courseNameView;
        private final TextView courseRoomView;
        private final TextView courseTimeView;


        public ViewHolder(View view) {
            super(view);
            itemView = view;
            courseNameView = view.findViewById(R.id.courseName);
            courseRoomView =  view.findViewById(R.id.courseRoom);
            courseTimeView =  view.findViewById(R.id.courseTime);


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

        public TextView getCourseTimeView() {
            return courseTimeView;
        }

    }
}


