package com.example.project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface courseDAO {
    @Query("Select * FROM course")
    List<course> getAllCourses();


    @Insert
    void insertCourse(course c);

    @Update
    void updateCourse(course c);

    @Delete
    void deleteCourse(course c);
}
