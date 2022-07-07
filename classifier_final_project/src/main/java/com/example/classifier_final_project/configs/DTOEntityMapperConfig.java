package com.example.classifier_final_project.configs;

import com.example.classifier_final_project.service.mappers.ConcertMapper;
import com.example.classifier_final_project.service.mappers.CountryMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DTOEntityMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ConcertMapper concertMapper(ModelMapper mapper) {
        return new ConcertMapper(mapper);
    }

    @Bean
    public CountryMapper countryMapper(ModelMapper mapper){
        return new CountryMapper(mapper);
    }

}
