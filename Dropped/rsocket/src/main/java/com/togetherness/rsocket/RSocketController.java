package com.togetherness.rsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;

@Controller
public class RSocketController {

    @MessageMapping("reply.channel")
    public Flux<String> biDirectionalStream(Flux<String> message) {
        return message.map(m -> "response" + m).onErrorReturn("error");
    }
}
