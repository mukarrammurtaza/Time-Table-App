package com.example.project;

import java.sql.Time;

public class course {
    int courseId;
    int roomNumber;
    String courseName;
    String courseSTime;
    String courseETime;

    public course(int courseId, int roomNumber, String courseName, String courseSTime,String courseETime) {
        this.courseId = courseId;
        this.roomNumber = roomNumber;
        this.courseName = courseName;
        this.courseSTime = courseSTime;
        this.courseETime = courseETime;
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

    public String getCourseSTime() {
        return courseSTime;
    }

    public void setCourseSTime(String courseTime) {
        this.courseSTime = courseSTime;
    }

    public String getCourseETime() {
        return courseETime;
    }

    public void setCourseETime(String courseTime) {
        this.courseETime = courseETime;
    }
}