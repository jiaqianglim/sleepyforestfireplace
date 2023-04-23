package com.hype.webflux.WebsocketMessenging;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;

@Controller
public class ChatroomController {

    @Autowired
    SimpMessagingTemplate temp;

    @MessageMapping("/{topic}/chat")
    public ChatroomMessage postMessage(@Payload ChatroomMessage chatroomMessage) {
        return chatroomMessage;
    }

    @MessageMapping("/lipsum")
    public Flux<String> sampleMessage() {
        return Flux.just(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras interdum in diam sed fermentum. Nunc volutpat suscipit luctus. Praesent tristique eu nulla nec auctor. Morbi id consequat odio. Proin tincidunt fermentum tortor vel condimentum. Quisque mollis, ipsum et cursus feugiat, nisl risus lacinia felis, pretium porta urna lorem quis enim. In feugiat eleifend tellus sit amet egestas. Mauris rhoncus ipsum velit, nec tincidunt ipsum tristique vestibulum. Proin luctus mauris ut orci laoreet, sit amet rutrum metus euismod. Maecenas condimentum ultrices dictum. Nam nec finibus leo, non venenatis nibh. Sed et facilisis turpis, commodo congue massa. Duis molestie accumsan eros eu dictum. Maecenas lobortis semper auctor. "
                        .split(". "))
                .delayElements(Duration.ofMillis(100));
    }
}
