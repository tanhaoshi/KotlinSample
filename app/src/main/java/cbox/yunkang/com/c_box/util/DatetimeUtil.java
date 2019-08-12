package cbox.yunkang.com.c_box.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtil {

    public static String timeParse(long duration) {
        String time = "" ;
        long minute = duration / 60000 ;
        long seconds = duration % 60000 ;
        long second = Math.round((float)seconds/1000) ;
        if( minute < 10 ){
            time += "0" ;
        }
        time += minute+":" ;
        if( second < 10 ){
            time += "0" ;
        }
        time += second ;
        return time ;
    }

    public static String formatLongToTimeStr(Long l) {
        int hour = 0;
        int minute = 0;
        int second = 0;

        second = l.intValue();

        String secondContent = "";

        if (second > 60) {
            minute = second / 60;         //取整
            second = second % 60;         //取余
        }

        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }

        if(second < 10){
            secondContent = "0"+second;
        }else{
            secondContent = ""+second;
        }

        String strtime = hour+":"+minute+":"+secondContent;
        return strtime;

    }

    public static int Date2ms(String date){
        if(date.length() > 3){
            String[] time = date.split(":");
            int min = Integer.valueOf(time[0]) * 60;
            int seconds = Integer.valueOf(time[1]);
            return min + seconds;
        }else{
            return Integer.valueOf(date);
        }
    }

}
