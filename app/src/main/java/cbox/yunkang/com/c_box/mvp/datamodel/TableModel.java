package cbox.yunkang.com.c_box.mvp.datamodel;

public class TableModel {

    /**
     * id : 25
     * uuid : null
     * title : 123
     * stage : 123
     * duration : 12
     * heartRange : 3
     * resistance : 112
     * stepFrequency : 1
     * handlePosition : 1
     * essential : 12
     */

    private int id;
    private Object uuid;
    private String title;
    private String stage;
    private String duration;
    private int heartRange;
    private int resistance;
    private int stepFrequency;
    private int handlePosition;
    private String essential;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getUuid() {
        return uuid;
    }

    public void setUuid(Object uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getHeartRange() {
        return heartRange;
    }

    public void setHeartRange(int heartRange) {
        this.heartRange = heartRange;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getStepFrequency() {
        return stepFrequency;
    }

    public void setStepFrequency(int stepFrequency) {
        this.stepFrequency = stepFrequency;
    }

    public int getHandlePosition() {
        return handlePosition;
    }

    public void setHandlePosition(int handlePosition) {
        this.handlePosition = handlePosition;
    }

    public String getEssential() {
        return essential;
    }

    public void setEssential(String essential) {
        this.essential = essential;
    }
}
