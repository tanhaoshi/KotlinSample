package cbox.yunkang.com.c_box.mvp.datamodel;

import java.util.List;

public class StageDuration {

    private String durationName;
    private List<StageBeat> mBeats;

    public StageDuration(String durationName, List<StageBeat> beats) {
        this.durationName = durationName;
        mBeats = beats;
    }

    public String getDurantionName() {
        return durationName;
    }

    public void setDurantionName(String durantionName) {
        this.durationName = durantionName;
    }

    public List<StageBeat> getBeats() {
        return mBeats;
    }

    public void setBeats(List<StageBeat> beats) {
        mBeats = beats;
    }
}
