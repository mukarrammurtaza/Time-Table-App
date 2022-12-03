package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addTaskActivity extends AppCompatActivity {
    Context context;
    public static List<task> taskList;
    taskDatabase taskDB;
    Logger logger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context=getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        logger = Logger.getLogger("TaskActivity");
        EditText courseName = findViewById(R.id.courseName);
        EditText courseID = findViewById(R.id.courseID);
        EditText taskTitle = findViewById(R.id.taskTitle);
        EditText dueDate = findViewById(R.id.dueDate);
        EditText dueTime = findViewById(R.id.dueTime);
        Intent intent = getIntent();
        String cname = intent.getStringExtra("courseName");
        String cid = intent.getStringExtra("courseId");
        courseName.setText(cname);
        courseID.setText(cid);
        Button saveButton=findViewById(R.id.save);

        taskDB=taskDatabase.getInstance(this);
        if(taskList==null) {
            taskList = taskDB.taskDAO().getAllTasks();
            logger.log(Level.INFO, "retrieving tasks from DB");
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cName = courseName.getText().toString();
                String cid = (courseID.getText().toString());
                String taskT = taskTitle.getText().toString();
                String dd = dueDate.getText().toString();
                String dt = dueTime.getText().toString();
                int ncid = Integer.parseInt(cid);
                task task =new task(ncid,cName,taskT,dd,dt);
                taskList.add(task);
                taskDB.taskDAO().insertTask(task);
                logger.log(Level.INFO, "task added to DB");
                Toast toast=Toast. makeText(getApplicationContext(),"task added successfully",Toast. LENGTH_SHORT);
                toast. show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public  List<task> getTaskList(){
        return taskList;
    }
}