package com.example.project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface taskDAO {
    @Query("Select * FROM task")
    List<task> getAllTasks();


    @Insert
    void insertTask(task t);

    @Update
    void updateTask(task t);

    @Delete
    void deleteTask(task t);
}
