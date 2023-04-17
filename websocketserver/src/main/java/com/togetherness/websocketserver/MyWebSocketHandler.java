package com.togetherness.websocketserver;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MyWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        
        Flux<WebSocketMessage> output = session.receive().doOnNext(message -> {
            System.out.println(message.toString());
        });
        System.out.println("message received");
        return session.send(output).then();
    }

}