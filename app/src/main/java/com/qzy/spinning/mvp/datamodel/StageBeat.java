package com.qzy.spinning.mvp.datamodel;

import java.util.List;

public class StageBeat {

    private String beatName;
    private List<StageAction> mActions;

    public StageBeat(String beatName, List<StageAction> actions) {
        this.beatName = beatName;
        mActions = actions;
    }

    public String getBeatName() {
        return beatName;
    }

    public void setBeatName(String beatName) {
        this.beatName = beatName;
    }

    public List<StageAction> getActions() {
        return mActions;
    }

    public void setActions(List<StageAction> actions) {
        mActions = actions;
    }
}
