package com.nahorniak.publisher.controller;

import com.nahorniak.publisher.messages.CustomMessage;
import com.nahorniak.publisher.service.MessagePublisherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MessageController {

    private final MessagePublisherService service;

    @PostMapping("/publish")
    public String sendMessage(@RequestBody CustomMessage customMessage){
        service.send(customMessage);
        return "Message successfully published";
    }
}
