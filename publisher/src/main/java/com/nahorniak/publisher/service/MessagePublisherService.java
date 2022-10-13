package com.nahorniak.publisher.service;

import com.nahorniak.publisher.config.AppConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessagePublisherService {

    private final RabbitTemplate template;
    private final FanoutExchange fanoutExchange;
    public void send(String message){
        template.convertAndSend(fanoutExchange.getName(),"",message);
    }

}
