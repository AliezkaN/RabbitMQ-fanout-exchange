package com.nahorniak.secondconsumer.service;

import com.nahorniak.secondconsumer.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.nahorniak.secondconsumer.messages.CustomMessage;

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
