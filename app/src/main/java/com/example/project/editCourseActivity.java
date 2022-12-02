package com.example.project;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class editCourseActivity extends AppCompatActivity {
    Context context;

    //ArrayList<course> courseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcourse);
        context = getApplicationContext();
        EditText courseName = findViewById(R.id.courseName);
        EditText courseID = findViewById(R.id.courseID);
        EditText courseRoom = findViewById(R.id.roomNumber);
        EditText courseSTime = findViewById(R.id.startTime);
        EditText courseETime = findViewById(R.id.endTime);
        courseID.setEnabled(false);
        Intent intent = getIntent();
        String cname = intent.getStringExtra("courseName");
        String cid = intent.getStringExtra("courseId");
        String cr = intent.getStringExtra("courseRoom");
        String cstime = intent.getStringExtra("courseSTime");
        String cetime = intent.getStringExtra("courseETime");
        courseName.setText(cname);
        courseID.setText(cid);
        courseRoom.setText(cr);
        courseSTime.setText(cstime);
        courseETime.setText(cetime);

        Button saveCourse = findViewById(R.id.save);
        saveCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // logger = Logger.getLogger("add course");
                String cName = courseName.getText().toString();
                String cid = (courseID.getText().toString());
                String cr = (courseRoom.getText().toString());
                String csTime = courseSTime.getText().toString();
                String ceTime = courseETime.getText().toString();
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("courseName", cName);
                intent.putExtra("courseId", cid);
                intent.putExtra("courseRoom", cr);
                intent.putExtra("courseSTime", csTime);
                intent.putExtra("courseETime", ceTime);
                intent.putExtra("editCourseCheck", "");
                startActivity(intent);

            }
        });
        Button delButton = (Button) findViewById(R.id.delete);
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cid = (courseID.getText().toString());
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("courseId", cid);
                intent.putExtra("deleteCourseCheck", "");
                startActivity(intent);
            }
        });
        Button taskButton= (Button) findViewById(R.id.addTask);
        taskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, addTaskActivity.class);
                intent.putExtra("courseId", cid);
                intent.putExtra("courseName", cname);
                startActivity(intent);
            }
        });
    }
}