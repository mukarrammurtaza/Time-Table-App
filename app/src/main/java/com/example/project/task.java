package com.example.project;

public class task {
    int courseId;
    String courseName;
    String taskTitle;
    String dueDate;
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
