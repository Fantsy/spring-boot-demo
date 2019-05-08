package com.xjk.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class QueueConsumer {

    @JmsListener(destination = "${activemq.test.queueName}",containerFactory = "jmsListenerContainerQueue")
    public void receiveMsg(String text){
        System.out.println("QueueConsumer收到消息:"+text);
    }
}
