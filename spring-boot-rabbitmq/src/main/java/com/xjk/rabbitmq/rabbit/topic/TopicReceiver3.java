package com.xjk.rabbitmq.rabbit.topic;

import com.xjk.rabbitmq.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = TopicRabbitConfig.message3)
public class TopicReceiver3 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver3  : " + message);
    }

}
