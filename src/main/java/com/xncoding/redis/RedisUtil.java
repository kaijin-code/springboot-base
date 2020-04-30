package com.xncoding.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtil {

    private static final JedisPool jedisPool;

    private RedisUtil(){
    }

    static{
        jedisPool  = (JedisPool) ApplicationContextUtils.getBean("jedisPool");
    }

    public static String get(String key, int indexdb){
        Jedis jedis = null;
        String value = null;

        try{
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            value = jedis.get(key);
        }catch (Exception e){
                e.printStackTrace();
        }finally {
            close(jedis);
        }

        return value;
    }

    public static String get(String key){
        Jedis jedis = null;
        String value = null;

        try{
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }

        return value;
    }

    public static String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String back = jedis.set(key, value);
        close(jedis);
        return back;
    }

    public static String setex(String key, int seconds, String value) {
        Jedis jedis = jedisPool.getResource();
        String back = jedis.setex(key, seconds, value);
        close(jedis);
        return back;
    }

    public static Long hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long back = jedis.hset(key, field, value);
        close(jedis);
        return back;
    }

    public static boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        boolean back = jedis.exists(key);
        close(jedis);
        return back;
    }

    public static Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long back = jedis.del(key);
        close(jedis);
        return back;
    }



    private static void close(Jedis jedis){

        if(null != jedis){
            jedis.close();
        }
    }
}
