package com.xjk.rabbitmq.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;


	public void send1() {
		String context = "hi, i am message 1";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message1", context);
	}

	public void send2() {
		String context = "hi, i am message3 2";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message2", context);
	}

	public void send3() {
		String context = "hi, i am message 3";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
	}
	public void send4() {
		String context = "hi, i am message 4";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "top.message", context);
	}

}