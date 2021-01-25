package com.six.map.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期处理
 *
 * @author zcl<yczclcn@163.com>
 */
public class DateUtils {

   private static final long time = 60*1000;//60秒
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";

    public final static String DATE_PATTERN_1 = "yyyyMMdd";

    /**
     * 时间格式(yyyy/MM/dd)
     */
    public final static String DATE_PATTERN_SLASH = "yyyy/MM/dd";

    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间格式(yyyy年M月dd日 ah:mm:ss) 代码生成器使用
     */
    public final static String DATE_TIME_CHN_PATTERN = "yyyy年M月dd日 ah:mm:ss";

    public final static String DATE_TIME_PATTERN_1 = "yyyyMMddHHmmss";


    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    public static String formatUAT(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date.getTime() - 8*60*time);
        }
        return null;
    }
}
