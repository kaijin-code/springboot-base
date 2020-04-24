package com.xncoding.rabbitmq.controller;

import com.xncoding.rabbitmq.producer.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
public class QueueController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueController.class);

    @Autowired
    MessageSender messageSender;

    @GetMapping("/sendFanout")
    public void send() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        int count = 0;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 5; i++){

            new Thread(()->{
                messageSender.sendFanout();
                countDownLatch.countDown();
            }).start();


            count++;
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        LOGGER.info("呜呜呜呜呜呜呜呜呜-----------"+count);
        LOGGER.info("时间时间-----------"+(endTime-startTime));
    }
}
