package com.example.RabbitPOC.pub_sub;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    public void send(Integer msg) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", msg);
        System.out.println("[x] sent " + msg);
    }
}
