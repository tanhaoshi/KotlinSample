package com.qzy.spinning.mvp.datamodel;

public class RankingData {

    private int number;
    private String photoPath;
    private String kcalValue;

    public RankingData(int number, String photoPath, String kcalValue) {
        this.number = number;
        this.photoPath = photoPath;
        this.kcalValue = kcalValue;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getKcalValue() {
        return kcalValue;
    }

    public void setKcalValue(String kcalValue) {
        this.kcalValue = kcalValue;
    }
}
