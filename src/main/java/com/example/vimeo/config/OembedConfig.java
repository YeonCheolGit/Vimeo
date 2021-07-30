package com.example.vimeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OembedConfig {

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
