package cbox.yunkang.com.c_box.mvp.datamodel;

import android.support.annotation.ColorInt;

public class ScaleProgress {

    private Double scaleTop;
    private Double scaleWidth;
    private int   actionNumber;
    @ColorInt
    private int   signalColor;
    private long  second;

    public ScaleProgress(Double scaleTop, Double scaleWidth, int actionNumber,long second) {
        this.scaleTop = scaleTop;
        this.scaleWidth = scaleWidth;
        this.actionNumber = actionNumber;
        this.second = second;
    }

    public Double getScaleTop() {
        return scaleTop;
    }

    public void setScaleTop(Double scaleTop) {
        this.scaleTop = scaleTop;
    }

    public Double getScaleWidth() {
        return scaleWidth;
    }

    public void setScaleWidth(Double scaleWidth) {
        this.scaleWidth = scaleWidth;
    }

    public int getActionNumber() {
        return actionNumber;
    }

    public void setActionNumber(int actionNumber) {
        this.actionNumber = actionNumber;
    }

    public int getSignalColor() {
        return signalColor;
    }

    public void setSignalColor(int signalColor) {
        this.signalColor = signalColor;
    }

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }
}
