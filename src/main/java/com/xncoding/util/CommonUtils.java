package com.xncoding.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.*;
import cn.hutool.system.SystemUtil;
import com.xncoding.common.LanguageCode;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class CommonUtils {

    public static String getTime() {
        //当前时间
        Date date = DateUtil.date();
        System.out.println(date);

//当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println(now);
        return now;
    }

    public int a(int b){
        return b;
    }

    public static String convert(){
        int a = 1;
        String aStr = Convert.toStr(a);
        System.out.println(aStr);

        Object[] obj = {"a", "你", "好", "", 1};
        List<?> list = Convert.toList(obj);
        System.out.println(list);
        return "";
    }

    public static void main(String[] args) throws InterruptedException {

    }
}
