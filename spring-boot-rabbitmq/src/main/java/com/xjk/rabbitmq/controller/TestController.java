package com.xjk.rabbitmq.controller;

import com.xjk.rabbitmq.rabbit.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xjk.rabbitmq.rabbit.direct.DirectSender;
import com.xjk.rabbitmq.rabbit.fanout.FanoutSender;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private DirectSender directSender;

    @Autowired
    private TopicSender topicSender;

    @RequestMapping(value = "sendFanout" ,method = RequestMethod.GET)
    public String sendFanout(){
        fanoutSender.send();
        return "ok";
    }

    @RequestMapping(value = "sendDirect",method = RequestMethod.GET)
    public String sendDirect(){
        directSender.send();
        return "ok";
    }

    @RequestMapping(value = "sendTopic3",method = RequestMethod.GET)
    public String sendTopic3(){
        topicSender.send3();
        return "ok";
    }

    @RequestMapping(value = "sendTopic4",method = RequestMethod.GET)
    public String sendTopic4(){
        topicSender.send4();
        return "ok";
    }

    @RequestMapping(value = "sendTopic1",method = RequestMethod.GET)
    public String sendTopic1(){
        topicSender.send1();
        return "ok";
    }

    @RequestMapping(value = "sendTopic2",method = RequestMethod.GET)
    public String sendTopic2(){
        topicSender.send2();
        return "ok";
    }
}
