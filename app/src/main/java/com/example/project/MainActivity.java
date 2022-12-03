package com.example.project;

import static com.example.project.addTaskActivity.taskList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private static List<course> courseList ;
    Context context;
    mainActivityAdapter adp;
    Logger logger;
    courseDatabase courseDB;
    taskDatabase taskDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        logger = Logger.getLogger("MainActivity");
        taskDB=taskDatabase.getInstance(this);
        courseDB=courseDatabase.getInstance(this);
        if(courseList==null) {
            courseList = courseDB.courseDAO().getAllCourses();
            logger.log(Level.INFO, "retrieving data from DB");
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adp = new mainActivityAdapter(this, courseList);
        recyclerView.setAdapter(adp);



        Button addCourse = findViewById(R.id.addCourseButton);
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, addCourseActivity.class);
                startActivity(intent);

            }
        });
        Button tasksDue = findViewById(R.id.tasksDueButton);
        tasksDue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, taskViewActivity.class);
                startActivity(intent);
            }
        });
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, addCourseActivity.class);
                startActivity(intent);

            }
        });

        Intent intent = getIntent();
        if (intent.hasExtra("addCourseCheck")) {
            String cname = intent.getStringExtra("courseName");
            String cid = intent.getStringExtra("courseId");
            String cr = intent.getStringExtra("courseRoom");
            String cstime = intent.getStringExtra("courseSTime");
            String cetime = intent.getStringExtra("courseETime");
            int ncid = Integer.parseInt(cid);
            int ncr = Integer.parseInt(cr);
            Boolean found = false;
            for (course c : courseList
            ) {
                if (c.getCourseId() == ncid){
                    found = true;
                }
            }
            if (!found) {
                courseList.add(new course(ncid,ncr,cname,cstime,cetime));
                courseDB.courseDAO().insertCourse((new course(ncid,ncr,cname,cstime,cetime)));
                logger.log(Level.INFO, "saving course to the DB");
            }
            else{
                Toast toast=Toast. makeText(getApplicationContext(),"course with same courseID already exists",Toast. LENGTH_LONG);
                toast. show();
            }
            adp.notifyDataSetChanged();

        } else if (intent.hasExtra("editCourseCheck")) {
            String cname = intent.getStringExtra("courseName");
            String cid = intent.getStringExtra("courseId");
            String cr = intent.getStringExtra("courseRoom");
            String cstime = intent.getStringExtra("courseSTime");
            String cetime = intent.getStringExtra("courseETime");
            int ncid = Integer.parseInt(cid);
            int ncr = Integer.parseInt(cr);
            for (course course : courseList) {
                if (course.getCourseId() == ncid) {
                    course.setCourseName(cname);
                    course.setRoomNumber(ncr);
                    course.setCourseSTime(cstime);
                    course.setCourseETime(cetime);
                    courseDB.courseDAO().updateCourse(course);

                    logger.log(Level.INFO, "course  details updated");
                }
            }
            deleteTasks(ncid);
            adp.notifyDataSetChanged();
        } else if (intent.hasExtra("deleteCourseCheck")) {
            String cid = intent.getStringExtra("courseId");
            int ncid = Integer.parseInt(cid);
            //courseList.removeIf(course -> course.getCourseId() == ncid);
            for(course c:courseList){
                if(c.getCourseId()==ncid){
                    courseList.remove(c);
                    courseDB.courseDAO().deleteCourse(c);
                    logger.log(Level.INFO, "course deleted from DB");
                    break;
                }
            }
            deleteTasks(ncid);// delete all tasks for the deleted Course
           // adp.notifyDataSetChanged();
        }
    }
public void deleteTasks(int ncid){
        for(task task: taskList){
            if(task.getCourseId()==ncid){
                taskList.remove(task);
                taskDB.taskDAO().deleteTask(task);
            }
        }
}
    private void AddInitialEntriesInDB() {
        try {
            courseList.add(new course(1, 400, "Computer Networks", "1pm", "2pm"));

//            courseList.add(new product(" Badminton Racket", 1000, R.drawable.racket, 10));
//            courseList.add(new product("Cricket Helmet", 4000, R.drawable.crickethelmet, 10));
//            courseList.add(new product("Dumbbells 5 KG", 3000, R.drawable.dumbbells, 10));
//            courseList.add(new product(" TreadMill", 500000, R.drawable.treadmill, 10));
//            courseList.add(new product(" Table Tennis Racket", 1000, R.drawable.tabletennis, 10));
//            courseList.add(new product("SkateBoard", 10000, R.drawable.skateboard, 10));
//            courseList.add(new product("BaseBall Bat", 15000, R.drawable.baseballbat, 10));
//            daoc.save(courseList);
//            daof.save(courseList);
        } catch (Exception e) {
            logger.log(Level.INFO, "THIS ERROR" + e);
        }
    }
}
