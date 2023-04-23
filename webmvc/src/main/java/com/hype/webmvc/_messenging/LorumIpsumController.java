package com.hype.webmvc._messenging;

import java.time.Duration;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;

@Controller
public class LorumIpsumController {
    @MessageMapping("/lipsum")
    public Flux<String> sampleMessage() {
        return Flux.just(
                LorumIpsumText.sample.split(". "))
                .delayElements(Duration.ofMillis(100));
    }
}
