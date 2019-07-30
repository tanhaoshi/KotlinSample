package com.qzy.spinning.mvp.datamodel;

public class TodayRanking {

    private String serial;
    private int    photo;
    private String memeberName;
    private String kcal;
    private String averageBeat;
    private String averageLap;

    public TodayRanking(String serial, int photo, String memeberName, String kcal, String averageBeat, String averageLap) {
        this.serial = serial;
        this.photo = photo;
        this.memeberName = memeberName;
        this.kcal = kcal;
        this.averageBeat = averageBeat;
        this.averageLap = averageLap;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getMemeberName() {
        return memeberName;
    }

    public void setMemeberName(String memeberName) {
        this.memeberName = memeberName;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public String getAverageBeat() {
        return averageBeat;
    }

    public void setAverageBeat(String averageBeat) {
        this.averageBeat = averageBeat;
    }

    public String getAverageLap() {
        return averageLap;
    }

    public void setAverageLap(String averageLap) {
        this.averageLap = averageLap;
    }
}
