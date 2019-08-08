package cbox.yunkang.com.c_box.mvp.datamodel;

public class RankingData {

    private int number;
    private int photoPath;
    private String kcalValue;
    private String name;

    public RankingData(int number, int photoPath, String kcalValue,String name) {
        this.number = number;
        this.photoPath = photoPath;
        this.kcalValue = kcalValue;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getKcalValue() {
        return kcalValue;
    }

    public void setKcalValue(String kcalValue) {
        this.kcalValue = kcalValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(int photoPath) {
        this.photoPath = photoPath;
    }
}
