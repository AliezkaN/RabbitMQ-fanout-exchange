package com.nahorniak.consumer.service;

import com.nahorniak.consumer.config.AppConfig;
import com.nahorniak.consumer.messages.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class MessageListenerService {
    @RabbitListener(queues = AppConfig.QUEUE)
    public void listen(CustomMessage message) {
        if (Objects.nonNull(message)){
            log.info("Message has been received from {} : { date : {} ; message : {} }",
                    AppConfig.QUEUE, message.getMessageDate(), message.getMessage());
        }
    }
}
