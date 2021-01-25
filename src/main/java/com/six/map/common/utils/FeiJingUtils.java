package com.six.map.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class FeiJingUtils {

    public static String parseFeiJingTimes(String feiJingTime){
        if(feiJingTime.trim().equals("")|| feiJingTime == null) {
            return "";
        }
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/M/dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy/M/d HH:mm:ss");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy/MM/d HH:mm:ss");
        SimpleDateFormat format4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = format1.parse(feiJingTime);
        } catch (Exception e) {
            try {
                date = format2.parse(feiJingTime);
            } catch (ParseException e1) {
                try {
                    date = format3.parse(feiJingTime);
                } catch (ParseException e2) {
                    try {
                        date = format4.parse(feiJingTime);
                    } catch (ParseException e3) {
                        log.error("飞鲸数据转换异常，time = {}",feiJingTime);
                        e3.printStackTrace();
                        return feiJingTime;
                    }
                }
            }
        }
        return format4.format(date);
    }


    public static String parseFeiJingTimesSecondes(String feiJingTime){
        if(feiJingTime.trim().equals("")|| feiJingTime == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(feiJingTime);
        } catch (Exception e) {
            log.error("飞鲸数据转换异常，time = {}",feiJingTime);
            e.printStackTrace();
            return feiJingTime;
        }
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return format1.format(date);
    }
}
