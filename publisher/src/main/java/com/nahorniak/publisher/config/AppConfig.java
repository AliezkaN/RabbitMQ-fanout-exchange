package com.nahorniak.publisher.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public static final String FIRST_QUEUE = "myQueue";
    public static final String SECOND_QUEUE = "myQueue1";
    public static final String EXCHANGE = "message_exchange";

    @Bean
    public Queue firstQueue() {
        return  new Queue(FIRST_QUEUE);
    }

    @Bean Queue secondQueue(){ return  new Queue(SECOND_QUEUE);}

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue firstQueue, FanoutExchange exchange) {
        return BindingBuilder
                .bind(firstQueue)
                .to(exchange);
    }

    @Bean
    public Binding binding1(Queue secondQueue, FanoutExchange exchange){
        return BindingBuilder
                .bind(secondQueue)
                .to(exchange);
    }
    
}
