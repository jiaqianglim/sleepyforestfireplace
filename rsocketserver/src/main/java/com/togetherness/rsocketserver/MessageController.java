package com.togetherness.rsocketserver;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class MessageController {

    @Autowired
    MessageRepository msgRepo;

    @MessageMapping("send")
    public Mono<Message> hello(String body) {
        return msgRepo.save(new Message(body, Instant.now()));
    }

    @MessageMapping("messages")
    public Flux<Message> messageStream() {
        return msgRepo.getMessagesBy();
    }
}
