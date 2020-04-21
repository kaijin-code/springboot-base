package com.xncoding.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.*;
import cn.hutool.system.SystemUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public static String convert(){
        int a = 1;
        String aStr = Convert.toStr(a);
        System.out.println(aStr);

        Object[] obj = {"a", "你", "好", "", 1};
        List<?> list = Convert.toList(obj);
        System.out.println(list);
        return "";
    }

    public static void main(String[] args) {
       /* Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        for (int i = 0; i <5 ; i++) {
            long id = snowflake.nextId();
            System.out.println(id);
        }
*/
       System.out.println(SystemUtil.getRuntimeInfo());



    }
}
