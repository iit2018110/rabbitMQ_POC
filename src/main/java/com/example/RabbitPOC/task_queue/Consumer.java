package com.example.RabbitPOC.task_queue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello")
public class Consumer {
    private int srId;
    public Consumer(int srId) {
        this.srId = srId;
    }

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("[x] received in ("+ srId + ") : " + msg);
    }
}
