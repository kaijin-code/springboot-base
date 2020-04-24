package com.xncoding.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/***
 * 唯一id生成工具类
 * UUID
 * ObjectId（MongoDB）
 * Snowflake（百度使用）
 */
public class IdUtils {

      public static String generateUUid(){
         return  IdUtil.randomUUID();
      }

      public static String generateSimleUUid(){
        return  IdUtil.simpleUUID();
      }

      public static String generateObjectId(){
                return IdUtil.objectId();
      }

      public static long generateSnowflake(long workerId, long datacenterId){
          Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
          return  snowflake.nextId();
      }
}
