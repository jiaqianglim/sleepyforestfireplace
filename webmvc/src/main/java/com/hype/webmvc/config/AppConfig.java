package com.hype.webmvc.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hype.webmvc.SvcRepo.TopicRepo;
import com.hype.webmvc.model.Topic;
import com.hype.webmvc.model.TopicCard;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Configuration
@EnableAsync
@EnableScheduling
public class AppConfig {

    @Autowired
    RedisTemplate<String, Integer> redistemp;

    @Autowired
    TopicRepo topicRepo;

    @Scheduled(cron = "@daily")
    public void getDailyTVUpdates() throws IOException {
        String url = UriComponentsBuilder.fromUriString("https://api.tvmaze.com/schedule/web")
                // .queryParam("date", LocalDate.now().toString())
                .toUriString();
        RequestEntity<Void> req = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        RestTemplate temp = new RestTemplate();
        ResponseEntity<String> resp = temp.exchange(req, String.class);
        List<Document> toinsert = new LinkedList<>();
        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonArray resultarray = reader.readArray();
            for (int i = 0; i < resultarray.size(); i++) {
                JsonObject show = resultarray.getJsonObject(i).getJsonObject("_embedded").getJsonObject("show");
                TopicCard inter = new TopicCard(show.getJsonObject("image").getString("medium"), show.getString("name"),
                        "Web-Streaming", show.getJsonObject("image").getString("original"), show.getString("summary"));
                Topic topic = new Topic();
                topic.fromCard(inter);
                toinsert.add(topic.toDocument());
            }
        }
        topicRepo.insertDocuments(toinsert);
    }

    @Scheduled(cron = "0 */10 * * * *")
    public void refreshPopularCount() {
        Set<String> keyset = redistemp.keys("*");
        redistemp.delete(keyset);
    }
}
