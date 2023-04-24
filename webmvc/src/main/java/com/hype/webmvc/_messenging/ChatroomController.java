package com.hype.webmvc._messenging;

import java.time.LocalDate;
import java.util.HashMap;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatroomController {

    @Autowired
    SimpMessagingTemplate temp;

    @Autowired
    RedisTemplate<String, Integer> redistemp;

    @Autowired
    MessageRepo msgrepo;

    @MessageMapping("/{topic}/chat")
    public ChatroomMessage postMessage(@Payload ChatroomMessage chatroomMessage,
            @DestinationVariable("topic") String topic) {
        HashMap<String, String> map = new HashMap<>();
        map.put("user", chatroomMessage.getUser());
        map.put("messagecontent", chatroomMessage.getMessagecontent());
        map.put("date", LocalDate.now().toString());
        map.put("topic", topic);
        Document doc = new Document(map);
        redistemp.opsForValue().increment(topic);
        msgrepo.save(doc);
        return chatroomMessage;
    }

}
