package com.qzy.spinning.mvp.datamodel;

import java.util.HashMap;

public class CourseTable {


    /**
     * code : 200
     * data : {"11":{"title":"课程名称","stage":"课程阶段","duration":"时长","heartRange":1,"resistance":80,"stepFrequency":10,"handlePosition":1,"essential":"动作要领"},"22":{"title":"12","stage":"12","duration":"12","heartRange":4,"resistance":112,"stepFrequency":1,"handlePosition":1,"essential":"12121212"},"23":{"title":"1","stage":"2","duration":"3","heartRange":4,"resistance":4,"stepFrequency":5,"handlePosition":4,"essential":"6"},"24":{"title":"12","stage":"123","duration":"12","heartRange":4,"resistance":1,"stepFrequency":1,"handlePosition":1,"essential":"12"},"14":{"title":"课程名称","stage":"课程阶段","duration":"时长","heartRange":1,"resistance":80,"stepFrequency":10,"handlePosition":1,"essential":"动作要领"},"25":{"title":"123","stage":"123","duration":"12","heartRange":3,"resistance":112,"stepFrequency":1,"handlePosition":1,"essential":"12"},"15":{"title":"课程名称","stage":"课程阶段","duration":"时长","heartRange":1,"resistance":80,"stepFrequency":10,"handlePosition":1,"essential":"动作要领"},"16":{"title":"课程名称","stage":"课程阶段","duration":"时长","heartRange":1,"resistance":80,"stepFrequency":10,"handlePosition":1,"essential":"动作要领"},"17":{"title":"课程名称","stage":"课程阶段","duration":"时长","heartRange":1,"resistance":80,"stepFrequency":10,"handlePosition":1,"essential":"动作要领"},"18":{"title":null,"stage":null,"duration":null,"heartRange":null,"resistance":null,"stepFrequency":null,"handlePosition":null,"essential":null},"19":{"title":null,"stage":null,"duration":null,"heartRange":null,"resistance":null,"stepFrequency":null,"handlePosition":null,"essential":null},"20":{"title":null,"stage":null,"duration":null,"heartRange":null,"resistance":null,"stepFrequency":null,"handlePosition":null,"essential":null},"21":{"title":null,"stage":null,"duration":null,"heartRange":null,"resistance":null,"stepFrequency":null,"handlePosition":null,"essential":null}}
     * message : OK
     */

    private int code;
    private HashMap<String,TableModel> data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HashMap<String, TableModel> getData() {
        return data;
    }

    public void setData(HashMap<String, TableModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
