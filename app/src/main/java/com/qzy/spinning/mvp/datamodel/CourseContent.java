package com.qzy.spinning.mvp.datamodel;

import java.util.List;

public class CourseContent {

    private String courseName;

    private List<CourseDetails> mCourseDetails;

    public CourseContent(String courseName, List<CourseDetails> courseDetails) {
        this.courseName = courseName;
        mCourseDetails = courseDetails;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<CourseDetails> getCourseDetails() {
        return mCourseDetails;
    }

    public void setCourseDetails(List<CourseDetails> courseDetails) {
        mCourseDetails = courseDetails;
    }
}
