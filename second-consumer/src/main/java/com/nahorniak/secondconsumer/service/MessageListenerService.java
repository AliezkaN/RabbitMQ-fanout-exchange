package com.nahorniak.secondconsumer.service;

import com.nahorniak.secondconsumer.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListenerService {
    @RabbitListener(queues = AppConfig.QUEUE)
    public void listen(String message) {
        log.info("Message has been received from {} : {}",AppConfig.QUEUE, message);
    }
}
