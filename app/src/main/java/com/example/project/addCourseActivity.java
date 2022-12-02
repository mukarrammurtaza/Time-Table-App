package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.logging.Logger;

public class addCourseActivity extends MainActivity {
    Logger logger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);

        EditText courseName =findViewById(R.id.courseName);
        EditText courseID =findViewById(R.id.courseID);
        EditText courseRoom =findViewById(R.id.roomNumber);
        EditText courseSTime =findViewById(R.id.startTime);
        EditText courseETime =findViewById(R.id.endTime);
        Button addCourse = (Button) findViewById(R.id.save);
        addCourse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                logger = Logger.getLogger("add course");
                String cName=courseName.getText().toString();
                String cId= (courseID.getText().toString());
                String cR= (courseRoom.getText().toString());
                String csTime=courseSTime.getText().toString();
                String ceTime=courseETime.getText().toString();
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("courseName", cName);
                intent.putExtra("courseId", cId);
                intent.putExtra("courseRoom", cR);
                intent.putExtra("courseSTime", csTime);
                intent.putExtra("courseETime", ceTime);
                intent.putExtra("addCourseCheck", "21589u13985y821907389");
                startActivity(intent);

            }
        });
    }
}