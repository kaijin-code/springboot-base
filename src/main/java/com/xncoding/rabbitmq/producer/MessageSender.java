package com.xncoding.rabbitmq.producer;

import com.xncoding.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send(){
        String context = "message----" + DateUtils.getCurrentTime()+"中国制造";
        LOGGER.info("Sender : " + context);
        this.rabbitTemplate.convertAndSend("Hello", context);


    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }

    public void sendFanout() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
}
