package com.xncoding.rabbitmq.controller;

import com.xncoding.rabbitmq.factory.ThreadFactoryImpl;
import com.xncoding.rabbitmq.producer.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class QueueController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueController.class);

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryImpl(
            "SMScheduledThread"));

    @Autowired
    MessageSender messageSender;

    @GetMapping("/sendFanout")
    public void send() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(500);
        int count = 0;
        long startTime = System.currentTimeMillis();

        this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i < 10000; i++){
                    messageSender.sendFanout();
                }

            }
        }, 1, 2, TimeUnit.MINUTES);
        //for(int i = 0; i < 10000; i++){

            //new Thread(()->{
                //messageSender.sendFanout();
                //countDownLatch.countDown();
            //}).start();


            count++;
        //}
        //countDownLatch.await();
        long endTime = System.currentTimeMillis();
        LOGGER.info("呜呜呜呜呜呜呜呜呜-----------"+count);
        LOGGER.info("时间时间-----------"+(endTime-startTime));
    }
}
