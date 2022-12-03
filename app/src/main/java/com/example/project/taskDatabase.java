package com.example.project;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


    @Database(entities = task.class,exportSchema = false,version = 1)
    public abstract class taskDatabase extends RoomDatabase {
        private static final String DB_Name="task_db";
        private static taskDatabase instance;

        public static synchronized taskDatabase getInstance(Context context){
            if(instance==null){
                instance= Room.databaseBuilder(context.getApplicationContext(), taskDatabase.class,DB_Name).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return instance;
        }
        public abstract taskDAO taskDAO();

}
