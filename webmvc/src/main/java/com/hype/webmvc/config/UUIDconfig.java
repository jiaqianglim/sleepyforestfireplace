package com.hype.webmvc.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UUIDconfig {

    @Bean
    @Scope("prototype")
    public String uuidstring() {
        return UUID.randomUUID().toString();
    }
}
