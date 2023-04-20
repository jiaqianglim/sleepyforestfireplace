package com.hype.webflux.WebsocketMessenging;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatroomController {

    @MessageMapping("/{topic}/chat")
    public ChatroomMessage postMessage(@Payload ChatroomMessage chatroomMessage,
            SimpMessageHeaderAccessor headerAccessor) {
        // headerAccessor.getSessionAttributes().put("username", chatroomMessage.getUser());
        return chatroomMessage;
    }
}
