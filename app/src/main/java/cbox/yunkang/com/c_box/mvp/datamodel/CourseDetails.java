package cbox.yunkang.com.c_box.mvp.datamodel;


import java.util.List;

public class CourseDetails {

    private String details;

    private List<CourseDurantion> mDurantions;

    public CourseDetails(String details, List<CourseDurantion> durantions) {
        this.details = details;
        mDurantions = durantions;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<CourseDurantion> getDurantions() {
        return mDurantions;
    }

    public void setDurantions(List<CourseDurantion> durantions) {
        mDurantions = durantions;
    }
}
