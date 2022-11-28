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
                String cId=  String.valueOf(courseID.getText().toString());
                String cR= String.valueOf(courseRoom.getText().toString());
                int ncid=Integer.parseInt(cId);
                int ncr=Integer.parseInt(cR);
                String csTime=courseSTime.getText().toString();
                String ceTime=courseETime.getText().toString();
                course course =new course(ncid,ncr,cName,csTime,ceTime);
                courseList.add(course);
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                adp.notifyDataSetChanged();
            }
        });
    }
}