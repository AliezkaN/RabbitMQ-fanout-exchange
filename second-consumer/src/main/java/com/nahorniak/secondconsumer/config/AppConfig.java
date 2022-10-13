package com.nahorniak.secondconsumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public static final String QUEUE = "myQueue1";

    @Bean
    public Queue queue() {
        return  new Queue(QUEUE);
    }
}
