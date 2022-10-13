package com.nahorniak.publisher.controller;

import com.nahorniak.publisher.service.MessagePublisherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MessageController {

    private final MessagePublisherService service;

    @PostMapping("/publish")
    public void sendMessage(@RequestBody String message){
        service.send(message);
    }
}
