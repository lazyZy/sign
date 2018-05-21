package top.mrzhao.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZY on 2018/4/16.
 */
public class DateUtils {
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getFormate(Date date){
        String time = format.format(date.getTime());
        return time;
    }
}
