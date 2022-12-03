package com.example.project;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = course.class,exportSchema = false,version = 1)
public abstract class courseDatabase extends RoomDatabase {
    private static final String DB_Name="course_db";
    private static courseDatabase instance;

    public static synchronized courseDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),courseDatabase.class,DB_Name).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    public abstract courseDAO courseDAO();
}
