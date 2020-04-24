package com.rabbitmq.multi_mq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestFirstConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue("rabbitmq1")
            , exchange = @Exchange("rabbitmq1")
            , key = "rabbitmq1")
            , containerFactory = "firstFactory")
    @RabbitHandler
    public void receive(Object obj) {
        log.info("rabbitmq1 , {}", obj);
    }

}
