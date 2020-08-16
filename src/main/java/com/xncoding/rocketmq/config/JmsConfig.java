package com.xncoding.rocketmq.config;


public class JmsConfig {

    /**
     * Name Server 地址
     */
    public static final String NAME_SERVER = "47.115.26.171:9876";
    /**
     * 主题名称 主题一般是服务器设置好 而不能在代码里去新建topic（ 如果没有创建好，生产者往该主题发送消息 会报找不到topic错误）
     */
    public static final String TOPIC = "topic_family";

}
