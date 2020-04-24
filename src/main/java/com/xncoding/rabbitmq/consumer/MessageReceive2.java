package com.xncoding.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageReceive2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceive2.class);

    @RabbitListener(queues = "Hello")
    public void process(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        LOGGER.info("I am Receiver2 哈哈哈哈哈  : " + message);
    }

}


