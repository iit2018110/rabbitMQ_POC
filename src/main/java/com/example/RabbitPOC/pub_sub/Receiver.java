package com.example.RabbitPOC.pub_sub;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Receiver {
    @RabbitListener(queues = "#{queue1.name}")
    public void receive1(Integer msg) {
        showMsg(1,msg);
    }

    @RabbitListener(queues = "#{queue2.name}")
    public void receive2(Integer msg) {
        showMsg(2,msg);
    }

    private void showMsg(Integer sr, Integer msg) {
        System.out.println("[x] received in queue (" + sr + ") : " + msg);
    }
}
