package com.hype.webmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping(value = "topic", produces = "MediaType.APPLICATION_JSON")
public class TopicController {

    @PostMapping("/new")
    public ResponseEntity<String> postNewTopic(@RequestBody String payload) {
        return ResponseEntity.created(null).body(null);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> searchByName(@PathParam("name") String name) {
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchByTerm(@RequestParam String term) {
        return ResponseEntity.ok().body(null);
    }

}
