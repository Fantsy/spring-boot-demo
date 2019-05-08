package com.xjk.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class TopicConsumerB {

    @JmsListener(destination = "test.topic",containerFactory = "jmsListenerContainerTopic")
    public void receiveMsg(String text){
        System.out.println("TopicConsumerB收到消息:"+text);
    }
}
