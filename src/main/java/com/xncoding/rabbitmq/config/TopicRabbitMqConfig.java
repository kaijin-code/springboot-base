package com.xncoding.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * queueMessages 同时匹配两个队列，queueMessage 只匹配topic.message队列。
 */

@Configuration
public class TopicRabbitMqConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    //定义队列
    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitMqConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitMqConfig.messages);
    }

    //交换机
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    //将队列和交换机绑定
    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
