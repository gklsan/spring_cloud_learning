package com.gklsan.learninggokul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

//    @Bean
//    public WebClient webClient() {
//        return WebClient.create();
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}