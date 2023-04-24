package com.hype.webmvc.SvcRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.hype.webmvc._messenging.MessageCount;
import com.hype.webmvc.model.TopicCard;

@Service
public class TopicService {

    @Autowired
    RedisTemplate<String, Integer> redistemp;

    @Autowired
    TopicRepo topicRepo;

    public List<TopicCard> getfrontpagetopics() {

        Set<String> redisKeys = redistemp.keys("*");
        HashMap<String, MessageCount> topicactivity = new HashMap<>();
        Iterator<String> it = redisKeys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Integer countvalue = redistemp.opsForValue().get(key);
            MessageCount value = new MessageCount();
            value.topicname = key;
            value.count = countvalue;
            topicactivity.put(key, value);
        }
        TreeMap<String, MessageCount> sorted = new TreeMap<>();
        sorted.putAll(topicactivity);

        List<TopicCard> topTopics = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Optional<Document> doc = topicRepo.getTopicByName(sorted.pollLastEntry().getKey());
            if (doc.isPresent()) {
                topTopics.add(new TopicCard().fromDocument(doc.get()));
            }

        }
        return topTopics;
    }

}
