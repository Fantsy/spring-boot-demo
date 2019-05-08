package com.xjk.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue directQueue() {
        return new Queue("direct");
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    Binding bindingExchange(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with("direct1");
    }
}
