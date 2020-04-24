package com.xncoding.util;


import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Method;

/***
 * 反射工具类
 */
public class ReflectUtils {

    /***
     * 获取指定类的所有方法包含父类方法
     * @param bean
     * @return
     */
    public static Method[] getMethods(Class<?> bean){
       return ReflectUtil.getMethods(bean);
    }

    /***
     * 获取指定类的一个方法(无参)
     * @param bean
     * @param methodName
     * @return
     */
    public static Method getMethodByName(Class<?> bean, String methodName){
        return ReflectUtil.getMethod(bean, methodName);
    }

    /***
     * 获取指定类的一个方法(有参)
     * @param bean
     * @param methodName
     * @param paramTypes
     * @return
     */
    public static Method getMethodByNameAndParam(Class<?> bean, String methodName, Class<?>... paramTypes){
        return ReflectUtil.getMethod(bean, methodName, paramTypes);
    }

    /***
     * 调用方法
      * @param object
     * @param methodName
     * @param args
     */
     public static void invokeMethod(Object object, String methodName, Object... args){
         ReflectUtil.invoke(object, methodName, args);
     }


}
