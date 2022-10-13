package com.nahorniak.publisher.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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

    @Bean
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }
}
