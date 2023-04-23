package com.hype.webmvc._external;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;

public class tvshowservice {

    public void gettodaysshows() throws IOException {

        String url = UriComponentsBuilder.fromUriString("https://api.tvmaze.com/schedule/web")
                .queryParam("date", LocalDate.now().toString())
                .toUriString();
        RequestEntity<Void> req = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        RestTemplate temp = new RestTemplate();
        ResponseEntity<String> resp = temp.exchange(req, String.class);

        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(is);
            
            JsonArray data = reader.readArray();
        }
    }
}
