package com.xncoding.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageReceive {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceive.class);

    @RabbitListener(queues = "Hello")
    public void process(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        LOGGER.info("I am Receiver  : " + message);
    }

    @RabbitListener(queues = "topic.message")
    public void process1(String message) {
        System.out.println("Topic Receiver1  : " + message);
    }

    @RabbitListener(queues = "topic.messages")
    public void process2(String message) {
        System.out.println("Topic Receiver2  : " + message);
    }

    @RabbitListener(queues = "fanout.A")
    public void processA(String message) {
        System.out.println("fanout Receiver A:  : " + message);
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(String message) {
        System.out.println("fanout Receiver B: : " + message);
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(String message) {
        System.out.println("fanout Receiver C: " + message);
    }
}


