package com.xncoding.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Kreceive {

    private ObjectMapper objectMapper;
    //private List<MQMessage> mqMessageList;
    private long maxMessageCount=100;

    @KafkaListener(topics = "${spring.kafka.topic.name}")
    public void receive(ConsumerRecord<?, ?> record){

        Optional<?> mqMessage = Optional.ofNullable(record.value());
        System.out.print(mqMessage);
    }
}
