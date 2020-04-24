package com.rabbitmq.multi_mq;

import com.rabbitmq.multi_mq.config.TestFirstSender;
import com.rabbitmq.multi_mq.config.TestSecondSender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class MultiMqApplicationTests {

    @Autowired
    private TestFirstSender firstSender;
    @Autowired
    private TestSecondSender secondSender;

    /**
     * 一百个线程向 First Rabbitmq 的 rabbitmq1 queue中发送一百条消息
     */
    @Test
    public void testFirstSender() {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    firstSender.rabbitmq1sender()
            ).start();
        }
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一百个线程向 Second Rabbitmq 的 rabbitmq2 queue中发送一百条消息
     */
    @Test
    public void testSecondSender() {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    secondSender.rabbitmq2sender()
            ).start();
        }
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
