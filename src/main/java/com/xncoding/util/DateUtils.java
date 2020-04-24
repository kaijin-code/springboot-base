package com.xncoding.util;

import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/***
 * 日期工具类
 */
public class DateUtils {

    public static Date getCurrentDate(){
        return DateUtil.date();
    }

    //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
    public static String getCurrentTime(){
        return DateUtil.now();
    }

    //当前日期字符串，格式：yyyy-MM-dd
    public static String getCurrent2Date(){
        return DateUtil.today();
    }

    public static Date string2Date (String time, String format){
        return DateUtil.parse(time, format);
    }

    public static String DateTime2String(Date date){
        return DateUtil.formatDateTime(date);
    }

    public static String Date2String(Date date){
        return DateUtil.formatDate(date);
    }

    public static Date getDateNowRelate(){
        //昨天
        DateUtil.yesterday();
        //明天
        DateUtil.tomorrow();
        //上周
        DateUtil.lastWeek();
        //下周
        DateUtil.nextWeek();
        //上个月
        DateUtil.lastMonth();
        //下个月
        DateUtil.nextMonth();

        return  DateUtil.yesterday();
    }

    //两个时间相差
    public static long getBetweenTime(String dateStr1, String dateStr2){
        Date date1 = DateUtil.parse(dateStr1);
        Date date2 = DateUtil.parse(dateStr2);
        return DateUtil.between(date1, date2, DateUnit.DAY);
    }

    // birthDay yyyy-MM-dd
    public static int getAgeByBirthDay(String birthDay){
       return DateUtil.ageOfNow(birthDay);
    }


}
