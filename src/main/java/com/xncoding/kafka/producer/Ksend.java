package com.xncoding.kafka.producer;

import com.sun.xml.internal.ws.developer.StreamingAttachment;
import com.xncoding.rabbitmq.consumer.MessageReceive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Ksend {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceive.class);

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String msg) {

        long start = System.currentTimeMillis();
        kafkaTemplate.send(topicName,msg);
        long end = System.currentTimeMillis();
        LOGGER.info("写入kafka，耗时："+(end-start)+"毫秒");
    }

}
