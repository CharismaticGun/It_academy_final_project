package com.example.poster_final_project.configs;

import com.example.poster_final_project.service.mappers.EventFilmsMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }


    @Bean
    public EventFilmsMapper filmsMapper(ModelMapper mapper,WebClient webClient) {
        return new EventFilmsMapper(mapper, webClient);
    }
}
