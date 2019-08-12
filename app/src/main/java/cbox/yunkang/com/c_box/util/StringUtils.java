package cbox.yunkang.com.c_box.util;

import android.graphics.Color;
import android.text.TextUtils;

public class StringUtils {

    public static final int STENTH_1 = 1;
    public static final int STENTH_2 = 2;
    public static final int STENTH_3 = 3;
    public static final int STENTH_4 = 4;
    public static final int STENTH_5 = 5;
    public static final int STENTH_ERROR = -1;

    public static  int getStrainType(String train)
    {
        if(TextUtils.isEmpty(train))
        {
            return STENTH_ERROR;
        }
        String  trainStrengths = train.replace("%","");
        double trains = Double.parseDouble(trainStrengths);
        if(trains > 0 && trains < 60)
        {
            return STENTH_1;
        }
        else if(trains > 60 && trains < 70)
        {
            return STENTH_2;
        }
        else if(trains > 70 && trains < 80)
        {
            return STENTH_3;
        }
        else if(trains > 80 && trains < 90)
        {
            return STENTH_4;
        }
        else if(trains > 90 && trains < 100)
        {
            return STENTH_5;
        }
        return STENTH_ERROR;
    }

    public static int getColor( int type)
    {
        int color = -1;
        switch (type)
        {
            case STENTH_ERROR:
            case STENTH_1:
                color = Color.parseColor("#A2AEBD");
                break;
            case STENTH_2:
                color = Color.parseColor("#5C9BFF");
                break;
            case STENTH_3:
                color = Color.parseColor("#16C874");
                break;
            case STENTH_4:
                color = Color.parseColor("#FF8700");
                break;
            case STENTH_5:
                color = Color.parseColor("#FE1B1C");
                break;
        }
        return color;
    }
}
