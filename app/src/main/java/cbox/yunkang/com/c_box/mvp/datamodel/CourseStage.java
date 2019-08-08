package cbox.yunkang.com.c_box.mvp.datamodel;

import java.util.List;

public class CourseStage {

    private String stageName;
    private List<StageContent> mContents;

    public CourseStage(String stageName, List<StageContent> contents) {
        this.stageName = stageName;
        mContents = contents;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public List<StageContent> getContents() {
        return mContents;
    }

    public void setContents(List<StageContent> contents) {
        mContents = contents;
    }
}
