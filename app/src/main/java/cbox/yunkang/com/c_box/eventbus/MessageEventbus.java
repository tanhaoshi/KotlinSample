package cbox.yunkang.com.c_box.eventbus;

import android.support.v4.util.Pools;


public class MessageEventbus {

    private static final Pools.SimplePool<MessageEventbus> sPool = new Pools.SimplePool<>(10);

    public  static MessageEventbus obtain(String type,Object o){
        MessageEventbus instance = sPool.acquire();
        return (instance != null) ? instance : new MessageEventbus(type,o);
    }

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
