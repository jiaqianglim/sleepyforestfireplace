package com.hype.webmvc._messenging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatroomController {

    @Autowired
    SimpMessagingTemplate temp;

    @MessageMapping("/{topic}/chat")
    public ChatroomMessage postMessage(@Payload ChatroomMessage chatroomMessage) {
        return chatroomMessage;
    }

}
