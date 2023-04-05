package com.togetherness.rsocketserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class MessageController {

    @MessageMapping("send")
    public Mono<Message> hello(String body) {
        System.out.println(body);
        return Mono.just(new Message(body));
    }
}
