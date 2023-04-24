package com.hype.webmvc._messenging;

import java.time.Duration;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;

@Controller
public class SampleMessageController {
    @MessageMapping("/lipsum")
    public Flux<String> sampleMessage() {
        return Flux.just(
                SampleTexts.loremipsum.split(". "))
                .delayElements(Duration.ofMillis(100));
    }

    @MessageMapping("/homepage")
    public Flux<String> sampleHomePageMessages() {
        return Flux.just(
                SampleTexts.presentation.split(". "))
                .delayElements(Duration.ofMillis(100)).repeat();
    }
}
