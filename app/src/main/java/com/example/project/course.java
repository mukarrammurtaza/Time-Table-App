package com.example.project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Time;
@Entity(tableName="course")
public class course {
    @PrimaryKey(autoGenerate = true)
    int courseId;
    @ColumnInfo(name ="roomNumber")
    int roomNumber;
    @ColumnInfo(name ="courseName")
    String courseName;
    @ColumnInfo(name ="courseStartTime")
    String courseSTime;
    @ColumnInfo(name ="courseEndTime")
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