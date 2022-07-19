package com.example.poster_final_project.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private static final String BASE_URL = "http://localhost/classifier";

    private static final String USER_URL = "http://localhost/users";

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(BASE_URL).clientConnector(new ReactorClientHttpConnector()).build();
    }
    
}
