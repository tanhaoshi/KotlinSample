package com.qzy.spinning.mvp.datamodel;

import java.util.List;

public class StageContent {

    private String contentName;
    private List<StageDuration> mDurations;

    public StageContent(String contentName, List<StageDuration> durations) {
        this.contentName = contentName;
        mDurations = durations;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public List<StageDuration> getDurations() {
        return mDurations;
    }

    public void setDurations(List<StageDuration> durations) {
        mDurations = durations;
    }
}
