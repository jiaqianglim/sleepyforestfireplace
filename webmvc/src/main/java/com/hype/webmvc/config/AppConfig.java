package com.hype.webmvc.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;

@Configuration
@EnableAsync
@EnableScheduling
public class AppConfig {

    @Scheduled(cron = "@daily")
    public void getDailyTVUpdates() throws IOException {
        String url = UriComponentsBuilder.fromUriString("https://api.tvmaze.com/schedule/web")
                // .queryParam("date", LocalDate.now().toString())
                .toUriString();
        RequestEntity<Void> req = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        RestTemplate temp = new RestTemplate();
        ResponseEntity<String> resp = temp.exchange(req, String.class);

        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonArray resultarray = reader.readArray();
            for (int i = 0; i < resultarray.size(); i++) {
                
            }
        }
    }

    @Scheduled(cron = "0 0 */3 * * *")
    public void updateMembershipExpiration() {

    }

    @Scheduled(cron = "0 */5 * * * *")
    public void refreshPopularCount() {

    }
}
