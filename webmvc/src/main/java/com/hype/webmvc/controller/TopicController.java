package com.hype.webmvc.controller;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hype.webmvc.SvcRepo.TopicRepo;
import com.hype.webmvc.SvcRepo.TopicService;
import com.hype.webmvc.model.TopicCard;

@Controller
@RequestMapping(value = "topic", produces = "MediaType.APPLICATION_JSON")
public class TopicController {

    @Autowired
    TopicRepo topicRepo;

    @Autowired
    TopicService topicSvc;

    @PostMapping("/new")
    public ResponseEntity<String> postNewTopic(@RequestBody String payload) {
        return ResponseEntity.created(null).body(null);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getTopicByName(@PathVariable("name") String name) {
        Optional<Document> result = topicRepo.getTopicByName(name);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.toString());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchTopicsByTerm(@RequestParam String term) {
        List<Document> result = topicRepo.getTopicsBySearchTerm(term);
        return ResponseEntity.ok().body(result.toString());
    }

    @GetMapping("/featuredlist")
    public ResponseEntity<String> getfrontpagetopics() {
        List<TopicCard> frontpagetopics = topicSvc.getfrontpagetopics();
        return ResponseEntity.ok().body(frontpagetopics.toString());
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteTopic(@PathVariable("name") String name) {
        topicRepo.deleteByName(name);
        return ResponseEntity.ok().body("Topic Deleted");
    }

}
