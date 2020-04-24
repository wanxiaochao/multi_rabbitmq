package com.rabbitmq.multi_mq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestSecondSender extends MultiRabbitTemplate {

    public void send(Object msg) {
        log.info("rabbitmq2 , msg: {}", msg);
        secondRabbitTemplate.convertAndSend("rabbitmq2", msg);
    }

    public void rabbitmq2sender() {
        this.send("innerpeacez2");
    }

}
