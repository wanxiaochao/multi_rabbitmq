package com.rabbitmq.multi_mq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public abstract class MultiRabbitTemplate {
    @Resource
    public AmqpTemplate firstRabbitTemplate;

    @Resource
    public AmqpTemplate secondRabbitTemplate;
}
