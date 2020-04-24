package com.rabbitmq.multi_mq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestSecondConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue("rabbitmq2")
            , exchange = @Exchange("rabbitmq2")
            , key = "rabbitmq2")
            , containerFactory = "secondFactory")
    @RabbitHandler
    public void receive(Object obj) {
        log.info("rabbitmq2 , {}", obj);
    }
}
