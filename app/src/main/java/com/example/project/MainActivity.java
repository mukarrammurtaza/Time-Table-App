package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    Context context;
    mainActivityAdapter adp;
//    IProductDAO daoc;
//    IProductDAO daof;
    public static ArrayList<course> courseList=new ArrayList<>();
    Logger logger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=getApplicationContext();
        logger = Logger.getLogger("MainActivity");




        Button viewTimeTable = (Button) findViewById(R.id.TTButton);
        viewTimeTable.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
//              Intent intent = new Intent(context, CartActivity.class);
//
//                startActivity(intent);
            }
        });
        Button addCourse = (Button) findViewById(R.id.addCourseButton);
        addCourse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(context, addCourseActivity.class);
                startActivity(intent);
            }
        });
        if (courseList.isEmpty()) {
            AddInitialEntriesInDB();
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adp = new mainActivityAdapter(this, courseList);
        recyclerView.setAdapter(adp);

    }
    private void AddInitialEntriesInDB() {
        try {
            courseList.add(new course(1, 400, "Computer Networks","1pm","2pm"));

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
