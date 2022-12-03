package com.example.project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="task")
public class task {

    @PrimaryKey(autoGenerate = true)
    int taskId;
    @ColumnInfo(name ="courseId")
    int courseId;
    @ColumnInfo(name ="courseName")
    String courseName;
    @ColumnInfo(name ="taskTitle")
    String taskTitle;
    @ColumnInfo(name ="dueDate")
    String dueDate;
    @ColumnInfo(name ="dueTime")
    String dueTime;


    public task(int courseId, String courseName, String taskTitle, String dueDate, String dueTime) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.taskTitle=taskTitle;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }


}
