package com.qzy.spinning.mvp.datamodel;

public class CourseModel {

    private String courseName;
    private int level;
    private String price;
    private String pastPrice;
    private int imagePath;
    private String useCount;
    private String duration;
    private boolean isAttempt;

    public CourseModel(String courseName, int level, String price, String pastPrice, int imagePath, String useCount, String duration, boolean isAttempt) {
        this.courseName = courseName;
        this.level = level;
        this.price = price;
        this.pastPrice = pastPrice;
        this.imagePath = imagePath;
        this.useCount = useCount;
        this.duration = duration;
        this.isAttempt = isAttempt;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPastPrice() {
        return pastPrice;
    }

    public void setPastPrice(String pastPrice) {
        this.pastPrice = pastPrice;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getUseCount() {
        return useCount;
    }

    public void setUseCount(String useCount) {
        this.useCount = useCount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isAttempt() {
        return isAttempt;
    }

    public void setAttempt(boolean attempt) {
        isAttempt = attempt;
    }
}
