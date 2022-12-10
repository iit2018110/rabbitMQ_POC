package com.example.RabbitPOC.task_queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(Integer msg) {
        this.rabbitTemplate.convertAndSend(queue.getName(), String.valueOf(msg));
        System.out.println("[x] sent " + String.valueOf(msg));
    }
}
