package com.example.project;

import java.sql.Time;

public class course {
    int courseId;
    int roomNumber;
    String courseName;
    Time courseTime;

    public course(int courseId, int roomNumber, String courseName, Time courseTime) {
        this.courseId = courseId;
        this.roomNumber = roomNumber;
        this.courseName = courseName;
        this.courseTime = courseTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Time getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Time courseTime) {
        this.courseTime = courseTime;
    }
}