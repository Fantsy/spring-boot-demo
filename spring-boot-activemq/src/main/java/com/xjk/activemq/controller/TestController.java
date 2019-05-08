package com.xjk.activemq.controller;

import com.xjk.activemq.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activemq")
public class TestController {

    @Autowired
    private Producer producer;

    @Value("${activemq.test.queueName}")
    private String queueName;

    @Value("${activemq.test.topicName}")
    private String topicName;

     @RequestMapping(value = "/sendQueue",method = RequestMethod.GET)
    public String sendQueueMsg(@RequestParam String msg){
        producer.sendQueueMsg(queueName,msg);
        return "ok";
    }


    @RequestMapping(value = "/sendTopic",method = RequestMethod.GET)
    public String sendTopicMsg(@RequestParam String msg){
        producer.sendTopicMsg(topicName,msg);
        return "ok";
    }
}
