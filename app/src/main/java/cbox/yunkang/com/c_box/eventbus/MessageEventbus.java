package cbox.yunkang.com.c_box.eventbus;

public class MessageEventbus {

    private String type;
    private Object mObject;

    public MessageEventbus(String type , Object object){
        this.type    = type;
        this.mObject = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getObject() {
        return mObject;
    }

    public void setObject(Object object) {
        mObject = object;
    }
}
