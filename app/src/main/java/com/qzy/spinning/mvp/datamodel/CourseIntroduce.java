package com.qzy.spinning.mvp.datamodel;

import java.util.List;

public class CourseIntroduce {

    private String serialName;
    private List<CourseStage> mStages;

    public CourseIntroduce(String serialName, List<CourseStage> stages) {
        this.serialName = serialName;
        mStages = stages;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    public List<CourseStage> getStages() {
        return mStages;
    }

    public void setStages(List<CourseStage> stages) {
        mStages = stages;
    }
}
