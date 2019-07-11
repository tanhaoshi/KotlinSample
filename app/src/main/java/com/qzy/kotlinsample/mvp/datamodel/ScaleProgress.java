package com.qzy.kotlinsample.mvp.datamodel;

public class ScaleProgress {

    private Double scaleTop;
    private Double scaleWidth;
    private int   actionNumber;
    private int   signalColor;

    public ScaleProgress(Double scaleTop, Double scaleWidth, int actionNumber) {
        this.scaleTop = scaleTop;
        this.scaleWidth = scaleWidth;
        this.actionNumber = actionNumber;
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
}
