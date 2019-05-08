package com.xjk.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfig {

    public final static String message1 = "topic.message1";
    public final static String message2 = "topic.message2";
    public final static String message3 = "topic.message3";

    @Bean
    public Queue queueMessage1() {
        return new Queue(TopicRabbitConfig.message1);
    }

    @Bean
    public Queue queueMessage2() {
        return new Queue(TopicRabbitConfig.message2);
    }

    @Bean
    public Queue queueMessage3() {
        return new Queue(TopicRabbitConfig.message3);
    }


    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage1(Queue queueMessage1, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.message1");
    }

    @Bean
    Binding bindingExchangeMessage2(Queue queueMessage2, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.message2");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessage3, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage3).to(exchange).with("topic.#");
    }

}