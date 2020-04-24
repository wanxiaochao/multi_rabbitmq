package com.rabbitmq.multi_mq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestFirstSender extends MultiRabbitTemplate{


    public void send(Object msg) {
        log.info("rabbitmq1 , msg: {}", msg);
        firstRabbitTemplate.convertAndSend("rabbitmq1", msg);
    }

    public void rabbitmq1sender() {
        this.send("innerpeacez1");
    }



}
