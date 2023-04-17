package com.togetherness.websocketserver;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Mono;

public class MyWebSocketHandler implements WebSocketHandler{

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.receive().doOnNext(message -> {
            System.out.println(message);
        }).then();
    }
    
}